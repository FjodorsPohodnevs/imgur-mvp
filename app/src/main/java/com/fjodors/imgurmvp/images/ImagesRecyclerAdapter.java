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
import com.fjodors.imgurmvp.models.ImgurBaseItemModel;

import java.util.List;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class ImagesRecyclerAdapter extends RecyclerView.Adapter<ImagesRecyclerAdapter.ImgurViewHolder> {

    private List<ImgurBaseItemModel> imgurBaseItemModelList;
    private Context context;
    private ItemClickListener itemClickListener;

    private static final String BIG_SQUARE_IMAGE_THUMBNAIL = "b";

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
        //TODO: uncomment and fix
//        if (imgurBaseItemModelList.get(position).getCover() != null) {
//            thumbnailUrl = "http://i.imgur.com/" + imgurBaseItemModelList.get(position).getCover() + BIG_SQUARE_IMAGE_THUMBNAIL + ".jpg";
//        } else {
//            thumbnailUrl = "http://i.imgur.com/" + imgurBaseItemModelList.get(position).getId() + BIG_SQUARE_IMAGE_THUMBNAIL + ".jpg";
//        }
        thumbnailUrl = "http://i.imgur.com/" + imgurBaseItemModelList.get(position).getId() + BIG_SQUARE_IMAGE_THUMBNAIL + ".jpg";

        Glide.with(context)
                .load(thumbnailUrl)
                .asBitmap()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imgurImg);
        holder.title.setText(imgurBaseItemModelList.get(position).getTitle());
        holder.score.setText("SCORE: " + imgurBaseItemModelList.get(position).getScore());

        holder.imageItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(imgurBaseItemModelList.get(position));
            }
        });
    }

    public List<ImgurBaseItemModel> getImgurBaseItemModelList() {
        return imgurBaseItemModelList;
    }

    public void setImgurBaseItemModel(List<ImgurBaseItemModel> imgurBaseItemModelList) {
        this.imgurBaseItemModelList = imgurBaseItemModelList;
    }

    public void clear() {
        if (imgurBaseItemModelList != null && imgurBaseItemModelList != null) {
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

    public interface ItemClickListener {
        void onItemClick(ImgurBaseItemModel imgurBaseItemModel);
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
