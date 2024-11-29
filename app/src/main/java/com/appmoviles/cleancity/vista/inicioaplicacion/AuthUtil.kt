package com.appmoviles.cleancity.vista.inicioaplicacion

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

object AuthUtil {

    /*
    Este método devuelve un booleano que indica si el usuario actualmente está autenticado en la aplicación.
    Para determinar esto, se utiliza el método currentUser de FirebaseAuth, que devuelve el usuario actualmente autenticado si existe,
    o null si no hay usuario autenticado. Si el usuario es diferente de null, se devuelve true, lo que significa que el usuario está autenticado.
     */
    fun isUserAuthenticated(): Boolean {
        return FirebaseAuth.getInstance().currentUser != null
    }

    fun getCurrentUser(): FirebaseUser? {
        return FirebaseAuth.getInstance().currentUser
    }

    fun getCurrentUserId(): String? {
        return FirebaseAuth.getInstance().currentUser?.uid
    }

    fun signOut() {
        FirebaseAuth.getInstance().signOut()
    }
}