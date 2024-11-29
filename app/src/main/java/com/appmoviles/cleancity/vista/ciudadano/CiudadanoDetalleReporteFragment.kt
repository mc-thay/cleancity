package com.appmoviles.cleancity.vista.ciudadano

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.appmoviles.cleancity.R
import com.appmoviles.cleancity.modelo.entidades.Notificacion
import com.appmoviles.cleancity.modelo.entidades.Reporte
import com.appmoviles.cleancity.vista.inicioaplicacion.AuthUtil
import com.appmoviles.cleancity.vista_modelo.CiudadanoViewModel
import com.appmoviles.cleancity.vista_modelo.ReporteViewModel
import com.appmoviles.cleancity.vista_modelo.NotificacionViewModel
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore

class CiudadanoDetalleReporteFragment {}
