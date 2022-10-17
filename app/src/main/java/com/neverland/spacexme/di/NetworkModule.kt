package com.neverland.spacexme.di

import com.neverland.spacexme.BuildConfig
import com.neverland.spacexme.data.CompanyInfoService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideCompanyInfoService(retrofit: Retrofit): CompanyInfoService =
        retrofit.create(CompanyInfoService::class.java)

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }.let {
                okHttpBuilder.addInterceptor(it)
            }
        }

        return okHttpBuilder.build()
    }

    companion object {
        private const val READ_TIMEOUT_SECONDS = 30L
        private const val CONNECT_TIMEOUT_SECONDS = 30L
    }

}