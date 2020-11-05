package com.example.my_first_java_for_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxHarry, checkBoxMario, checkBoxJoker;
    private RadioGroup rgMaritalStatus;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxHarry = findViewById(R.id.checkboxHarry);
        checkBoxMario = findViewById(R.id.checkboxMario);
        checkBoxJoker = findViewById(R.id.checkboxJoker);

        rgMaritalStatus = findViewById(R.id.rgMaritalStatus);

        progressBar = findViewById(R.id.progressBar);

        //Out of nowhere.
        int checkedButton = rgMaritalStatus.getCheckedRadioButtonId();
        switch (checkedButton) {
            case R.id.rbMarried:
                Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbSingle:
                Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbInRel:
                Toast.makeText(MainActivity.this, "In a Relationship", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        //Create
        rgMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbMarried:
                        Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbSingle:
                        Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbInRel:
                        Toast.makeText(MainActivity.this, "In a Relationship", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        break;
                    default:
                        break;
                }
            }
        });

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
