package com.fjodors.imgurmvp.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.models.ImgurAlbum;
import com.fjodors.imgurmvp.models.ImgurBaseItem;
import com.fjodors.imgurmvp.models.ImgurImage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class GalleryRecyclerAdapter extends RecyclerView.Adapter<GalleryRecyclerAdapter.ImgurViewHolder> {
    private List imgurBaseItemModelList;
    private Context context;
    private ItemClickListener itemClickListener;

    private static final String BIG_SQUARE_IMAGE_THUMBNAIL = "b";

    public GalleryRecyclerAdapter(ItemClickListener itemClickListener) {
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
        final ImgurBaseItem imgurBaseItem = (ImgurBaseItem) imgurBaseItemModelList.get(position);
        String thumbnailUrl = "";

        if (imgurBaseItem instanceof ImgurAlbum) {
            ImgurAlbum imgurAlbum = (ImgurAlbum) imgurBaseItem;
            thumbnailUrl = "http://i.imgur.com/" + imgurAlbum.getCover() + BIG_SQUARE_IMAGE_THUMBNAIL + ".jpg";
        } else if (imgurBaseItem instanceof ImgurImage) {
            ImgurImage imgurImage = (ImgurImage) imgurBaseItem;
            thumbnailUrl = "http://i.imgur.com/" + imgurImage.getId() + BIG_SQUARE_IMAGE_THUMBNAIL + ".jpg";
        }

        Glide.with(context)
                .load(thumbnailUrl)
                .asBitmap()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.ic_block_black_48dp)
                .into(holder.imgurImg);
        holder.title.setText(imgurBaseItem.getTitle());
        holder.score.setText("SCORE: " + imgurBaseItem.getScore());

        holder.itemView.setOnClickListener(view -> itemClickListener.onItemClick(imgurBaseItem));
    }

    public void setImgurBaseItemModel(List<ImgurBaseItem> imgurBaseItemModelList) {
        this.imgurBaseItemModelList = imgurBaseItemModelList;
    }

    @Override
    public int getItemCount() {
        if (imgurBaseItemModelList != null) {
            return imgurBaseItemModelList.size();
        } else {
            return 0;
        }
    }

    public interface ItemClickListener {
        void onItemClick(ImgurBaseItem imgurBaseItem);
    }

    public static class ImgurViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        @BindView(R.id.image)
        public ImageView imgurImg;
        @BindView(R.id.title)
        public TextView title;
        @BindView(R.id.score)
        public TextView score;

        public ImgurViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
