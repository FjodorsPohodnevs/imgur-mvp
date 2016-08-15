package com.fjodors.imgurmvp.images;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fjodors.imgurmvp.R;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class ImagesRecyclerAdapter extends RecyclerView.Adapter<ImagesRecyclerAdapter.ImgurViewHolder> {

    private ImgurGalleryModel imgurGalleryModel;
    private Context context;
    private ItemClickListener itemClickListener;

    private static final String SMALL_SQUARE_IMAGE_THUMBNAIL = "s";

    public ImagesRecyclerAdapter(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ImgurViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);

        context = parent.getContext();

        return new ImgurViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ImgurViewHolder holder, final int position) {

        String thumbnailUrl;
        if (imgurGalleryModel.getData().get(position).getCover() != null) {
            thumbnailUrl = "http://i.imgur.com/" + imgurGalleryModel.getData().get(position).getCover() + SMALL_SQUARE_IMAGE_THUMBNAIL + ".jpg";
        } else {
            thumbnailUrl = "http://i.imgur.com/" + imgurGalleryModel.getData().get(position).getId() + SMALL_SQUARE_IMAGE_THUMBNAIL + ".jpg";
        }

        Glide.with(context)
                .load(thumbnailUrl)
                .asBitmap()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imgurImg);
        holder.title.setText(imgurGalleryModel.getData().get(position).getTitle());
        holder.score.setText("SCORE: " + imgurGalleryModel.getData().get(position).getScore());

        holder.imageItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(imgurGalleryModel.getData().get(position));
            }
        });
    }

    public ImgurGalleryModel getImgurGalleryModel() {
        return imgurGalleryModel;
    }

    public void setImgurGalleryModel(ImgurGalleryModel imgurGalleryModelList) {
        this.imgurGalleryModel = imgurGalleryModelList;
    }

    public void clear() {
        if (imgurGalleryModel != null && imgurGalleryModel.getData() != null) {
            imgurGalleryModel.getData().clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        if (imgurGalleryModel != null && imgurGalleryModel.getData() != null) {
            return imgurGalleryModel.data.size();
        } else {
            return 0;
        }
    }

    public interface ItemClickListener {
        void onItemClick(ImgurGalleryModel.Data image);
    }

    public static class ImgurViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView imgurImg;
        public TextView title;
        public TextView score;
        public LinearLayout imageItemLayout;

        public ImgurViewHolder(View v) {
            super(v);
            imageItemLayout = (LinearLayout) v;
            imgurImg = (ImageView) v.findViewById(R.id.imgur_img);
            title = (TextView) v.findViewById(R.id.title);
            score = (TextView) v.findViewById(R.id.score);
        }
    }
}
