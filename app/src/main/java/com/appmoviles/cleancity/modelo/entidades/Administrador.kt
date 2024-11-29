package com.appmoviles.cleancity.modelo.entidades

class Administrador {
    var id: String = "" // ID del administrador
    var nombre: String = "" // Nombre del administrador
    var email: String = "" // Email del administrador
    var fotoPerfil: String = "" // URL de la foto de perfil

    constructor()

    constructor(
        id: String,
        nombre: String,
        email: String,
        fotoPerfil: String = ""
    ) {
        this.id = id
        this.nombre = nombre
        this.email = email
        this.fotoPerfil = fotoPerfil
    }
}
