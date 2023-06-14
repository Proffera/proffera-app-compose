package com.example.proffera.data.remote.retrofit

import com.example.proffera.data.remote.response.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    suspend fun loginWithEmailPassword(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse
}