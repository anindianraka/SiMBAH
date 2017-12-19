package com.example.raka.simbah;

import android.app.ActionBar;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {

    DatabaseReference db;
    FirebaseHelper helper;
    AdapterHistory adapter;
    RecyclerView rv;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        setTitle("List Pesan");



        rv = (RecyclerView) findViewById(R.id.rv_history);
        rv.setLayoutManager(new LinearLayoutManager(this));
        //insialisasi firebase
        db= FirebaseDatabase.getInstance().getReference();
        helper=new FirebaseHelper(db);
        //memanggil adapter
        adapter=new AdapterHistory(this,helper.retrieve());
        rv.setAdapter(adapter);


    }
}
