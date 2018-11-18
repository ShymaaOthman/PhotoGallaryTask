package com.shymaaothman.photogallarytask.presentation;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;

import com.shymaaothman.photogallarytask.data.GallaryDataSourceFactory;
import com.shymaaothman.photogallarytask.data.remote.GallaryRemoteDataSource;
import com.shymaaothman.photogallarytask.data.remote.models.ImageItem;

public class ItemViewModel extends ViewModel {

    LiveData<PagedList<ImageItem>> itemPagedList;
    LiveData<PageKeyedDataSource<Integer, ImageItem>> liveDataSource;

    public ItemViewModel() {
        GallaryDataSourceFactory itemDataSourceFactory = new GallaryDataSourceFactory();
        liveDataSource = itemDataSourceFactory.getImageItemLiveDataSource();

        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(GallaryRemoteDataSource.PAGE_SIZE).build();

        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, pagedListConfig))
                .build();
    }
}
