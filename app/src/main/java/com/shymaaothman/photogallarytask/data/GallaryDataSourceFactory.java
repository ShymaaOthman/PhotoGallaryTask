package com.shymaaothman.photogallarytask.data;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

import com.shymaaothman.photogallarytask.data.remote.GallaryRemoteDataSource;
import com.shymaaothman.photogallarytask.data.remote.models.ImageItem;

public class GallaryDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, ImageItem>> itemLiveDataSource = new MutableLiveData<>();


    @Override
    public DataSource<Integer, ImageItem> create() {
        PageKeyedDataSource itemDataSource = new GallaryRemoteDataSource();
        itemLiveDataSource.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, ImageItem>> getImageItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
