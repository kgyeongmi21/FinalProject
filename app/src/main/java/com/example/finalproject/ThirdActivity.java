package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.finalproject.databinding.ActivityMainBinding;
import com.example.finalproject.databinding.ActivitySecondBinding;
import com.example.finalproject.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity {
    ActivityThirdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonCloseThird.setOnClickListener(v -> finish());
    }

    public void finish() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}