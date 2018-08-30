package ikhyarpl1.smkcoding.com.recyclerview;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainAdapter adapterProduk;
    private List<ModelProduk> listProduk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        listProduk = new ArrayList<>();

        DataList();

        adapterProduk = new MainAdapter(listProduk, new MainAdapter.ClickListener() {
            @Override
            public void onClick(ModelProduk modelProduk) {
                Intent i = new Intent(MainActivity.this,isi.class);
                i.putExtra("gambarMakanan", modelProduk.getFoto());
                i.putExtra("namaMakanan", modelProduk.getNama());
                i.putExtra("deskripsi", modelProduk .getDeskripsi());
                startActivityForResult(i,1);
            }
        });

        GridLayoutManager glm = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(glm);
        recyclerView.setAdapter(adapterProduk);

    }

    public void DataList(){

        listProduk.add(new ModelProduk("HALO", "lorem ipsum", R.drawable.logo));
        listProduk.add(new ModelProduk("ALOHA", "lorem ipsum", R.drawable.logo));
        listProduk.add(new ModelProduk("CYKA", "lorem ipsum", R.drawable.logo));
        listProduk.add(new ModelProduk("MUAH", "lorem ipsum", R.drawable.logo));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK){
            if (data != null){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setMessage("halo");
                builder.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        closeOptionsMenu();
                    }
                });

                AlertDialog dialog = builder.create();

                dialog.show();
            }
        }
    }

}
