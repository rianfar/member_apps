package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("post_title")
    @Expose
    private String postTitle;
    @SerializedName("post_date")
    @Expose
    private String postDate;
    @SerializedName("post_picture")
    @Expose
    private Object postPicture;

    public Datum(String iD, String postTitle, String postDate, String postPicture) {
        this.iD = iD;
        this.postTitle = postTitle;
        this.postDate = postDate;
        this.postPicture = postPicture;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public Object getPostPicture() {
        return postPicture;
    }

    public void setPostPicture(Object postPicture) {
        this.postPicture = postPicture;
    }
}
