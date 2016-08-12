package com.fjodors.imgurmvp.images;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fjodors.imgurmvp.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class ImagesRecyclerAdapter extends RecyclerView.Adapter<ImagesRecyclerAdapter.ImgurViewHolder> {

    private ImagesModel imagesModel;
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
        Picasso.with(context)
                .load(imagesModel.getData().get(position).getLink() + SMALL_SQUARE_IMAGE_THUMBNAIL)
//                .load("http://i.imgur.com/" + imagesModel.getData().get(position).getId() + SMALL_SQUARE_IMAGE_THUMBNAIL + ".jpg")
                .into(holder.imgurImg, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        holder.progressBar.setVisibility(View.GONE);
                    }
                });
        holder.title.setText(imagesModel.getData().get(position).getTitle());
        holder.score.setText("SCORE: " + imagesModel.getData().get(position).getScore());

        holder.imageItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(imagesModel.getData().get(position));
            }
        });
    }

    public ImagesModel getImagesModel() {
        return imagesModel;
    }

    public void setImagesModel(ImagesModel imagesModelList) {
        this.imagesModel = imagesModelList;
    }

    public void clear() {
        if (imagesModel != null && imagesModel.getData() != null) {
            imagesModel.getData().clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        if (imagesModel != null && imagesModel.getData() != null) {
            return imagesModel.data.size();
        } else {
            return 0;
        }
    }

    public interface ItemClickListener {
        void onItemClick(ImagesModel.Data image);
    }

    public static class ImgurViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView imgurImg;
        public TextView title;
        public TextView score;
        public LinearLayout imageItemLayout;
        public ProgressBar progressBar;

        public ImgurViewHolder(View v) {
            super(v);
            imageItemLayout = (LinearLayout) v;
            imgurImg = (ImageView) v.findViewById(R.id.imgur_img);
            title = (TextView) v.findViewById(R.id.title);
            score = (TextView) v.findViewById(R.id.score);
            progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        }
    }
}
