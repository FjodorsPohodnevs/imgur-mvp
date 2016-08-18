package com.fjodors.imgurmvp.imgurItemDetail.albumDetail;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.imgurItemDetail.imageDetail.ImageDetailContract;

/**
 * Created by Fjodors on 18.08.2016.
 */
public class AlbumDetailFragment extends android.support.v4.app.Fragment implements AlbumDetailContract.View {

    private AlbumDetailContract.Presenter albumDetailPresenter;
    private View view;


    public static AlbumDetailFragment newInstace() {
        AlbumDetailFragment albumDetailFragment = new AlbumDetailFragment();
        return albumDetailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_image_detail, container, false);

//        imageDetailPresenter.getImageUrl(this);

        return view;
    }


    @Override
    public void showImage(String imageUrl) {
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        Glide.with(getActivity())
                .load(imageUrl)
                .error(R.drawable.ic_block_black_48dp)
                .into(imageView);
    }

    @Override
    public void showError() {
        //TODO: make material error response
        Toast.makeText(getActivity(), "Failed to load data", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setPresenter(AlbumDetailContract.Presenter presenter) {
        albumDetailPresenter = presenter;
    }
}