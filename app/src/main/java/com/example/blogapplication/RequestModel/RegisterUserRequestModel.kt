package com.example.blogapplication.RequestModel

data class RegisterUserRequestModel(
    val about: String,
    val email: String,
    val name: String,
    val password: String
)