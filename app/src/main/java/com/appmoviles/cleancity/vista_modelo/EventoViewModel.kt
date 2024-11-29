package com.appmoviles.cleancity.vista_modelo

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appmoviles.cleancity.modelo.entidades.Evento
import com.appmoviles.cleancity.modelo.repositorios.EventoRepository
import com.appmoviles.cleancity.modelo.repositorios.NotificacionRepository
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class EventoViewModel : ViewModel() {

}
