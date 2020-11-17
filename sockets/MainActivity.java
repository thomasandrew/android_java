package com.example.my_first_java_for_android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private EditText edtWord;
    private TextView txtInverseWord;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWord = (EditText) findViewById(R.id.edt_word);
        txtInverseWord = (TextView) findViewById(R.id.txt_inverse_word);
        progress = (ProgressBar) findViewById(R.id.progress);
    }

    public void invert(View view) {
        String texto = edtWord.getText().toString();

        InvertTask task = new InvertTask();
        task.execute(texto);
    }

    private class InvertTask extends AsyncTask<String, Void, String> {


        @Override
        protected void onPreExecute() {
            txtInverseWord.setVisibility(View.GONE);
            progress.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            String texto = params[0];

            Socket socket = null;
            PrintWriter out = null;
            Scanner in = null;

            try {
                try {
                    socket = new Socket("code.softblue.com.br", 3000);
                    out = new PrintWriter(socket.getOutputStream(), true);
                    in = new Scanner(socket.getInputStream());

                    out.println(texto);
                    return in.nextLine();

                } finally {
                    if (in != null) {
                        in.close();
                    }

                    if (out != null) {
                        out.close();
                    }

                    if (socket != null) {
                        socket.close();
                    }
                }

            } catch (final IOException e) {
                e.printStackTrace();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Erro: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            progress.setVisibility(View.GONE);
            txtInverseWord.setVisibility(View.VISIBLE);
            txtInverseWord.setText(result);
            edtWord.setText(null);
        }
    }
}
