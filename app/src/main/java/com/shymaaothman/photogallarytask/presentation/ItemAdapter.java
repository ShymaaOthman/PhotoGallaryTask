package com.shymaaothman.photogallarytask.presentation;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.shymaaothman.photogallarytask.downloader.ImageLoader;
import com.shymaaothman.photogallarytask.R;
import com.shymaaothman.photogallarytask.data.remote.models.ImageItem;

public class ItemAdapter extends PagedListAdapter<ImageItem, ItemAdapter.ItemViewHolder> {

    private Context context;

    ItemAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.photo_grid_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ImageItem item = getItem(position);

        if (item != null) {

            ImageLoader.getInstance(context).DisplayImage(item.getLinks().getDownload(),holder.imageView);

        }else{
            Toast.makeText(context, "ImageItem is null", Toast.LENGTH_LONG).show();
        }
    }

    private static DiffUtil.ItemCallback<ImageItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ImageItem>() {
                @Override
                public boolean areItemsTheSame(ImageItem oldItem, ImageItem newItem) {
                    return oldItem.getId().equals(newItem.getId()) ;
                }

                @Override
                public boolean areContentsTheSame(ImageItem oldItem, ImageItem newItem) {
                    return oldItem.equals(newItem);
                }
            };

    class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.photo_imageView);
        }
    }
}
