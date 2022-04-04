package com.example.coding_test_mobile.data

import com.example.coding_test_mobile.domain.ExchangeRepository
import com.example.coding_test_mobile.domain.model.ExchangeInfoModel

class ExchangeRepositoryImpl(val api: API) : ExchangeRepository {
    override suspend fun getExchangeInfo(): ExchangeInfoModel? {
        return ExchangeMapper.changeExchangeInfo(api.getExchangeInfo().body())
    }
}