package ikhyarpl1.smkcoding.com.recyclerview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mesto on 30/08/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    List<ModelProduk> modelProduks;
    private ClickListener onClickListener;

    public MainAdapter(List<ModelProduk> modelProduks, ClickListener onClickListener) {
        this.modelProduks = modelProduks;
        this.onClickListener = onClickListener;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.bind(modelProduks.get(position), onClickListener);
    }

    @Override
    public int getItemCount() {
        return modelProduks.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{

        private ImageView gambarProduk;
        private CardView cardView;
        private TextView namaProduk, deskripsiProduk;

        public MainViewHolder(View itemView) {
            super(itemView);
        }

        public void bind( final ModelProduk modelMakanan, final ClickListener clickListener){
            cardView = itemView.findViewById(R.id.cardView);
            gambarProduk = itemView.findViewById(R.id.image);
            namaProduk = itemView.findViewById(R.id.nama);
            deskripsiProduk = itemView.findViewById(R.id.deskripsi);

            gambarProduk.setImageResource(modelMakanan.getFoto());
            namaProduk.setText(modelMakanan.getNama());
            deskripsiProduk.setText(modelMakanan.getDeskripsi());

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (clickListener != null){
                        clickListener.onClick(modelMakanan);
                    }
                }
            });
        }
    }

    interface ClickListener{
        void onClick(ModelProduk modelProduk);
    }
}
