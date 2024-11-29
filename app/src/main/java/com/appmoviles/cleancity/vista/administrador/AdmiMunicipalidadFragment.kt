package com.appmoviles.cleancity.vista.administrador

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.appmoviles.cleancity.R
import com.appmoviles.cleancity.databinding.FragmentAdmiMunicipalidadBinding
import com.appmoviles.cleancity.vista.administrador.adaptadores.AdmiMunicipalidadAdapter
import com.appmoviles.cleancity.vista_modelo.MunicipalidadViewModel

class AdmiMunicipalidadFragment : Fragment() {

    private lateinit var binding: FragmentAdmiMunicipalidadBinding
    private lateinit var municipalidadViewModel: MunicipalidadViewModel
    private lateinit var adapter: AdmiMunicipalidadAdapter

}
