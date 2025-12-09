package com.example.ca3.network

import com.example.ca3.model.SubjectClass
import kotlinx.serialization.json.Json

import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = ""
private val json = Json { ignoreUnknownKeys = true }


private val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()


interface ClassInfoApiService {
    @GET("classes")
    suspend fun getClasses(): List<SubjectClass>
}

object ClassInfoApi {
    val retrofitService : ClassInfoApiService by lazy {
        retrofit.create(ClassInfoApiService::class.java)
    }
}