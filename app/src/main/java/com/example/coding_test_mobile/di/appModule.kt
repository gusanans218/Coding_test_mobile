package com.example.coding_test_mobile.di

import android.app.Application
import com.example.coding_test_mobile.data.API
import com.example.coding_test_mobile.data.ExchangeRepositoryImpl
import com.example.coding_test_mobile.domain.ExchangeRepository
import com.example.coding_test_mobile.domain.usecase.GetExchangeInfoUseCase
import com.example.coding_test_mobile.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        GsonConverterFactory.create() as Converter.Factory
    }

    single {
        Retrofit.Builder()
            .addConverterFactory(get())
            .baseUrl("http://api.currencylayer.com/")
            .build()
            .create(API::class.java)
    }

    single {
        val repository: ExchangeRepository = ExchangeRepositoryImpl(get())
        repository
    }

    single {
        GetExchangeInfoUseCase(get())
    }
    viewModel { MainViewModel(get()) }
}