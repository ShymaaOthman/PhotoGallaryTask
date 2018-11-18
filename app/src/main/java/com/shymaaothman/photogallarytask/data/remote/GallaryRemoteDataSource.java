package com.shymaaothman.photogallarytask.data.remote;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shymaaothman.photogallarytask.downloader.HttpRequestType;
import com.shymaaothman.photogallarytask.data.GallaryDataSource;
import com.shymaaothman.photogallarytask.data.remote.models.ImageItem;
import com.shymaaothman.photogallarytask.downloader.HttpManger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shymaa on 11/16/2018.
 */

public class GallaryRemoteDataSource extends PageKeyedDataSource<Integer, ImageItem>implements GallaryDataSource {

    private final String REQUEST_METHOD = "GET";
    private final String URL = "https://api.unsplash.com/photos";

    public static final int PAGE_SIZE = 10;
    private static final int FIRST_PAGE = 1;
    private static final String CLIENT_ID = "client_id";
    private static final String CLIENT_ID_VALUE = "4d44a100697661ae652a5f26cbf5086a7845708d8c2700f48a6447791c8000fd";
    private static final String PAGE = "page";
    private static final String PER_PAGE = "per_page";



    @Override
    public List<ImageItem> getGallaryImages(int page ,int pagesize) {

        HttpRequestType requestType = new HttpRequestType();
        requestType.setMethod(REQUEST_METHOD);
        requestType.setUrl(URL);
        Map<String,String> param = new HashMap<>();
        param.put(CLIENT_ID,CLIENT_ID_VALUE);
        param.put(PAGE,page+"");
        param.put(PER_PAGE,pagesize+"");
        requestType.setParams(param);
        String output = HttpManger.getData(requestType) ;
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        List<ImageItem> gallaryImagesList =  Arrays.asList(gson.fromJson(output,ImageItem[].class));

        return gallaryImagesList;
    }


    List<ImageItem>items ;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, ImageItem> callback) {

        items = getGallaryImages(FIRST_PAGE,PAGE_SIZE);
        if (items.size()>0)
            callback.onResult(items, null, FIRST_PAGE + 1);


    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ImageItem> callback) {

        List<ImageItem>items = getGallaryImages(params.key,PAGE_SIZE);
        Integer adjacentKey = (params.key > 1) ? params.key - 1 : null;
        if (items != null) {
            callback.onResult(items, adjacentKey);
        }

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ImageItem> callback) {

        List<ImageItem>items = getGallaryImages(params.key,PAGE_SIZE);
        if (items != null && params.key<= 99) {
            callback.onResult(items, params.key + 1);
        }

    }
}
