package com.example.blogapplication.ResponseModel

data class RegisterResponseModel(
    val about: String,
    val email: String,
    val id: Int,
    val name: String,
    val password: String
)