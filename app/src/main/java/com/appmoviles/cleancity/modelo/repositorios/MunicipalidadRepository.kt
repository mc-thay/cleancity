package com.appmoviles.cleancity.modelo.repositorios

import android.net.Uri
import android.util.Log
import com.appmoviles.cleancity.modelo.entidades.Municipalidad
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.tasks.await
import java.util.UUID

class MunicipalidadRepository {
    internal  val db = Firebase.firestore // Instancia de Firestore
    internal  val storage = Firebase.storage // Instancia de Firebase Storage
    private val auth: FirebaseAuth = FirebaseAuth.getInstance() // Instancia de FirebaseAuth
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

}