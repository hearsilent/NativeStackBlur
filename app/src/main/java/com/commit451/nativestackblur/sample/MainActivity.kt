package com.commit451.nativestackblur.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.commit451.nativestackblur.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val ImageUrl =
            "https://pbs.twimg.com/profile_images/1164525925242986497/N5_DCXYQ_400x400.jpg"
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