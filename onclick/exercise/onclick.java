package com.example.my_first_java_for_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnPress(View view) {
        EditText firstName = findViewById(R.id.first_name);
        EditText lastName = findViewById(R.id.last_Name);
        EditText email = findViewById(R.id.email);
        TextView txtFirst = findViewById(R.id.txtFirst);
        TextView txtLast = findViewById(R.id.txtLast);
        TextView txtEmail = findViewById(R.id.txtEmail);

        txtFirst.setText(firstName.getText().toString());
        txtLast.setText(lastName.getText().toString());
        txtEmail.setText(email.getText().toString());
    }

}
