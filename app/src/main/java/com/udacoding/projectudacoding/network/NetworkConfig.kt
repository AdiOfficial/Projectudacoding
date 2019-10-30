package com.udacoding.kitabcommerce.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {



    fun getInterceptor():OkHttpClient{

        var logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
            .addInterceptor(logging)
            .build()
    }


    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://growbackind.com/mapi/index.php/Api/")
            .client(getInterceptor())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


    fun getService() = getRetrofit().create(AppService::class.java)
}