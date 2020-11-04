package com.example.my_first_java_for_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxHarry, checkBoxMario, checkBoxJoker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxHarry = findViewById(R.id.checkboxHarry);
        checkBoxMario = findViewById(R.id.checkboxMario);
        checkBoxJoker = findViewById(R.id.checkboxJoker);

       // if (checkBoxHarry.isChecked()) {
       //     Toast.makeText(MainActivity.this, "You have watched Harry Potter, Yay", Toast.LENGTH_SHORT).show();
      //  } else {
      //      Toast.makeText(MainActivity.this, "You need to watch Harry Potter", Toast.LENGTH_SHORT).show();
      //   }

        checkBoxHarry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "You have watched Harry Potter, Yay", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "You need to watch Harry Potter", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
