package com.appmoviles.cleancity.vista_modelo

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appmoviles.cleancity.modelo.entidades.Ciudadano
import com.appmoviles.cleancity.modelo.repositorios.CiudadanoRepository
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.storage
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class CiudadanoViewModel : ViewModel() {

}
