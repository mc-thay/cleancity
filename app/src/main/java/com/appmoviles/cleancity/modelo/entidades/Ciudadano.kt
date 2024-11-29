package com.appmoviles.cleancity.modelo.entidades

class Ciudadano {
    var nombre: String = "" // Nombre del ciudadano
    var email: String = "" // Email del ciudadano
    var fotoPerfil: String = "" // URL de la foto de perfil
    var reportesSeguidos: MutableList<String> = mutableListOf() // Lista de IDs de reportes seguidos por el ciudadano
    var misReportes: MutableList<String> = mutableListOf() // Lista de IDs de reportes creados por el ciudadano
    var eventosParticipados: MutableList<String> = mutableListOf() // Lista de IDs de eventos en los que el ciudadano ha participado

    // Constructor sin argumentos necesario para Firestore
    constructor()

    // Constructor para inicializar todos los atributos
    constructor(
        nombre: String = "",
        email: String = "",
        fotoPerfil: String = "",
        reportesSeguidos: MutableList<String> = mutableListOf(),
        misReportes: MutableList<String> = mutableListOf(),
        eventosParticipados: MutableList<String> = mutableListOf()
    ) {
        this.nombre = nombre
        this.email = email
        this.fotoPerfil = fotoPerfil
        this.reportesSeguidos = reportesSeguidos
        this.misReportes = misReportes
        this.eventosParticipados = eventosParticipados
    }
}
