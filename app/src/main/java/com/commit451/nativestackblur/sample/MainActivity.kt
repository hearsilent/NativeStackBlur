package com.commit451.nativestackblur.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.commit451.nativestackblur.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val ImageUrl =
            "https://images.unsplash.com/photo-1522648485144-849409408aee?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1180&q=80"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.image.load(ImageUrl)
        binding.blurredImage.load(ImageUrl) {
            transformations(BlurTransformation())
        }
    }
}