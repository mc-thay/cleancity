package com.appmoviles.cleancity.vista.inicioaplicacion

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.appmoviles.cleancity.R
import com.appmoviles.cleancity.vista.administrador.AdmiActivity
import com.appmoviles.cleancity.vista.ciudadano.CiudadanoActivity
import com.appmoviles.cleancity.vista.municipalidad.MunicipalidadActivity
import com.appmoviles.cleancity.vista_modelo.LoginViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModels() // Instancia de LoginViewModel
    private lateinit var googleSignInClient: GoogleSignInClient // Cliente para Google Sign-In

    private val signInLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)
            account?.idToken?.let {
                loginViewModel.loginWithGoogle(it)
            }
        } catch (e: ApiException) {
            Snackbar.make(requireView(), "Error al iniciar sesión con Google", Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)

        val emailInput = view.findViewById<EditText>(R.id.correo_input_login)
        val passwordInput = view.findViewById<EditText>(R.id.contraseña_input_login)
        val loginButton = view.findViewById<Button>(R.id.boton_iniciar_sesion)
        val googleLoginButton = view.findViewById<Button>(R.id.boton_iniciar_congoogle)
        val registerText = view.findViewById<TextView>(R.id.registrarse)
        val forgotPasswordText = view.findViewById<TextView>(R.id.forgot_password)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Snackbar.make(view, "Por favor, ingrese su correo y contraseña", Snackbar.LENGTH_LONG).show()
            } else {
                loginViewModel.loginWithEmailPassword(email, password)
            }
        }

        googleLoginButton.setOnClickListener {
            val signInIntent = googleSignInClient.signInIntent
            signInLauncher.launch(signInIntent)
        }

        registerText.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        forgotPasswordText.setOnClickListener {
            val email = emailInput.text.toString()
            if (email.isEmpty()) {
                Snackbar.make(view, "Por favor, ingrese su correo electrónico", Snackbar.LENGTH_LONG).show()
            } else {
                loginViewModel.enviarCorreoRecuperacion(email)
            }
        }

        // Observa los cambios en userLiveData y navega si el usuario se autentica correctamente
        loginViewModel.userLiveData.observe(viewLifecycleOwner) { user ->
            user?.let { firebaseUser ->
                // Verificar si el usuario está en la colección de administradores
                loginViewModel.obtenerUsuarioAdministradorPorId(firebaseUser.uid, { _ ->
                    // Si el usuario es un administrador, navegar a AdmiActivity
                    val intent = Intent(requireContext(), AdmiActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }, {
                    // Si no es un administrador, verificar si es una municipalidad
                    loginViewModel.obtenerUsuarioMunicipalidadPorId(firebaseUser.uid, { _ ->
                        // Si el usuario es una municipalidad, navegar a MunicipalidadActivity
                        val intent = Intent(requireContext(), MunicipalidadActivity::class.java)
                        startActivity(intent)
                        requireActivity().finish()
                    }, {
                        // Si no es una municipalidad, navegar a CiudadanoActivity
                        val intent = Intent(requireContext(), CiudadanoActivity::class.java)
                        startActivity(intent)
                        requireActivity().finish()
                    })
                })
            }
        }

        // Observa los errores y muestra un mensaje de error si ocurre alguno
        loginViewModel.errorLiveData.observe(viewLifecycleOwner) { error ->
            error?.let {
                Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
            }
        }

        return view
    }
}
