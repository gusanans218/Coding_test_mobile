package com.example.coding_test_mobile.domain

import com.example.coding_test_mobile.domain.model.ExchangeInfoModel

interface ExchangeRepository {
    suspend fun getExchangeInfo(): ExchangeInfoModel?
}