package com.fjodors.imgurmvp.imgurItemDetail.imageDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.gallery.GalleryFragment;
import com.fjodors.imgurmvp.models.ImgurBaseItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
public class ImageDetailFragment extends Fragment implements ImageDetailContract.View {
    private ImageDetailContract.Presenter imageDetailPresenter;

    @BindView(R.id.image)
    ImageView imageView;

    public static ImageDetailFragment newInstace(ImgurBaseItem imgurBaseItem) {
        ImageDetailFragment imageDetailFragment = new ImageDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(GalleryFragment.IMAGE, imgurBaseItem);
        imageDetailFragment.setArguments(bundle);
        return imageDetailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_detail, container, false);
        ButterKnife.bind(this, view);

        imageDetailPresenter.getImageUrl();

        return view;
    }

    @Override
    public void showImage(String imageUrl) {
        Glide.with(getActivity())
                .load(imageUrl)
                .asBitmap()//TODO: fix gif later
                .error(R.drawable.ic_block_black_48dp)
                .into(imageView);
    }


    @Override
    public void setPresenter(ImageDetailContract.Presenter presenter) {
        imageDetailPresenter = presenter;
    }
}
