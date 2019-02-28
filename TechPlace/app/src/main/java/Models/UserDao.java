package Models;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by andresollarvez on 4/22/18.
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<User> getAll();

//    @Query("SELECT * FROM users WHERE user_id = :id Limit 1")
//    User getById(int id);

    @Query("SELECT * FROM users WHERE username LIKE :username Limit 1")
    User getByUsername(String username);

    @Query("SELECT * FROM users WHERE email LIKE :email Limit 1")
    User getByEmail(String email);

    @Insert
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("DELETE FROM users")
    void deleteAll();


}
