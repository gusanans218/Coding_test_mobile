package com.example.coding_test_mobile.data

import com.example.coding_test_mobile.domain.model.ExchangeDataModel
import com.example.coding_test_mobile.domain.model.ExchangeInfoModel

object ExchangeMapper {
    fun changeExchangeInfo(exchangeInfo: ExchangeInfo?): ExchangeInfoModel? {
        if (exchangeInfo == null) {
            return null
        }
        return ExchangeInfoModel(
            success = exchangeInfo.success,
            terms = exchangeInfo.terms,
            privacy = exchangeInfo.privacy,
            timestamp = exchangeInfo.timestamp,
            source = exchangeInfo.source,
            quotes = changeExchangeData(exchangeInfo.quotes)


        )
    }

    fun changeExchangeData(exchangeData: ExchangeData): ExchangeDataModel {
        return ExchangeDataModel(
            usaToKor = exchangeData.usdkrw,
            usaToJpn = exchangeData.usdjpy,
            usaToPhp = exchangeData.usdphp
        )
    }
}