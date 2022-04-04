package com.example.coding_test_mobile.domain.usecase

import com.example.coding_test_mobile.domain.ExchangeRepository
import com.example.coding_test_mobile.domain.Resource
import com.example.coding_test_mobile.domain.model.ExchangeInfoModel

class GetExchangeInfoUseCase(val repository: ExchangeRepository) : UseCase {
    suspend operator fun invoke(): Resource<ExchangeInfoModel?> {
        return try {
            val exchangeInfoModel = repository.getExchangeInfo()
            Resource.success(exchangeInfoModel)
        } catch (e: Exception) {
            Resource.error(e.message.toString())
        }
    }
}