package com.example.days1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pesan(View view) {
        EditText kodeBarang, jumlahBarang;
        TextView namaBarang, hargaBarang, totalHarga, discount, jumlahBayar;

        // EditText
        kodeBarang = findViewById(R.id.kodeBarang);
        jumlahBarang = findViewById(R.id.jumlahBarang);

        // TextView
        namaBarang = findViewById(R.id.namaBarang);
        hargaBarang = findViewById(R.id.hargaBarang);
        totalHarga = findViewById(R.id.totalHarga);
        discount = findViewById(R.id.discountBarang);
        jumlahBayar = findViewById(R.id.jumlahBayar);

        String stringKodeBarang = kodeBarang.getText().toString().trim();

        if(stringKodeBarang != "") {

            try {
                String idBarang = stringKodeBarang.substring(0,3);
                int kodeDiscount = Integer.parseInt( stringKodeBarang.substring(3) );

                String stringNamaBarang;
                int integerHargaBarang;

                if ( idBarang.equals("AND")){
                    stringNamaBarang = "Android";
                    integerHargaBarang = 800000;
                } else if( idBarang.equals("IOS")){
                    stringNamaBarang = "Apple";
                    integerHargaBarang = 1000000;
                } else if ( idBarang.equals("BLB")){
                    stringNamaBarang = "Blackberry";
                    integerHargaBarang = 700000;
                } else if ( idBarang.equals("WNP") ){
                    stringNamaBarang = "Windows Phone";
                    integerHargaBarang = 1700000;
                }else {
                    stringNamaBarang = "Tidak Ditemukan";
                    integerHargaBarang = 0;
                }

                int integerJumlahBarang = Integer.parseInt(jumlahBarang.getText().toString());
                int intTotalHarga = integerHargaBarang * integerJumlahBarang;
                int intDiscount = (intTotalHarga * kodeDiscount) / 100;
                namaBarang.setText("Nama Barang : "+ stringNamaBarang);
                hargaBarang.setText("Harga Barang : "+integerHargaBarang);
                totalHarga.setText("Total Harga : " + intTotalHarga);
                discount.setText("Discount : " + intDiscount);
                jumlahBayar.setText("Jumlah Bayar : " + (intTotalHarga - intDiscount));
            }catch (Exception e) {
                namaBarang.setText("Inputan Salah");
            }



        }




    }
}