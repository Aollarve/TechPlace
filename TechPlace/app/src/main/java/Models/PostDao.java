package Models;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by andresollarvez on 4/22/18.
 */

@Dao
public interface PostDao {

    @Query("SELECT * FROM posts")
    List<Post> getAll();

    @Query("SELECT * FROM posts WHERE username = :username")
    List<Post> getByUsername(String username);


    @Insert
    void insertPost(Post post);

}
