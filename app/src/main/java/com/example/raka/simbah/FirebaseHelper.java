package com.example.raka.simbah;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by RAKA on 12/18/2017.
 */

public class FirebaseHelper {
    DatabaseReference db;
    Boolean saved=null;
    ArrayList<TampilPesan> spacecrafts=new ArrayList<>();
    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }

    //mengambil data dan mengisikan ke array
    private void fetchData(DataSnapshot dataSnapshot)
    {
        spacecrafts.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            TampilPesan spacecraft=ds.getValue(TampilPesan.class);
            spacecrafts.add(spacecraft);
        }
    }
    //Membaca data dan mengembalikkan arraylist
    public ArrayList<TampilPesan> retrieve() {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return spacecrafts;
    }
}
