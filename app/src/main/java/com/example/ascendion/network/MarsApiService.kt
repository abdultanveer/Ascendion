package com.example.ascendion.network

import retrofit2.converter.scalars.ScalarsConverterFactory

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

import retrofit2.Retrofit

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService {
    fun getPhotos()

}