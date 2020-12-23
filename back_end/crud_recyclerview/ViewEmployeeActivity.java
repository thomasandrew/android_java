package com.example.practise_again;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewEmployeeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        Dao dao = new Dao(this);
        List<Bean> bean = dao.getEmployeeList();

        if (bean.size() > 0) {
            EmployeeAdapterClass employeeAdapterClass = new EmployeeAdapterClass(bean, ViewEmployeeActivity.this);
            recyclerView.setAdapter(employeeAdapterClass);
        } else {
            Toast.makeText(this, "There is no employee in the database", Toast.LENGTH_SHORT).show();
        }

    }
}
