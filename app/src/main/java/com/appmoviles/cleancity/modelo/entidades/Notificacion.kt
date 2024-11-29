package com.appmoviles.cleancity.modelo.entidades

import com.google.firebase.Timestamp

class Notificacion(
    var usuarioId: String = "", // ID del usuario que recibe la notificación
    var mensaje: String = "", // Mensaje de la notificación
    var tipo: String = "", // Tipo de notificación (evento, reporte, etc.)
    var leido: Boolean = false, // Estado de lectura de la notificación
    var fechaEnvio: Timestamp = Timestamp.now() // Fecha de envío de la notificación
) {
    // Constructor sin argumentos necesario para Firestore
    constructor() : this("", "", "", false, Timestamp.now())

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Notificacion

        if (usuarioId != other.usuarioId) return false
        if (mensaje != other.mensaje) return false
        if (tipo != other.tipo) return false
        if (leido != other.leido) return false
        if (fechaEnvio != other.fechaEnvio) return false

        return true
    }

    override fun hashCode(): Int {
        var result = usuarioId.hashCode()
        result = 31 * result + mensaje.hashCode()
        result = 31 * result + tipo.hashCode()
        result = 31 * result + leido.hashCode()
        result = 31 * result + fechaEnvio.hashCode()
        return result
    }
}
