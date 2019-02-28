package Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andresollarvez on 4/22/18.
 */

@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="user_id")
    private int mUserId;
    @ColumnInfo(name="username")
    private String mUserName;
    @ColumnInfo(name="email")
    private String mEmail;
    @ColumnInfo(name="password")
    private String mPassword;
    @ColumnInfo(name="favorite_users")
    private List<String> mFavoriteUsers;

    public User() {
        this.mFavoriteUsers = new ArrayList<String>();
    }

    public User(String email, String username, String password) {
        this.mEmail = email;
        this.mUserName = username;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int mUserId) { this.mUserId = mUserId; }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) { this.mUserName = mUserName; }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) { this.mEmail = mEmail; }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) { this.mPassword = mPassword; }  // Same as updatePassword

    public List<String> getFavoriteUsers() { return mFavoriteUsers; }

    public void setFavoriteUsers(List<String> mFavoriteUsers) { this.mFavoriteUsers = mFavoriteUsers; }

    public void emailUpdate(String newEmail) {
        this.mEmail = newEmail;
    }

    public void updatePassword(String newPassword) {
        this.mPassword = newPassword;
    } // Same as setPassword

    public void addFavoriteUser(String username) {
        mFavoriteUsers.add(username);
    }

    public void removeFavoriteUser(String username) { mFavoriteUsers.remove(username); }


}
