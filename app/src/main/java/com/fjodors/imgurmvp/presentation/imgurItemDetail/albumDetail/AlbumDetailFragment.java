package com.fjodors.imgurmvp.presentation.imgurItemDetail.albumDetail;

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

import com.fjodors.imgurmvp.ImgurApp;
import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.data.AlbumRepository;
import com.fjodors.imgurmvp.data.remote.ErrorManager;
import com.fjodors.imgurmvp.data.remote.model.ImageResponse;
import com.fjodors.imgurmvp.model.ImgurAlbum;
import com.fjodors.imgurmvp.model.ImgurBaseItem;
import com.fjodors.imgurmvp.presentation.gallery.GalleryFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Fjodors on 18.08.2016.
 */
public class AlbumDetailFragment extends Fragment implements AlbumDetailContract.View {

    AlbumDetailContract.Presenter albumDetailPresenter;
    private AlbumDetailRecyclerAdapter albumDetailRecyclerAdapter;

    @BindView(R.id.album_image_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    AlbumRepository albumRepository;

    public static AlbumDetailFragment newInstance(ImgurBaseItem imgurBaseItem) {
        AlbumDetailFragment albumDetailFragment = new AlbumDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(GalleryFragment.IMAGE, imgurBaseItem);
        albumDetailFragment.setArguments(bundle);
        return albumDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImgurApp.get(getActivity())
                .getImgurAppComponent()
                .inject(this);

        albumDetailPresenter = new AlbumDetailPresenter(albumRepository);
        albumDetailPresenter.attachView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_album_detail, container, false);
        ButterKnife.bind(this, view);

        initRecyclerView();

        ImgurAlbum imgurAlbum = (ImgurAlbum) getArguments().getSerializable(GalleryFragment.IMAGE);
        if (imgurAlbum != null) {
            albumDetailPresenter.fetchAlbumsImages(imgurAlbum.getId());
        }

        return view;
    }

    @Override
    public void showAlbumsImages(ImageResponse imageResponse) {
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
    public void showError(Throwable e) {
        int errorMessage = ErrorManager.getErrorMessage(e);
        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(int e) {
        int errorMessage = ErrorManager.getErrorMessage(e);
        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }
}