package com.appscloud.userssharedpreference

//la palabra reservada data convierte nuestra clase en una clase que esta especializada en un modelo de datos para kotlin
data class Usuario(val id: Long, var name: String, var lastName: String, var url: String) {

    fun getFullName(): String = "$name $lastName" // devuelve un dato de tipo string

}