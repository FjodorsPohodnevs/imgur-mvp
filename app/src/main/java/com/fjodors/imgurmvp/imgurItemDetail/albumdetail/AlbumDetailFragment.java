package com.fjodors.imgurmvp.imgurItemDetail.albumDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.api.responses.ImageResponse;

/**
 * Created by Fjodors on 18.08.2016.
 */
public class AlbumDetailFragment extends android.support.v4.app.Fragment implements AlbumDetailContract.View {

    private AlbumDetailContract.Presenter albumDetailPresenter;
    private View view;
    private AlbumDetailRecyclerAdapter albumDetailRecyclerAdapter;
    private RecyclerView recyclerView;


    public static AlbumDetailFragment newInstace() {
        AlbumDetailFragment albumDetailFragment = new AlbumDetailFragment();
        return albumDetailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_album_detail, container, false);

        initRecyclerView(view);
        albumDetailPresenter.fetchAlbumsImages(this);

        return view;
    }


    @Override
    public void showImage(ImageResponse imageResponse) {
//        ImageView imageView = (ImageView) view.findViewById(R.id.image);
//        Glide.with(getActivity())
//                .load(imageUrl)
//                .error(R.drawable.ic_block_black_48dp)
//                .into(imageView);

        albumDetailRecyclerAdapter.clear();
        albumDetailRecyclerAdapter.setImgurBaseItemModel(imageResponse.getData());
        albumDetailRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.imgur_recycler_view);

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

    }

    @Override
    public void setPresenter(AlbumDetailContract.Presenter presenter) {
        albumDetailPresenter = presenter;
    }
}