package com.example.tokomedia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    int total_quntity = 1;
    int total_harga = 11450000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //perintah untuk penambahan item
    public void increment(View view) {
        if (quantity == 10) {
            Toast.makeText(this, "Maksimal pesan 10 item", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        total_quntity = quantity * total_harga;

        display(quantity);
        displayHarga(total_quntity);
    }
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity);
        quantityTextView.setText("" + number);
    }

    //perintah untuk pengurangan item
    public void decrement(View view) {
        if (quantity <= 1) {
            Toast.makeText(this, "Minimal pesan 1 item", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        total_quntity = quantity * total_harga;

        display(quantity);
        displayHarga(total_quntity);
    }

    //menampilkan harga
    private void displayHarga(int number) {
        TextView quantityTextView = findViewById(R.id.total_harga);
        quantityTextView.setText("Rp." +number);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Apakah anda yakin akan keluar?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }
}



