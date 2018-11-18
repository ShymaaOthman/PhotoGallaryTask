package com.shymaaothman.photogallarytask.data.remote.models;

/**
 * Created by Shymaa on 11/16/2018.
 */

public class ImageItem {

    private String id;

    private String height;

    private String color;

    private String likes;

    private String width;

    private String created_at;

    private Links links;

    private String liked_by_user;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    public String getColor ()
    {
        return color;
    }

    public void setColor (String color)
    {
        this.color = color;
    }

    public String getLikes ()
    {
        return likes;
    }

    public void setLikes (String likes)
    {
        this.likes = likes;
    }

    public String getWidth ()
    {
        return width;
    }

    public void setWidth (String width)
    {
        this.width = width;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public Links getLinks ()
    {
        return links;
    }

    public void setLinks (Links links)
    {
        this.links = links;
    }

    public String getLiked_by_user ()
    {
        return liked_by_user;
    }

    public void setLiked_by_user (String liked_by_user)
    {
        this.liked_by_user = liked_by_user;
    }


}
