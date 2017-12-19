package com.example.raka.simbah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Menu");
    }


    public void doSomething(View view) {
        Intent it = new Intent(MainActivity.this,Pesan.class);
        startActivity(it);
    }

    public void doSomething2(View view) {
        Intent it = new Intent(MainActivity.this,Profile.class);
        startActivity(it);
    }

    public void doSomething3(View view) {
        Intent it = new Intent(MainActivity.this,History.class);
        startActivity(it);
    }

    public void doSomething4(View view) {
        Intent it = new Intent(MainActivity.this,TentangKami.class);
        startActivity(it);
    }
}
