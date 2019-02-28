package Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;
import java.util.List;

/**
 * Created by andresollarvez on 4/26/18.
 */

@Entity(tableName = "profiles")
public class Profile {

    @PrimaryKey
    @ColumnInfo(name="user_id")
    private int mUserId;
    @ColumnInfo(name="username")
    private String mUsername;
    @ColumnInfo(name="first_name")
    private String mFirstName;
    @ColumnInfo(name="last_name")
    private String mLastName;
    @ColumnInfo(name="birthdate")
    private String mBirthdate;
    @ColumnInfo(name="hometown")
    private String mHometown;
    @ColumnInfo(name="picture")
    private String mPicture;
    @ColumnInfo(name="bio")
    private String mBio;

    public Profile() {
        this.mFirstName = "";
        this.mLastName = "";
        this.mBirthdate = "";
        this.mHometown = "";
        this.mPicture = "mipmap/ic_launcher";
        this.mBio = "";
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int mUserId) {
        this.mUserId = mUserId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getBirthdate() {
        return mBirthdate;
    }

    public void setBirthdate(String mBirthdate) {
        this.mBirthdate = mBirthdate;
    }

    public String getHometown() {
        return mHometown;
    }

    public void setHometown(String mHometown) {
        this.mHometown = mHometown;
    }

    public String getPicture() {
        return mPicture;
    }

    public void setPicture(String mPicture) {
        this.mPicture = mPicture;
    }

    public String getBio() {
        return mBio;
    }

    public void setBio(String mBio) {
        this.mBio = mBio;
    }
}
