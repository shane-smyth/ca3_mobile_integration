package com.example.ca3.network

import com.example.ca3.model.SubjectClass
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType


import retrofit2.Retrofit
import retrofit2.http.GET


private const val BASE_URL = "https://raw.githubusercontent.com/chealy90/christopherhealy.dev/main/"
private val json = Json { ignoreUnknownKeys = true }


private val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()


interface ClassInfoApiService {
    @GET("mobile_data.json")
    suspend fun getClasses(): List<SubjectClass>
}

object ClassInfoApi {
    val retrofitService : ClassInfoApiService by lazy {
        retrofit.create(ClassInfoApiService::class.java)
    }
}


