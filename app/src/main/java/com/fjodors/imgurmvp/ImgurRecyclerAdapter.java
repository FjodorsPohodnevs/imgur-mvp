package com.fjodors.imgurmvp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class ImgurRecyclerAdapter extends RecyclerView.Adapter<ImgurRecyclerAdapter.ImgurViewHolder> {

    private ImgurGalleryImage imgurGalleryImage;
    private Context context;

    @Override
    public ImgurViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.imgur_img_item, parent, false);

        context = parent.getContext();

        ImgurViewHolder imgurViewHolder = new ImgurViewHolder(v);
        return imgurViewHolder;
    }

    @Override
    public void onBindViewHolder(ImgurViewHolder holder, int position) {
        Picasso.with(context)
                .load("http://i.imgur.com/" + imgurGalleryImage.getData().get(position).getId() + ".jpg")
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imgurImg);
        holder.title.setText(imgurGalleryImage.getData().get(position).getTitle());
        holder.score.setText("SCORE: " + imgurGalleryImage.getData().get(position).getScore());
    }

    public ImgurGalleryImage getImgurGalleryImage() {
        return imgurGalleryImage;
    }

    public void setImgurGalleryImage(ImgurGalleryImage imgurGalleryImageList) {
        this.imgurGalleryImage = imgurGalleryImageList;
    }

    public void clear() {
        if (imgurGalleryImage != null && imgurGalleryImage.getData() != null) {
            imgurGalleryImage.getData().clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        if (imgurGalleryImage != null && imgurGalleryImage.getData() != null) {
            return imgurGalleryImage.data.size();
        } else {
            return 0;
        }
    }

    public static class ImgurViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView imgurImg;
        public TextView title;
        public TextView score;

        public ImgurViewHolder(View v) {
            super(v);
            imgurImg = (ImageView) v.findViewById(R.id.imgur_img);
            title = (TextView) v.findViewById(R.id.title);
            score = (TextView) v.findViewById(R.id.score);
        }
    }
}
