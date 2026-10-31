package com.davidchura.proyectoloki.models

data class Videojuego(
    val id: Int,
    val nombre: String,
    val desarrollador: String,
    val plataforma: String,
    val anio: Int,
    val duracion_horas: Int,
    val rating: Double,
    val id_genero: Int
)
