package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected View content;
    EditText inputname, inputdate, inputemail;
    Button submitbtn;

    private DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputname = (EditText) findViewById(R.id.inputname);
        EditText inputdate = (EditText) findViewById(R.id.inputdate);
        EditText inputemail = (EditText) findViewById(R.id.inputemail);
        submitbtn = findViewById(R.id.submitbtn);

        dbHandler = new DBHandler(MainActivity.this);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
                dbHandler.submitbtn(inputname, inputdate, inputemail);

                Toast.makeText(MainActivity.this, "Details added successfully", Toast.LENGTH_SHORT).show();
                inputname.setText("");
                inputdate.setText("");
                inputemail.setText("");
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(inputname)) {
            Toast t = Toast.makeText(this, "You must enter name to register!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(inputdate)) {
            inputdate.setError("Date of birth is required!");
        }

        if (isEmail(inputemail) == false) {
            inputemail.setError("Enter valid email!");
        }
            String name = inputname.getText().toString();
            String dob = inputdate.getText().toString();
            String email = inputemail.getText().toString();
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("dob", dob);
            intent.putExtra("email", email);
            startActivity(intent);

    }
}

