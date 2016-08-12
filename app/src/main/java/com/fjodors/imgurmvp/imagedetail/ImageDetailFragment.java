package com.fjodors.imgurmvp.imagedetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.images.ImagesModel;
import com.fjodors.imgurmvp.images.ImagesFragment;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

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

        ImagesModel.Data image = (ImagesModel.Data) getArguments().getSerializable(ImagesFragment.IMAGE);

        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        if (image != null) {
            Picasso.with(getActivity())
                    .load(image.getLink() + HUGE_IMAGE_THUMBNAIL)
//                    .load("http://i.imgur.com/" + image.getId() + HUGE_IMAGE_THUMBNAIL + ".jpg")
                    .into(imageView, new Callback() {
                        @Override
                        public void onSuccess() {
                            progressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onError() {
                            Toast.makeText(getActivity(), "FAILED TO LOAD IMAGE", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    });
        }

        return view;
    }

    @Override
    public void showImage() {
        //TODO: move showing image code to here
    }
}
