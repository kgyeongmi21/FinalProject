package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Toast;
import java.io.File;

import com.example.finalproject.databinding.FitnessReviewBinding;
import com.example.finalproject.utils.FileUtils;

public class ReviewFitness extends AppCompatActivity {
    FitnessReviewBinding binding;
    private int onecount = 0;
    private int likecount = 0;
    private int dislikecount = 0;
    private final String saveReviewData = "memo.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FitnessReviewBinding.inflate(getLayoutInflater());
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
        if (onecount ==0 ) {
            likecount++;
            onecount++;
            updatelikeCount();
        } else {
            Toast.makeText(this, "버튼은 한 번만 누를 수 있습니다", Toast.LENGTH_SHORT).show();
        }
    }

    private void minuscounter() {
        if (onecount ==0 ) {
            dislikecount++;
            onecount++;
            updatedislikeCount2();
        } else {
            Toast.makeText(this, "버튼은 한 번만 누를 수 있습니다", Toast.LENGTH_SHORT).show();
        }

    }

    private void updatelikeCount() {
        binding.likeAmount.setText(Integer.toString(likecount));
    }

    private void updatedislikeCount2() {
        binding.dislikeAmount.setText(Integer.toString(dislikecount));
    }

    public void finish() {
        Intent intent = new Intent(this, DetailFitness.class);
        startActivity(intent);
    }

    private void send() {
        String message = binding.chatBar.getText().toString();
        if (message.isEmpty()) {
            Toast.makeText(this, "리뷰를 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        String ID = binding.personalID.getText().toString();
        if (ID.isEmpty()) {
            Toast.makeText(this, "아이디를 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        String contents = binding.reviewText.getText().toString();
        FileUtils.writeFile(this, saveReviewData, contents);

        binding.reviewText.setText(binding.reviewText.getText() + ID + ": " + message + '\n');
        binding.chatBar.setText("");
        moveScroll();
    }


}