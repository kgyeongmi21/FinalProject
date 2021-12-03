package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.finalproject.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonClose.setOnClickListener(v -> finish());
        binding.buttonLearnmore.setOnClickListener(v -> openLink());
        binding.buttonLocation.setOnClickListener(v -> searchLocation());
        binding.buttonReview.setOnClickListener(v -> startThirdActivity());
    }

    public void startThirdActivity() {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    public void finish() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openLink() {
        String url = "https://m.place.naver.com/place/36615340/home?entry=pll";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void searchLocation() {
        String url = "https://map.naver.com/v5/directions/-/14140761.561740886,4507950.517000688,MN%ED%9C%98%ED%8A%B8%EB%8B%88%EC%8A%A4%20%EA%B0%95%EB%82%A8%EC%A0%90,36615340,PLACE_POI/-/transit?c=14139828.7934617,4507950.5170605,15,0,0,0,dh";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}