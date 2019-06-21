package com.gustibimo.shoppingcart

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object APIConfig {

    val BASE_URL = "https://all-spices.com/api/products/"

    private var retrofit: Retrofit? = null

    var gson = GsonBuilder().setLenient()
        .create()

    fun getRetroFitClient(context: Context): Retrofit {

        val okHttpClient = OkHttpClient.Builder()
            .build()

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return  retrofit!!
    }

}