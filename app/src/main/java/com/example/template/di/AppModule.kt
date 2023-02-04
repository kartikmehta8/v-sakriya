package com.example.template.di

import android.content.Context
import com.example.template.utils.DispatcherProvider
import com.google.gson.Gson
import com.example.template.utils.constants.EndPoints.DEVELOPMENT_BASE_URL
import com.example.template.utils.constants.EndPoints.HTTP_BASE_URL
import com.example.template.utils.constants.EndPoints.USE_DEVELOPMENT



import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(  if(USE_DEVELOPMENT) DEVELOPMENT_BASE_URL else HTTP_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()



    @Singleton
    @Provides
    fun provideDispatcherProvider(): DispatcherProvider {
        return object : DispatcherProvider {
            override val main: CoroutineDispatcher
                get() = Dispatchers.Main
            override val io: CoroutineDispatcher
                get() = Dispatchers.IO
            override val default: CoroutineDispatcher
                get() = Dispatchers.Default
        }
    }

}