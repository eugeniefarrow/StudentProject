package org.pltw.examples.math_inq;

import android.media.Image;

import java.util.ArrayList;

/**
 * Created by 1005269 on 5/12/2017.
 */
public class Photo {
    private Image photo;
    private String user;
    private ArrayList<String> comments;

    public Photo(Image photo,String user){
        this.photo = photo;
        this.user = user;
    }
    public Photo(Image photo, String user, String comment){
        this.photo = photo;
        this.user = user;
        comments.add(comment);
    }

}
