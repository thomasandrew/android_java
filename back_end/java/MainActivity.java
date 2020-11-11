package com.example.back_end;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn_add, btn_viewAll;
    private EditText et_age, et_name;
    private Switch sw_activeCustumer;
    private ListView lv_customerList;
    private ArrayAdapter cusonterArrayAdapter;
    private DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_viewAll = findViewById(R.id.btn_viewAll);
        et_age = findViewById(R.id.et_age);
        et_name = findViewById(R.id.et_text);
        sw_activeCustumer = findViewById(R.id.sw_active);
        lv_customerList = findViewById(R.id.lv_customerList);

        //cusonterArrayAdapter = new ArrayAdapter<CustumerModl>(MainActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper.getEveryone());
        //lv_customerList.setAdapter(cusonterArrayAdapter);

        dataBaseHelper = new DataBaseHelper(MainActivity.this);

        ShowCustomersOnListView(dataBaseHelper);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustumerModl custumerModl;

                try {
                    custumerModl = new CustumerModl(-1, et_name.getText().toString(), Integer.parseInt(et_age.getText().toString()), sw_activeCustumer.isChecked());
                    Toast.makeText(MainActivity.this, custumerModl.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error creating customer", Toast.LENGTH_SHORT).show();
                    custumerModl = new CustumerModl(-1, "error", 0, false);
                }

                dataBaseHelper = new DataBaseHelper(MainActivity.this);

                boolean success = dataBaseHelper.addOne(custumerModl);

                Toast.makeText(MainActivity.this, "Success= " + success, Toast.LENGTH_SHORT).show();
                //cusonterArrayAdapter = new ArrayAdapter<CustumerModl>(MainActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper.getEveryone());
                //lv_customerList.setAdapter(cusonterArrayAdapter);
                ShowCustomersOnListView(dataBaseHelper);
            }
        });

        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dataBaseHelper = new DataBaseHelper(MainActivity.this);
                //List<CustumerModl> everyone = dataBaseHelper.getEveryone();

                //cusonterArrayAdapter = new ArrayAdapter<CustumerModl>(MainActivity.this, android.R.layout.simple_list_item_1, everyone);
               //cusonterArrayAdapter = new ArrayAdapter<CustumerModl>(MainActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper.getEveryone());
                //lv_customerList.setAdapter(cusonterArrayAdapter);
                ShowCustomersOnListView(dataBaseHelper);

                //Toast.makeText(MainActivity.this, everyone.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        lv_customerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustumerModl clicedCustomer = (CustumerModl) parent.getItemAtPosition(position);
                dataBaseHelper.deleteOne(clicedCustomer);
                ShowCustomersOnListView(dataBaseHelper);
                Toast.makeText(MainActivity.this, "Deleted " + clicedCustomer.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ShowCustomersOnListView(DataBaseHelper dataBaseHelper2) {
        cusonterArrayAdapter = new ArrayAdapter<CustumerModl>(MainActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper2.getEveryone());
        lv_customerList.setAdapter(cusonterArrayAdapter);
    }
}
