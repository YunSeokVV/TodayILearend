package com.example.kakaoNavigationPractice.di

import com.example.kakaoNavigationPractice.common.Constvalue
import com.example.kakaoNavigationPractice.service.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideOkHttpClient() : OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit =
        Retrofit.Builder()
            // 경수선임은 gSon을 사용했다. Moshi도 결국 JSON을 처리하기 위한 라이브러리인데 한번 비교해보자. 뭐가 더 나은지 ㅇㅇ
            //.addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(Constvalue.BASE_URL)
            .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) : Any {
        return retrofit.create(ApiInterface::class.java)
    }
    // todo : 아래 링크 보고 카카오 길찾기 해보자. 구조는 전부 클린아키텍쳐로 설정하고.
    // https://developers.kakaomobility.com/docs/navi-api/directions/
}