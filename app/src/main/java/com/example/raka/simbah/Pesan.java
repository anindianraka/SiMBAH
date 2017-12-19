package com.example.raka.simbah;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Pesan extends AppCompatActivity {


    private EditText mJumlahKilo,mCatatan,mAlamat;
    private static final String TAG="Pesan";
    private TextView mDisplayDate,mHrgCuci,mHrgJasa,mHargaTotal;
    private Button btnProses;
    private Spinner spinner,spinner2;
    ArrayAdapter<CharSequence> adapter;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;
    private ContactsContract.Data mDatabaseRef;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);

        setTitle("Pesan");
        ActionBar actionBar = getActionBar();

        spinner =(Spinner)findViewById(R.id.spin_paket);
        spinner2 =(Spinner)findViewById(R.id.spin_bayar);
        mDisplayDate=(TextView)findViewById(R.id.Date);
        mJumlahKilo = (EditText)findViewById(R.id.et_jumlahkilo);
        mCatatan = (EditText)findViewById(R.id.et_catatan);
        mAlamat = (EditText)findViewById(R.id.et_alamat);
        btnProses=(Button)findViewById(R.id.buttonProses);

        mHrgCuci=(TextView)findViewById(R.id.tv_hrgCuci);
        mHargaTotal=(TextView)findViewById(R.id.tv_hrgTotal);



        databaseReference = FirebaseDatabase.getInstance().getReference("Pesanan");
        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addArrayList();

            }
        });

        adapter=ArrayAdapter.createFromResource(this,R.array.paket_loundry,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        adapter=ArrayAdapter.createFromResource(this,R.array.metode_pembayaran,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);


        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal=Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Pesan.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                Log.d(TAG,"onDateSet: dd/mm/yyy: "+dayOfMonth+"/"+month+"/"+year);
                String date = dayOfMonth + "-" + month +"-"+year;
                mDisplayDate.setText(date);
            }
        };

    }
    public void ReCreate(){
            Intent intent = getIntent();
            finish();
            startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    protected void addArrayList()
    {
        String Paket=spinner.getSelectedItem().toString();
        String Pembayaran=spinner2.getSelectedItem().toString();
        String JumlahKilo = mJumlahKilo.getText().toString();
        String Catatan = mCatatan.getText().toString();
        String Alamat = mAlamat.getText().toString();
        String Tanggal = mDisplayDate.getText().toString();
        String HargaTotal = mHargaTotal.getText().toString();


        if(TextUtils.isEmpty(JumlahKilo)){
            Toast.makeText(this, "Silahkan masukan Jumlah Kilo", Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(Catatan)){
            Toast.makeText(this, "Silahkan masukan Catatan", Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(Alamat)){
            Toast.makeText(this, "Silahkan masukan Alamat", Toast.LENGTH_LONG).show();
        }
        else {
            String id=databaseReference.push().getKey();
            ListPesanan pesanan = new ListPesanan(Paket, JumlahKilo, Catatan, Tanggal, Alamat, Pembayaran,HargaTotal,id);
            databaseReference.child(id).setValue(pesanan);
            Log.d("tgl",Tanggal);
            Toast.makeText(Pesan.this, "Data berhasil tersimpan", Toast.LENGTH_SHORT).show();
            ReCreate();

        }
    }


    public void JumlahKilo(View view) {
        int Harga,Total;
        mJumlahKilo = (EditText)findViewById(R.id.et_jumlahkilo);
        mHrgCuci=(TextView)findViewById(R.id.tv_hrgCuci);
        mHargaTotal=(TextView)findViewById(R.id.tv_hrgTotal);
        mHrgJasa=(TextView)findViewById(R.id.tv_hrgTotal);

        int HargaCuci=Integer.parseInt(mJumlahKilo.getText().toString());
        String Paket=spinner.getSelectedItem().toString();
        if(Paket.equals("Kilat"))
        {
            Harga=HargaCuci*4000;
            mHrgCuci.setText("Biaya Cuci Rp "+Integer.toString(Harga));
            Total=Harga+5000;
            mHargaTotal.setText("Biaya Total Rp "+Integer.toString(Total));
        }
        else if(Paket.equals("Express"))
        {
            Harga=HargaCuci*6000;
            mHrgCuci.setText("Biaya Cuci Rp "+Integer.toString(Harga));
            Total=Harga+5000;
            mHargaTotal.setText("Biaya Total Rp "+Integer.toString(Total));
        }
        else if(Paket.equals("Biasa"))
        {
            Harga=HargaCuci*3000;
            mHrgCuci.setText("Biaya Cuci Rp "+Integer.toString(Harga));
            Total=Harga+5000;
            mHargaTotal.setText("Biaya Total Rp "+Integer.toString(Total));
        }
        else if(Paket.equals("Cuci Kering"))
        {
            Harga=HargaCuci*2000;
            mHrgCuci.setText("Biaya Cuci Rp "+Integer.toString(Harga));
            Total=Harga+5000;
            mHargaTotal.setText("Biaya Total Rp "+Integer.toString(Total));
        }

    }
}
