package ikhyarpl1.smkcoding.com.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class isi extends AppCompatActivity {

    private ImageView imageView;
    private TextView namaProduk,deskripsiProduk;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi);

        imageView = findViewById(R.id.imageView);
        namaProduk = findViewById(R.id.textNama);
        deskripsiProduk = findViewById(R.id.deskripsi);
        btnSubmit = findViewById(R.id.btnSubmit);

        Intent i = getIntent();
        int gambar = i.getIntExtra("gambarMakanan",R.mipmap.ic_launcher_round);
        String nama = i.getStringExtra("namaMakanan");
        String harga = i.getStringExtra("hargaMakanan");
        String deskripsi = i.getStringExtra("deskripsi");

        imageView.setImageResource(gambar);
        namaProduk.setText(nama);
        deskripsiProduk.setText(deskripsi);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("dataPesanan", "Terimakasih, Pesanan Anda Akan Segera Diantar");
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}



