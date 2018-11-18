package com.shymaaothman.photogallarytask.presentation;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.shymaaothman.photogallarytask.R;
import com.shymaaothman.photogallarytask.data.remote.models.ImageItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoGallaryActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
     RecyclerView recyclerView;
    @BindView(R.id.progress)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initViews();

    }

    private void initViews() {

        int columns = 3;
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, columns);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


    }

    @Override
    protected void onResume() {
        super.onResume();

        observeViewModel();
    }

    private void observeViewModel() {

        final ItemAdapter adapter = new ItemAdapter(this);
        recyclerView.setAdapter(adapter);

        progressBar.setVisibility(View.VISIBLE);
        ItemViewModel itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        itemViewModel.itemPagedList.observe(this, new Observer<PagedList<ImageItem>>() {
            @Override
            public void onChanged(@Nullable PagedList<ImageItem> items) {
                progressBar.setVisibility(View.GONE);
                adapter.submitList(items);
            }
        });

    }
}
