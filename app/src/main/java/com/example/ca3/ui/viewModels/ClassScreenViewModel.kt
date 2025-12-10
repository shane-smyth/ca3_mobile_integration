package com.example.ca3.ui.viewModels

import android.net.http.HttpEngine
import androidx.lifecycle.ViewModel
import com.example.ca3.model.SubjectClass
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
//import com.example.ca3.network.ClassInfoApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface ClassScreenUiState {
    data class Success(val classes: List<SubjectClass>) : ClassScreenUiState
    object Error : ClassScreenUiState
    object Loading : ClassScreenUiState
}

/*
class ClassScreenViewModel : ViewModel() {
    var classScreenUiState by mutableStateOf(ClassScreenUiState.Loading)
        private set


    init {
        getAllClasses()
    }
    private fun getAllClasses() {
        viewModelScope.launch {
            classScreenUiState = ClassScreenUiState.Loading



            classScreenUiState = try {
                val listResult = ClassInfoApi.retrofitService.getClasses()

                ClassScreenUiState.Success(listResult)
            }
            catch (e: IOException) {
                ClassScreenUiState.Error
            }
            catch (e: HttpException) {
                ClassScreenUiState.Error
            }
        }
    }
*/
