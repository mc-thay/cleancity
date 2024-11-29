package com.appmoviles.cleancity.modelo.entidades

class Municipalidad {
    var nombre: String = "" // Nombre de la municipalidad
    var ciudad: String = "" // Nombre de la ciudad
    var email: String = "" // Email de la municipalidad
    var fotoPerfil: String = "" // URL de la foto de perfil
    var eventosCreados: List<String> = listOf() // Lista de IDs de eventos creados por la municipalidad

    // Constructor sin argumentos necesario para Firestore
    constructor()

    // Constructor para inicializar todos los atributos
    constructor(
        nombre: String,
        ciudad: String,
        email: String,
        fotoPerfil: String = "",
        eventosCreados: List<String> = listOf()
    ) {
        this.nombre = nombre
        this.ciudad= ciudad
        this.email = email
        this.fotoPerfil = fotoPerfil
        this.eventosCreados = eventosCreados
    }
}