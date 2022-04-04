package com.example.coding_test_mobile.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.coding_test_mobile.R
import com.example.coding_test_mobile.databinding.ActivityMainBinding
import com.example.coding_test_mobile.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.mainRemittanceAmountEnter.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                try {
                    val money = binding.mainRemittanceAmountEnter.text.toString().toInt()
                    if (money > 10000 || binding.mainRemittanceAmountEnter.text.toString()
                            .count() > 5
                    ) {
                        Toast.makeText(this@MainActivity, "송금액이 바르지 않습니다", Toast.LENGTH_SHORT)
                            .show()
                        viewModel.exchangeMoney.value = "10000"
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        })

        val nations = arrayOf("한국(KRW)", "일본(JPY)", "필리핀(PHP)")

        binding.mainNationPicker.minValue = 0
        binding.mainNationPicker.maxValue = 2
        binding.mainNationPicker.displayedValues = nations
        binding.mainNationPicker.wrapSelectorWheel = true

        binding.mainNationPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            viewModel.changeNation(nations[newVal])
        }




        viewModel.getExchangeInfoModel()
    }
}