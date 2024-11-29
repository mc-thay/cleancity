package com.appmoviles.cleancity.vista.inicioaplicacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import androidx.navigation.fragment.findNavController
import com.appmoviles.cleancity.R
import com.appmoviles.cleancity.vista_modelo.RegisterViewModel
import com.google.android.material.snackbar.Snackbar

class RegisterFragment : Fragment() {

    private val registerViewModel: RegisterViewModel by viewModels() // Instancia del ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        // Referencias a los elementos de la vista
        val nombreInput = view.findViewById<EditText>(R.id.nombreuser_input_registro)
        val emailInput = view.findViewById<EditText>(R.id.correo_input_registro)
        val passwordInput = view.findViewById<EditText>(R.id.contraseña_input_registro)
        val confirmPasswordInput = view.findViewById<EditText>(R.id.confirmar_contraseña_input_registro)
        val registerButton = view.findViewById<Button>(R.id.boton_registar)
        val termsText = view.findViewById<TextView>(R.id.terminos_uso)
        val loginText = view.findViewById<TextView>(R.id.acceder)

        // Click listener para el botón de registro
        registerButton.setOnClickListener {
            val nombre = nombreInput.text.toString()
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            val confirmPassword = confirmPasswordInput.text.toString()

            // Validación de campos vacíos
            if (nombre.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Snackbar.make(view, "Por favor, complete todos los campos", Snackbar.LENGTH_LONG).show()
            } else if (password != confirmPassword) {
                Snackbar.make(view, "Las contraseñas no coinciden", Snackbar.LENGTH_LONG).show()
            } else {
                registerViewModel.registerWithEmailPassword(nombre, email, password)
            }
        }

        // Click listener para el texto de términos de uso
        termsText.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_politicaDePrivacidadFragment)
        }

        // Click listener para el texto de iniciar sesión
        loginText.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        // Observa los cambios en userLiveData y navega si el registro es exitoso
        registerViewModel.userLiveData.observe(viewLifecycleOwner) { user ->
            user?.let {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }

        // Observa los errores y muestra un mensaje de error si ocurre alguno
        registerViewModel.errorLiveData.observe(viewLifecycleOwner) { error ->
            error?.let {
                Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
            }
        }

        return view
    }
}