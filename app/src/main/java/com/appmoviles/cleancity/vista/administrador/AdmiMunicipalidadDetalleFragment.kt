package com.appmoviles.cleancity.vista.administrador

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.appmoviles.cleancity.R
import com.appmoviles.cleancity.vista_modelo.MunicipalidadViewModel
import com.bumptech.glide.Glide

class AdmiMunicipalidadDetalleFragment : Fragment() {

    private val args: AdmiMunicipalidadDetalleFragmentArgs by navArgs()
    private lateinit var municipalidadViewModel: MunicipalidadViewModel
    private lateinit var fotoPerfil: ImageView
    private lateinit var nombre: TextView
    private lateinit var ciudad: TextView
    private lateinit var email: TextView

}
