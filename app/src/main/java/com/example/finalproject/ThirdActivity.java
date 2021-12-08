package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Toast;

import com.example.finalproject.databinding.ActivityMainBinding;
import com.example.finalproject.databinding.ActivitySecondBinding;
import com.example.finalproject.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity {
    ActivityThirdBinding binding;
    private int likecount = 0;
    private int dislikecount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.reviewText.setMovementMethod(new ScrollingMovementMethod());
        binding.buttonSend.setOnClickListener(v -> send());
        binding.likeButton.setOnClickListener(v -> pluscounter());
        binding.dislikeButton.setOnClickListener(v -> minuscounter());

        binding.buttonCloseThird.setOnClickListener(v -> finish());
    }

    private void moveScroll() {
        final int scrollAmount = binding.reviewText.getLayout().getLineTop(binding.reviewText.getLineCount()) - binding.reviewText.getHeight();
        if (scrollAmount > 0)
            binding.reviewText.scrollTo(0, scrollAmount);
        else
            binding.reviewText.scrollTo(0,0);
    }

    private void pluscounter() {
        likecount++;
        updatelikeCount();
    }

    private void minuscounter() {
        dislikecount++;
        updatedislikeCount2();
    }

    private void updatelikeCount() {
        binding.likeAmount.setText(Integer.toString(likecount));
    }

    private void updatedislikeCount2() {
        binding.dislikeAmount.setText(Integer.toString(dislikecount));
    }

    public void finish() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    private void send() {
        String message = binding.chatBar.getText().toString();
        if (message.isEmpty()) {
            Toast.makeText(this, "리뷰를 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        binding.reviewText.setText(binding.reviewText.getText() + "경미: " + message + '\n');
        binding.chatBar.setText("");
        moveScroll();
    }
}