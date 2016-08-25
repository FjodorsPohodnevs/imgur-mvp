package com.fjodors.imgurmvp.imgurItemDetail.imageDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fjodors.imgurmvp.ImgurApp;
import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.gallery.GalleryFragment;
import com.fjodors.imgurmvp.models.ImgurBaseItem;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
public class ImageDetailFragment extends Fragment implements ImageDetailContract.View {

    @Inject
    ImageDetailContract.Presenter imageDetailPresenter;

    @BindView(R.id.image)
    ImageView imageView;

    public static ImageDetailFragment newInstace(ImgurBaseItem imgurBaseItem) {
        ImageDetailFragment imageDetailFragment = new ImageDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(GalleryFragment.IMAGE, imgurBaseItem);
        imageDetailFragment.setArguments(bundle);
        return imageDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImgurApp.get(getActivity())
                .getImgurAppComponent()
                .newImageDetailSubComponent(new ImageDetailModule(this))
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_detail, container, false);
        ButterKnife.bind(this, view);

        ImgurBaseItem imgurBaseItem = (ImgurBaseItem) getArguments().getSerializable(GalleryFragment.IMAGE);
        imageDetailPresenter.getImageUrl(imgurBaseItem);

        return view;
    }

    @Override
    public void showImage(String imageUrl) {
        Picasso.with(getActivity())
                .load(imageUrl)
                .error(R.drawable.ic_block_black_48dp)
                .fit()
                .centerInside()
                .into(imageView);
    }
}
