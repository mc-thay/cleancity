package com.appmoviles.cleancity.vista.administrador

import android.app.Activity
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.location.Geocoder
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.appmoviles.cleancity.R
import com.appmoviles.cleancity.databinding.FragmentAdminEventosDetalleBinding
import com.appmoviles.cleancity.modelo.entidades.Evento
import com.appmoviles.cleancity.vista.municipalidad.adaptadores.ParticipantesAdapter
import com.appmoviles.cleancity.vista_modelo.EventoViewModel
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.Timestamp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class AdminEventosDetalleFragment : Fragment(), OnMapReadyCallback {

    private val args: AdminEventosDetalleFragmentArgs by navArgs()
    private val eventoViewModel: EventoViewModel by viewModels()
    private lateinit var binding: FragmentAdminEventosDetalleBinding
    private lateinit var participantesAdapter: ParticipantesAdapter
    private var googleMap: GoogleMap? = null
    private var eventoActual: Evento? = null
    private var selectedImageUri: Uri? = null
    private var currentPhotoPath: String? = null
    override fun onMapReady(p0: GoogleMap) {
        TODO("Not yet implemented")
    }
}
