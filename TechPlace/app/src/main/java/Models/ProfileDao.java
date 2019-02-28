package Models;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by andresollarvez on 4/26/18.
 */

@Dao
public interface ProfileDao {

    @Query("SELECT * FROM profiles")
    List<Profile> getAll();

    @Query("SELECT * FROM profiles WHERE user_id LIKE :userID Limit 1")
    Profile getByUserId(int userID);

    @Query("SELECT * FROM profiles WHERE username LIKE :username Limit 1")
    Profile getByUsername(String username);



    @Delete
    void deleteProfile(Profile profile);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProfile(Profile profile);
}
