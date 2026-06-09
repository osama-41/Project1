package com.training.ptojectone.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.training.ptojectone.R
import com.training.ptojectone.databinding.ActivityMainBinding
import com.training.ptojectone.ui.main.adapter.AchievementAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        initObservers()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initObservers() {
        viewModel.achievementsSuccessLiveData.observe(this) { response ->
            binding.recyclerViewAchievement.adapter = AchievementAdapter(response)
        }
        viewModel.achievementsErrorLiveData.observe(this) { e ->
            Toast.makeText(this,"error=${e.localizedMessage}", Toast.LENGTH_LONG).show()
        }

        viewModel.achievementsLoadingLiveData.observe(this) { show ->
                binding.progressCircular.isVisible = show

        }
    }
}