package com.example.proffera.data

import com.example.proffera.data.remote.response.ProcurementResponse
import com.example.proffera.data.remote.retrofit.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProfferaRepo @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getAllProcurements(
        token: String,
        page: Int? = null,
        size: Int? = null
    ): Flow<Result<List<ProcurementResponse>>> = flow {
        try {
            val bearerToken = generateToken(token)
            val response = apiService.getAllProcurements(bearerToken, page, size)
            emit(Result.success(listOf(response)))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.failure(e))
        }
    }

    private fun generateToken(token: String): String {
        return "Bearer $token"
    }
}