package com.appmoviles.cleancity.vista.inicioaplicacion

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.appmoviles.cleancity.R
import com.appmoviles.cleancity.vista.administrador.AdmiActivity
import com.appmoviles.cleancity.vista.ciudadano.CiudadanoActivity
import com.appmoviles.cleancity.vista.municipalidad.MunicipalidadActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializar Firebase
        FirebaseApp.initializeApp(this)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Configuración de Firestore (opcional)
        val settings = FirebaseFirestoreSettings.Builder()
            .setPersistenceEnabled(true)
            .build()
        db.firestoreSettings = settings

        // Crear administrador de prueba
        //createAdminUser()

        // Llama a checkAuthentication solo después de asegurarte de que el navController está inicializado
        checkAuthentication()
    }

    private fun createAdminUser() {
        val adminEmail = "admin@example.com"
        val adminPassword = "admin1234"

        auth.fetchSignInMethodsForEmail(adminEmail).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val signInMethods = task.result?.signInMethods
                if (signInMethods.isNullOrEmpty()) {
                    // No existe el usuario administrador, crear uno nuevo
                    auth.createUserWithEmailAndPassword(adminEmail, adminPassword)
                        .addOnCompleteListener { createTask ->
                            if (createTask.isSuccessful) {
                                val newUser = createTask.result?.user
                                newUser?.let { firebaseUser ->
                                    val adminData = hashMapOf(
                                        "email" to firebaseUser.email,
                                        "nombre" to "Admin User",
                                        "role" to "admin"
                                    )
                                    db.collection("administradores").document(firebaseUser.uid)
                                        .set(adminData)
                                        .addOnCompleteListener {
                                            // Cerrar sesión para no mantener al administrador autenticado
                                            auth.signOut()
                                        }
                                }
                            }
                        }
                } else {
                    // El administrador ya existe, no hacer nada y asegurarse de que no haya ninguna sesión iniciada
                    auth.signOut()
                }
            } else {
                task.exception?.printStackTrace()
            }
        }
    }

    private fun checkAuthentication() {
        if (!AuthUtil.isUserAuthenticated()) {
            // Redirigir al usuario a la pantalla de inicio de sesión
            navController.navigate(R.id.loginFragment)
        } else {
            // El usuario está autenticado, obtener el usuario actual
            val currentUser = AuthUtil.getCurrentUser()
            currentUser?.let {
                // El usuario está autenticado, verificar el tipo de usuario
                val userId = it.uid
                checkUserType(userId)
            } ?: run {
                // Redirigir al usuario a la pantalla de inicio de sesión si currentUser es null por alguna razón
                navController.navigate(R.id.loginFragment)
            }
        }
    }

    private fun checkUserType(userId: String) {
        db.collection("usuarios_ciudadanos").document(userId).get()
            .addOnSuccessListener { ciudadanoDocument ->
                if (ciudadanoDocument.exists()) {
                    // Usuario es un ciudadano
                    Log.d("MainActivity", "Usuario encontrado en ciudadanos: $userId")
                    val intent = Intent(this, CiudadanoActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // No encontrado en ciudadanos, verificar municipalidades
                    Log.d("MainActivity", "Usuario no encontrado en ciudadanos, verificando municipalidades")
                    db.collection("usuarios_municipalidades").document(userId).get()
                        .addOnSuccessListener { municipalidadDocument ->
                            if (municipalidadDocument.exists()) {
                                // Usuario es una municipalidad
                                Log.d("MainActivity", "Usuario encontrado en municipalidades: $userId")
                                val intent = Intent(this, MunicipalidadActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                // No encontrado en municipalidades, verificar administradores
                                Log.d("MainActivity", "Usuario no encontrado en municipalidades, verificando administradores")
                                db.collection("administradores").document(userId).get()
                                    .addOnSuccessListener { administradorDocument ->
                                        if (administradorDocument.exists()) {
                                            // Usuario es un administrador
                                            Log.d("MainActivity", "Usuario encontrado en administradores: $userId")
                                            val intent = Intent(this, AdmiActivity::class.java)
                                            startActivity(intent)
                                            finish()
                                        } else {
                                            // Usuario no encontrado en ninguna colección
                                            Log.e("MainActivity", "Usuario no encontrado en ninguna colección: $userId")
                                            auth.signOut()
                                            navController.navigate(R.id.loginFragment)
                                        }
                                    }
                                    .addOnFailureListener { e ->
                                        Log.e("MainActivity", "Error al verificar administrador: ${e.message}")
                                        auth.signOut()
                                        navController.navigate(R.id.loginFragment)
                                    }
                            }
                        }
                        .addOnFailureListener { e ->
                            Log.e("MainActivity", "Error al verificar municipalidad: ${e.message}")
                            auth.signOut()
                            navController.navigate(R.id.loginFragment)
                        }
                }
            }
            .addOnFailureListener { e ->
                Log.e("MainActivity", "Error al verificar ciudadano: ${e.message}")
                auth.signOut()
                navController.navigate(R.id.loginFragment)
            }
    }

}
