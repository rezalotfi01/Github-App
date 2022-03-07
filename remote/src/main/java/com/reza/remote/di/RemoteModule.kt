package com.reza.remote.di

import com.google.gson.Gson
import com.reza.data.RemoteDataSource
import com.reza.remote.ApiService
import com.reza.remote.BuildConfig
import com.reza.remote.data.RemoteDataSourceImpl
import com.reza.remote.utils.NetConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit



const val NETWORK_TIMEOUT = 10L

val remoteModule = module {

    // Provide RemoteDataSource
    single<RemoteDataSource> {
        RemoteDataSourceImpl(get())
    }

    // Provide ApiService
    single {
        Retrofit.Builder()
            .baseUrl(NetConstants.BASE_URL)
            .addConverterFactory(get())
            .client(get())
            .build()
            .create(ApiService::class.java)
    }

    // Provide OkHTTPClient
    single {
        OkHttpClient.Builder()
            .apply {
                if (BuildConfig.DEBUG) {
                    val httpLoggingInterceptor = HttpLoggingInterceptor()
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                    addInterceptor(httpLoggingInterceptor)
                }
                readTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
                writeTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
            }
            .build()
    }

    // Provide Gson
    single {
        Gson()
    }

    // Provide GsonConverterFactory
    single<Converter.Factory> {
        GsonConverterFactory.create(get())
    }

}
