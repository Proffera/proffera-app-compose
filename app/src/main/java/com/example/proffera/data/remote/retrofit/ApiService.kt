package com.example.proffera.data.remote.retrofit

import com.example.proffera.data.remote.response.LoginResponse
import com.example.proffera.data.remote.response.ProcurementResponse
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    suspend fun loginWithEmailPassword(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @GET("procurement")
    suspend fun getAllProcurements(
        @Header("Authorization") token: String,
        @Query("page") page: Int?,
        @Query("size") size: Int?
    ): ProcurementResponse
}