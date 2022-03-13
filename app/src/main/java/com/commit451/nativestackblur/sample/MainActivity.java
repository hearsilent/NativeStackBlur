package com.commit451.nativestackblur.sample;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.commit451.nativestackblur.sample.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String url = "https://images.unsplash.com/photo-1522648485144-849409408aee?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1180&q=80";
        Picasso.get()
                .load(url)
                .into(binding.image);
        Picasso.get()
                .load(url)
                .transform(new BlurTransformation(8))
                .into(binding.blurredImage);
    }
}
