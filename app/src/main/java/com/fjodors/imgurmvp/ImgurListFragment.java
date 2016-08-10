package com.fjodors.imgurmvp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class ImgurListFragment extends Fragment {

    private static final String TAG = ImgurListFragment.class.getSimpleName();

    private RecyclerView recyclerView;
    private ImgurRecyclerAdapter imgurRecyclerAdapter;
    private SwipeRefreshLayout refreshLayout;

    public static ImgurListFragment newInstance() {
        ImgurListFragment imgurListFragment = new ImgurListFragment();
        return imgurListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_imgur_list, container, false);

        /**
         * SOURCE1: https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit
         * SOURCE2: http://www.androidhive.info/2016/05/android-working-with-retrofit-http-library/
         * SOURCE3: http://www.jsonschema2pojo.org/
         */

        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_layout);
        refreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                callImgur();
            }
        });

        initRecyclerView(view);

        callImgur();


        return view;
    }

    private void initRecyclerView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.imgur_recycler_view);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        imgurRecyclerAdapter = new ImgurRecyclerAdapter();
        recyclerView.setAdapter(imgurRecyclerAdapter);
    }

    private void callImgur() {
        //Imgur API stuff
        ImgurApiInterface apiService =
                ImgurClient.getClient().create(ImgurApiInterface.class);

        Call<ImgurGalleryImage> call = apiService.getGallery();
        call.enqueue(new Callback<ImgurGalleryImage>() {
            @Override
            public void onResponse(Call<ImgurGalleryImage> call, Response<ImgurGalleryImage> response) {
                Log.d(TAG, "Number of movies received: " + response.body());
                imgurRecyclerAdapter.clear();
                imgurRecyclerAdapter.setImgurGalleryImage(response.body());
                imgurRecyclerAdapter.notifyDataSetChanged();
                refreshLayout.setRefreshing(false);

            }

            @Override
            public void onFailure(Call<ImgurGalleryImage> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                refreshLayout.setRefreshing(false);
            }
        });
    }
}
