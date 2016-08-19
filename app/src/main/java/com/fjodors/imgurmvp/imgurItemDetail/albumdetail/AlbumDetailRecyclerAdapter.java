package com.fjodors.imgurmvp.imgurItemDetail.albumDetail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.models.ImgurImage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Fjodors on 18.08.2016.
 */
public class AlbumDetailRecyclerAdapter extends RecyclerView.Adapter<AlbumDetailRecyclerAdapter.ImgurViewHolder> {
    private List imgurBaseItemModelList;
    private Context context;

    @Override
    public ImgurViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album_image, parent, false);

        context = parent.getContext();

        return new ImgurViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ImgurViewHolder holder, final int position) {
        final ImgurImage imgurImage = (ImgurImage) imgurBaseItemModelList.get(position);
        String imageUrl;

        if (imgurImage.getType().equalsIgnoreCase("image/gif")) {
            imageUrl = "http://i.imgur.com/" + imgurImage.getId() + ".gif";
        } else {
            imageUrl = imgurImage.getLink();
        }

        Glide.with(context)
                .load(imageUrl)
                .asBitmap()//TODO: fix gif later
                .error(R.drawable.ic_block_black_48dp)
                .fitCenter()
                .into(holder.image);
    }

    public void setImgurBaseItemModel(List<ImgurImage> imgurBaseItemModelList) {
        this.imgurBaseItemModelList = imgurBaseItemModelList;
    }

    public void clear() {
        if (imgurBaseItemModelList != null) {
            imgurBaseItemModelList.clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        if (imgurBaseItemModelList != null) {
            return imgurBaseItemModelList.size();
        } else {
            return 0;
        }
    }

    public static class ImgurViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        public ImageView image;

        public ImgurViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
