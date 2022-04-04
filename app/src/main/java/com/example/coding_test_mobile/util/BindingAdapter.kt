package com.example.coding_test_mobile.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.coding_test_mobile.domain.model.ExchangeDataModel
import java.text.DecimalFormat

object BindingAdapter {
    @JvmStatic
    @BindingAdapter(value = ["app:nation", "app:data"], requireAll = true)
    fun exchangeMoney(
        textView: TextView,
        nation: String?,
        data: ExchangeDataModel?

    ) {
        val decimal = DecimalFormat("#,###.00")
        when (nation) {
            "한국(KRW)" -> {
                if (data != null) {
                    textView.text = "환율 : " + decimal.format(data.usaToKor) + "KRW / USD"
                }
            }
            "일본(JPY)" -> {
                if (data != null) {
                    textView.text = "환율 : " + decimal.format(data.usaToJpn) + "JPY / USD"
                }

            }
            "필리핀(PHP)" -> {
                if (data != null) {
                    textView.text = "환율 : " + decimal.format(data.usaToPhp) + "PHP / USD"
                }

            }
            else -> {

            }
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["app:changeNation", "app:changeData", "app:money"], requireAll = true)
    fun exchangeMoney(
        textView: TextView,
        nation: String?,
        data: ExchangeDataModel?,
        money: String
    ) {
        val decimal = DecimalFormat("#,###.00")
        when (nation) {
            "한국(KRW)" -> {
                if (data != null) {
                    try {
                        val numMoney = money.toFloat()
                        val changeMoney = numMoney * data.usaToKor

                        textView.text = "수취금액은 " + decimal.format(changeMoney) + "KRW 입니다"
                    } catch (e: Exception) {
                        textView.text = "수취금액은 0.00 KRW 입니다"
                        e.printStackTrace()
                    }
                }
            }
            "일본(JPY)" -> {
                if (data != null) {
                    try {
                        val numMoney = money.toFloat()
                        val changeMoney = numMoney * data.usaToJpn

                        textView.text = "수취금액은 " + decimal.format(changeMoney) + "JPY 입니다"
                    } catch (e: Exception) {
                        textView.text = "수취금액은 0.00 JPY 입니다"
                        e.printStackTrace()
                    }
                }
            }
            "필리핀(PHP)" -> {
                if (data != null) {
                    try {
                        val numMoney = money.toFloat()
                        val changeMoney = numMoney * data.usaToPhp

                        textView.text = "수취금액은 " + decimal.format(changeMoney) + "PHP 입니다"
                    } catch (e: Exception) {
                        textView.text = "수취금액은 0.00 PHP 입니다"
                        e.printStackTrace()
                    }
                }
            }
            else -> {

            }
        }

    }

}