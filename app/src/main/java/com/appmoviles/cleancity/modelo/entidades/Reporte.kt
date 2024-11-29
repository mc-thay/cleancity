package com.appmoviles.cleancity.modelo.entidades

import com.google.firebase.Timestamp
import com.google.firebase.firestore.GeoPoint

data class Reporte(
    var id: String = "", // ID del reporte
    var usuarioId: String = "", // ID del usuario que creó el reporte
    var titulo: String = "", // Título del reporte
    var descripcion: String = "", // Descripción del reporte
    var ubicacion: GeoPoint = GeoPoint(0.0, 0.0), // Ubicación geográfica del reporte
    var direccion: String = "", // Dirección del reporte
    var fotos: List<String> = listOf(), // Lista de URLs de fotos del reporte
    var estado: String = "", // Estado del reporte (pendiente, atendido, etc.)
    var relevancia: String = "", // Relevancia del reporte (alto, medio, bajo)
    var seguidores: MutableList<String> = mutableListOf(), // Lista de IDs de usuarios que siguen el reporte
    var fechaCreacion: Timestamp = Timestamp.now(), // Fecha de creación del reporte
    var ciudad: String = "", // Ciudad del reporte
    var fechaUltimoCambioEstado: Timestamp = Timestamp.now(),
    var comentarios: MutableList<Comentario> = mutableListOf() // Lista de comentarios en el reporte
) {
    constructor() : this(
        id = "",
        usuarioId = "",
        titulo = "",
        descripcion = "",
        ubicacion = GeoPoint(0.0, 0.0),
        direccion = "",
        fotos = listOf(),
        estado = "",
        relevancia = "",
        seguidores = mutableListOf(),
        fechaCreacion = Timestamp.now(),
        ciudad = "",
        fechaUltimoCambioEstado = Timestamp.now(),
        comentarios = mutableListOf()
    )

    data class Comentario(
        var usuarioId: String = "", // ID del usuario que hizo el comentario
        var puntuacion: Int = 0 // Puntuación del comentario
    )
}
