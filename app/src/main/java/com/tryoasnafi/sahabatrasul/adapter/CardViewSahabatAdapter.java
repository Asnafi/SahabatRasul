package com.tryoasnafi.sahabatrasul.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tryoasnafi.sahabatrasul.DetailSahabatActivity;
import com.tryoasnafi.sahabatrasul.R;
import com.tryoasnafi.sahabatrasul.model.Sahabat;


import java.util.ArrayList;

public class CardViewSahabatAdapter extends RecyclerView.Adapter<CardViewSahabatAdapter.CardViewViewHolder> {
    private ArrayList<Sahabat> listSahabat;
    Context c;

    public CardViewSahabatAdapter(ArrayList<Sahabat> list, Context c) {
        this.listSahabat = list;
        this.c = c;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_sahabat, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        Sahabat sahabat = listSahabat.get(position);
        final String images = sahabat.getPhoto();
        final String name = sahabat.getName();
        final String shortDescription = sahabat.getShortDescription();
        final String description = sahabat.getDescription();
        final String born = sahabat.getBorn();
        final String died = sahabat.getDied();

        Glide.with(holder.itemView.getContext())
                .load(images)
                .apply(new RequestOptions().override(200, 200))
                .into(holder.imgPhoto);

        holder.imgPhoto.setImageURI(Uri.parse(images));
        holder.tvName.setText(name);
        holder.tvShortDescription.setText(shortDescription);

        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetail(images, name, shortDescription, description, born, died);
            }
        });

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Share " +
                        listSahabat.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetail(images, name, shortDescription, description, born, died);
            }

        });

    }

    @Override
    public int getItemCount() {
        return listSahabat.size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvShortDescription;
        Button btnShare, btnDetails;

        CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvShortDescription = itemView.findViewById(R.id.tv_item_short_description);
            btnDetails = itemView.findViewById(R.id.btn_set_details);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }

    }
    //PASS DATA
    private void openDetail(String... details){
        Intent i = new Intent(c, DetailSahabatActivity.class);
        i.putExtra("IMAGES_KEY", details[0]);
        i.putExtra("NAME_KEY", details[1]);
        i.putExtra("SHORT_KEY", details[2]);
        i.putExtra("DESCRIPTION_KEY", details[3]);
        i.putExtra("BORN_KEY", details[4]);
        i.putExtra("DIED_KEY", details[5]);
        c.startActivity(i);
    }

}
