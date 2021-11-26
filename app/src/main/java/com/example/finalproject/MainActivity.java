package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.finalproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageMNfitness.setOnClickListener(v ->startSecondActivity());
    }

    public void startSecondActivity() {
        String message = binding.textMNfitness.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        intent.putExtra("MNfitness", message);
    }
}