package com.shymaaothman.photogallarytask.data;

import com.shymaaothman.photogallarytask.data.remote.models.ImageItem;

import java.util.List;

/**
 * Created by Shymaa on 11/16/2018.
 */

public interface GallaryDataSource {

    public List<ImageItem> getGallaryImages(int page , int pagesize);
}
