package com.fjodors.imgurmvp.imgurItemDetail.albumDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.api.responses.ImageResponse;
import com.fjodors.imgurmvp.gallery.GalleryFragment;
import com.fjodors.imgurmvp.models.ImgurBaseItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Fjodors on 18.08.2016.
 */
public class AlbumDetailFragment extends Fragment implements AlbumDetailContract.View {
    private AlbumDetailContract.Presenter albumDetailPresenter;
    private AlbumDetailRecyclerAdapter albumDetailRecyclerAdapter;

    @BindView(R.id.album_image_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    public static AlbumDetailFragment newInstance(ImgurBaseItem imgurBaseItem) {
        AlbumDetailFragment albumDetailFragment = new AlbumDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(GalleryFragment.IMAGE, imgurBaseItem);
        albumDetailFragment.setArguments(bundle);
        return albumDetailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_album_detail, container, false);
        ButterKnife.bind(this, view);

        initRecyclerView();

        albumDetailPresenter.start();

        return view;
    }

    @Override
    public void showImage(ImageResponse imageResponse) {
        albumDetailRecyclerAdapter.clear();
        albumDetailRecyclerAdapter.setImgurBaseItemModel(imageResponse.getData());
        albumDetailRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);


        albumDetailRecyclerAdapter = new AlbumDetailRecyclerAdapter();
        recyclerView.setAdapter(albumDetailRecyclerAdapter);
    }

    @Override
    public void showError() {
        //TODO: make material error response
        Toast.makeText(getActivity(), "Failed to load data", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setPresenter(AlbumDetailContract.Presenter presenter) {
        albumDetailPresenter = presenter;
    }
}