package com.compose.books.di

import com.compose.books.BuildConfig
import com.compose.books.common.Constants
import com.compose.books.data.remote.BooksApi
import com.compose.books.data.repository.BooksRepositoryImp
import com.compose.books.domain.repository.BooksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(): BooksApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BAE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
            .create(BooksApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBooksRepository(api: BooksApi): BooksRepository {
        return BooksRepositoryImp(api = api)
    }
}