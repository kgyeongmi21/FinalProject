package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;

import com.example.finalproject.databinding.FitnessMainBinding;

public class MainFitness extends AppCompatActivity {
    FitnessMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FitnessMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageMNfitness.setOnClickListener(v ->startDetailActivity());
    }


    public void startDetailActivity() {

        Intent intent = new Intent(this, DetailFitness.class);
        startActivity(intent);
    }
}