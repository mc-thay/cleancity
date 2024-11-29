package com.appmoviles.cleancity.vista_modelo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appmoviles.cleancity.modelo.entidades.Ciudadano
import com.appmoviles.cleancity.modelo.entidades.Evento
import com.appmoviles.cleancity.modelo.entidades.Reporte
import com.appmoviles.cleancity.modelo.repositorios.CiudadanoRepository
import com.appmoviles.cleancity.modelo.repositorios.EventoRepository
import com.appmoviles.cleancity.modelo.repositorios.ReporteRepository
import com.appmoviles.cleancity.vista.inicioaplicacion.AuthUtil
import kotlinx.coroutines.launch

class CiudadanoPerfilViewModel : ViewModel() {

}