package com.dex.pexeldex;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class WallpaperAdopter extends RecyclerView.Adapter<WallpaperViewHolder>{

    private Context context;
    private List<WallpaperModel> wallpaperModelList;

    public WallpaperAdopter(Context context, List<WallpaperModel> wallpaperModelList) {
        this.context = context;
        this.wallpaperModelList = wallpaperModelList;
    }

    @NonNull
    @Override
    public WallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_item,parent,false);
        return new WallpaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperViewHolder holder, int position) {

        Glide.with(context).load(wallpaperModelList.get(position).getMediumurl()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,FullScreenWallpaper.class).putExtra("originalUrl",wallpaperModelList.get(position).getOriginalurl()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return wallpaperModelList.size();
    }
}

class WallpaperViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;

    public WallpaperViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.imageViewItem);
    }
}