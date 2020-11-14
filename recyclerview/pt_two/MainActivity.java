package com.example.my_first_java_for_android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactsRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsRecView = findViewById(R.id.contactsRecView);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Margot Robbie", "Marot@gmail.com", "https://img.olhardigital.com.br/uploads/acervo_imagens/2020/02/r4x3/20200213025332_660_495_-_margot_robbie.jpg"));
        contacts.add(new Contact("Cillian Murphy", "Cillian@gmail.com", "https://randomuser.me/api/portraits/men/1.jpg"));
        contacts.add(new Contact("Saoire Ronan", "Saoirse@gmail.com", "https://randomuser.me/api/portraits/men/2.jpg"));
        contacts.add(new Contact("Emma Watson", "Emaa@gmail.com", "https://randomuser.me/api/portraits/women/1.jpg"));
        contacts.add(new Contact("Cristian Bale", "Cristian@gmail.com", "https://randomuser.me/api/portraits/men/3.jpg"));

        ContactsRecViewAdapter adapter = new ContactsRecViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecView.setAdapter(adapter);
        //contactsRecView.setLayoutManager(new LinearLayoutManager(this));
        //contactsRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        contactsRecView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
