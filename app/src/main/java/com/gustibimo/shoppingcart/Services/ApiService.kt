package com.gustibimo.shoppingcart.Services

import com.gustibimo.shoppingcart.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("bestRated")
    fun getProducts(): Call<List<Product>>

}