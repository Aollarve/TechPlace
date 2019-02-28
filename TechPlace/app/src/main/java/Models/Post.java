package Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by andresollarvez on 4/22/18.
 */

@Entity(tableName = "posts")
public class Post {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "post_id")
    int mPostId;
    @ColumnInfo(name = "username")
    String mPostUserName;
    @ColumnInfo(name = "picture")
    String mUserPicture;
    @ColumnInfo(name = "content")
    String mPostContent;
    @ColumnInfo(name = "date")
    Date mPostDate;

    public Post(String username, String userpicture, String content) {
        this.mPostUserName = username;
        this.mUserPicture = userpicture;
        this.mPostContent = content;
        this.mPostDate = new Date();
    }

    public Post() {}

    public void editContent(String newContent) {
        this.mPostContent = newContent;
    }

    public void updatePicture(String newPicture) {
        this.mUserPicture = newPicture;
    }


    public int getPostId() {
        return mPostId;
    }

    public void setPostId(int postId) {
        this.mPostId = postId;
    }

    public String getUsername() {
        return mPostUserName;
    }

    public void setUsername(String username) {
        this.mPostUserName = username;
    }

    public String getPicture() {
        return mUserPicture;
    }

    public void setPicture(String picture) {
        this.mUserPicture = picture;
    }

    public String getPostContent() {
        return mPostContent;
    }

    public void setPostContent(String content) {
        this.mPostContent = content;
    }

    public Date getPostDate() {
        return mPostDate;
    }

    public void setPostDate(Date date) {
        this.mPostDate = date;
    }
}
