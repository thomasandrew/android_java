package com.example.my_first_java_for_android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
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
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
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
import android.widget.ImageView;
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
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private static final String IMG_PATH = "http://www.softblue.com.br/public/images/sbv2_logotipo.png";
    private ImageView image;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        image = findViewById(R.id.image);
        progress = findViewById(R.id.progress);
    }

    public void download(View view) {
        DownloadTask task = new DownloadTask();
        task.execute(IMG_PATH);
    }

    private class DownloadTask extends AsyncTask<String, Void, Drawable> {

        @Override
        protected void onPreExecute() {
            image.setVisibility(View.GONE);
            progress.setVisibility(View.VISIBLE);
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected Drawable doInBackground(String... params) {
            String url = params[0];

            try {
                HttpCall httpCall = new HttpCall(url);
                HttpResponse response = httpCall.execute(HttpCall.Method.GET);

                try (InputStream in = response.getInputStream()) {
                    return BitmapDrawable.createFromStream(in, null);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Drawable result) {
            image.setImageDrawable(result);
            image.setVisibility(View.VISIBLE);
            progress.setVisibility(View.GONE);
        }
    }
}
