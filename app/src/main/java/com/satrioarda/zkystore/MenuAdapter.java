package com.satrioarda.zkystore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.satrioarda.zkystore.R;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    Context context;


    public MenuAdapter(ArrayList<Diamond> listDiamond, Context context) {
        this.listDiamond = listDiamond;
        this.context = context;
    }

    private ArrayList<Diamond> listDiamond;

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.item_diamond, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        Diamond diamond = listDiamond.get(position);
        holder.txtnama.setText(diamond.getNama());
        holder.txtharga.setText(diamond.getHarga());
        holder.imgfoto.setImageResource(diamond.getId_gambar());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), int_diamond.class);
                intent.putExtra("gambar", diamond.getId_gambar());
                intent.putExtra("nama", diamond.getNama());
                intent.putExtra("deskripsi", diamond.getDeskripsi());
                intent.putExtra("harga", diamond.getHarga());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listDiamond.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtnama,txtharga,txtdeskripsi;
        public ImageView imgfoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtnama = (TextView) itemView.findViewById(R.id.txtnama);
            txtharga = (TextView) itemView.findViewById(R.id.txtharga);
            imgfoto = (ImageView) itemView.findViewById(R.id.imgfoto);
        }
    }
}
