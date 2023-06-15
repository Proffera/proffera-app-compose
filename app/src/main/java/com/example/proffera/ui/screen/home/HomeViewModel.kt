package com.example.proffera.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proffera.data.AuthRepo
import com.example.proffera.data.ProfferaRepo
import com.example.proffera.data.remote.response.ProcurementResponse
import com.example.proffera.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authRepo: AuthRepo,
    private val profferaRepo: ProfferaRepo
) : ViewModel() {
    private val _procurementsState: MutableStateFlow<UiState<List<ProcurementResponse>>> =
        MutableStateFlow(UiState.Loading)
    val procurementsState: StateFlow<UiState<List<ProcurementResponse>>> = _procurementsState

    fun getAllProcurements() {
        viewModelScope.launch {
            _procurementsState.value = UiState.Loading
            try {
                val token = authRepo.getAuthToken().firstOrNull() // Retrieve user token
                if (token != null) {
                    profferaRepo.getAllProcurements(token)
                        .catch { e ->
                            emit(Result.failure(e))
                        }
                        .collect { result ->
                            result.onSuccess {
                                _procurementsState.value = UiState.Success(it)
                            }
                            result.onFailure {
                                _procurementsState.value =
                                    UiState.Error(it.message ?: "An error occurred")
                            }
                        }
                } else {
                    _procurementsState.value =
                        UiState.Error("User token not found") // Handle when token is null
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _procurementsState.value = UiState.Error(e.message ?: "An error occurred")
            }
        }
    }
}



