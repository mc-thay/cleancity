package com.appmoviles.cleancity.vista.inicioaplicacion

import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.appmoviles.cleancity.R

class PoliticaDePrivacidadFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_politica_de_privacidad, container, false)

        view.findViewById<ImageView>(R.id.flecha_retroceder_politicas).setOnClickListener {
            findNavController().navigate(R.id.action_politicaDePrivacidadFragment_to_registerFragment)
        }

        // Habilitar los enlaces clickeables en el TextView que contiene la dirección de correo
        val politicasTextView = view.findViewById<TextView>(R.id.politicas11_textview)
        politicasTextView.movementMethod = LinkMovementMethod.getInstance()

        return view
    }
}