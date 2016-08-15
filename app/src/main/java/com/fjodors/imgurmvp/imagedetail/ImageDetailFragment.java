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

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
public class ImageDetailFragment extends Fragment implements ImageDetailContract.View {

    private ImageDetailContract.Presenter imageDetailPresenter;
    private View view;


    public static ImageDetailFragment newInstace() {
        ImageDetailFragment imageDetailFragment = new ImageDetailFragment();
        return imageDetailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_image_detail, container, false);

        imageDetailPresenter.getImageUrl(this);

        return view;
    }


    @Override
    public void showImage(String imageUrl) {
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        Glide.with(getActivity())
                .load(imageUrl)
//                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }

    @Override
    public void setPresenter(ImageDetailContract.Presenter presenter) {
        imageDetailPresenter = presenter;
    }
}
