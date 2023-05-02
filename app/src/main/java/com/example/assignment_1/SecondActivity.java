package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView col1;
    TextView col2;
    TextView col3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        col1 = (TextView)findViewById(R.id.col1);
        col2 = (TextView)findViewById(R.id.col2);
        col3 = (TextView)findViewById(R.id.col3);

        Intent intent = getIntent();
        String str = intent.getStringExtra("name");
        String str1 = intent.getStringExtra("dob");
        String str2 = intent.getStringExtra("email");
        col1.setText(str);
        col2.setText(str1);
        col3.setText(str2);
    }
}