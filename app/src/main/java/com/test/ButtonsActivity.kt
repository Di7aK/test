package com.test

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.test.databinding.ActivityButtonsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ButtonsActivity : AppCompatActivity() {
    private var _binding: ActivityButtonsBinding? = null
    private val binding: ActivityButtonsBinding
        get() = requireNotNull(_binding)
    private val viewModel: ButtonsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityButtonsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
    }

    private fun setupObservers() {
        binding.btn1.setOnClickListener {
            viewModel.onBtn1Click()
        }
        binding.btn2.setOnClickListener {
            viewModel.onBtn2Click()
        }
        binding.btn3.setOnClickListener {
            viewModel.onBtn3Click()
        }

        viewModel.isBtn1Clicked.onEach {
            binding.btn1.isEnabled = !it
        }.launchIn(lifecycleScope)

        viewModel.isBtn2Clicked.onEach {
            binding.btn2.isEnabled = !it
        }.launchIn(lifecycleScope)

        viewModel.isBtn3Clicked.onEach {
            binding.btn3.isEnabled = !it
        }.launchIn(lifecycleScope)
    }
}