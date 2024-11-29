package com.appmoviles.cleancity.modelo.entidades

import com.google.firebase.Timestamp
import com.google.firebase.firestore.GeoPoint

data class Evento(
    var id: String = "", // ID del evento
    var municipalidadId: String = "", // ID de la municipalidad que creó el evento
    var titulo: String = "", // Título del evento
    var descripcion: String = "", // Descripción del evento
    var fechaEvento: Timestamp = Timestamp.now(), // Fecha del evento
    var horaEvento: String = "", // Hora del evento
    var equipamiento: String = "", // Equipamiento necesario para el evento
    var ubicacion: GeoPoint = GeoPoint(0.0, 0.0), // Ubicación geográfica del evento
    var direccion: String = "", // Dirección del evento
    var fotos: List<String> = listOf(), // Lista de URLs de fotos del evento
    var participantes: MutableList<String> = mutableListOf(), // Lista de IDs de participantes del evento
    var estado: String = "", // Estado del evento (programado, completado, etc.)
    var fechaCreacion: Timestamp = Timestamp.now(), // Fecha de creación del evento
    var fechaUltimoCambioEstado: Timestamp = Timestamp.now() // Fecha del último cambio de estado
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Evento

        if (id != other.id) return false
        if (municipalidadId != other.municipalidadId) return false
        if (titulo != other.titulo) return false
        if (descripcion != other.descripcion) return false
        if (fechaEvento != other.fechaEvento) return false
        if (horaEvento != other.horaEvento) return false
        if (equipamiento != other.equipamiento) return false
        if (ubicacion != other.ubicacion) return false
        if (direccion != other.direccion) return false
        if (fotos != other.fotos) return false
        if (participantes != other.participantes) return false
        if (estado != other.estado) return false
        if (fechaCreacion != other.fechaCreacion) return false
        if (fechaUltimoCambioEstado != other.fechaUltimoCambioEstado) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + municipalidadId.hashCode()
        result = 31 * result + titulo.hashCode()
        result = 31 * result + descripcion.hashCode()
        result = 31 * result + fechaEvento.hashCode()
        result = 31 * result + horaEvento.hashCode()
        result = 31 * result + equipamiento.hashCode()
        result = 31 * result + ubicacion.hashCode()
        result = 31 * result + direccion.hashCode()
        result = 31 * result + fotos.hashCode()
        result = 31 * result + participantes.hashCode()
        result = 31 * result + estado.hashCode()
        result = 31 * result + fechaCreacion.hashCode()
        result = 31 * result + fechaUltimoCambioEstado.hashCode()
        return result
    }
}
