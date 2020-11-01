package com.example.my_first_java_for_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView txtHello = findViewById(R.id.txtMessage);
        //txtHello.setText("Hello");

        //EditText edtTxtName = findViewById(R.id.edtTxtName);
        //edtTxtName.getText().toString();
    }

    public void onBtnClick(View view) {
        TextView txtHello = findViewById(R.id.txtMessage);
        EditText edtTxtName = findViewById(R.id.edtTxtName);
        txtHello.setText("Hello " + edtTxtName.getText().toString());
    }
}
