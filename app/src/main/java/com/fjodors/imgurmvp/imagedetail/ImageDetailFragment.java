package com.fjodors.imgurmvp.imagedetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.images.ImagesFragment;
import com.fjodors.imgurmvp.images.ImgurGalleryModel;

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
public class ImageDetailFragment extends Fragment implements ImageDetailContract.view {

    private static final String HUGE_IMAGE_THUMBNAIL = "h";

    public static ImageDetailFragment newInstace() {
        ImageDetailFragment imageDetailFragment = new ImageDetailFragment();
        return imageDetailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_detail, container, false);

        ImgurGalleryModel.Data image = (ImgurGalleryModel.Data) getArguments().getSerializable(ImagesFragment.IMAGE);

        ImageView imageView = (ImageView) view.findViewById(R.id.image);

        String imageUrl = "";
        if (image != null) {
            if (image.getCover() != null) {
                imageUrl = "http://i.imgur.com/" + image.getCover() + HUGE_IMAGE_THUMBNAIL + ".jpg";
            } else {
                imageUrl = image.getLink();
            }
        }

        Glide.with(getActivity())
                .load(imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);

        return view;
    }

    @Override
    public void showImage() {
        //TODO: move showing image code to here
    }
}
