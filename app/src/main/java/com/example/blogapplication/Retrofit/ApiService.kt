package com.example.blogapplication.Retrofit

import com.example.blogapplication.RequestModel.RegisterUserRequestModel
import com.example.blogapplication.ResponseModel.RegisterResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService  {

    @POST("auth/register")
    fun register(@Body model: RegisterUserRequestModel): Call<RegisterResponseModel>


}