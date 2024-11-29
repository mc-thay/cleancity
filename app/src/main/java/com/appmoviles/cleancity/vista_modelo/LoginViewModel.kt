package com.appmoviles.cleancity.vista_modelo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appmoviles.cleancity.modelo.entidades.Administrador
import com.appmoviles.cleancity.modelo.entidades.Ciudadano
import com.appmoviles.cleancity.modelo.entidades.Municipalidad
import com.appmoviles.cleancity.modelo.repositorios.AdministradorRepository
import com.appmoviles.cleancity.modelo.repositorios.CiudadanoRepository
import com.appmoviles.cleancity.modelo.repositorios.MunicipalidadRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

}
