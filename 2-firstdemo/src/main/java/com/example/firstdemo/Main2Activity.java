package com.example.firstdemo;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firstdemo.databinding.ActivityMain2Binding;

public class Main2Activity extends AppCompatActivity {

    public static String RECEIVED_MESSAGE = "Received message";

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        Intent intent = getIntent();
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.previousMessage.setText(intent.getStringExtra(MainActivity.MESSAGE));

        // Initialize the button and set the click listener
        Button button2 = binding.button2;
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToThird = new Intent(Main2Activity.this, MainActivity3.class);
                startActivity(intentToThird);
            }
        });

        // Initialize the button and set the click listener
        Button button3 = binding.button3;
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToHome = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intentToHome);
            }
        });
        // Handle the back press in API > Tiramisu
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(RECEIVED_MESSAGE, "Hello from the second activity.");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }


}
