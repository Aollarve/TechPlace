package Controllers;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;

import Models.Post;
import Models.PostDataBase;
import Models.User;
import Models.UserDataBase;

/**
 * Created by andresollarvez on 4/22/18.
 */

public class FeedController implements IFeedController {

    Context context;
    PostDataBase db;

    public FeedController(Context context) {
        this.context = context;
        db = Room.databaseBuilder(context,
                PostDataBase.class, "posts")
                .allowMainThreadQueries() // ask about this
                .build();
    }

    @Override
    public void updateDB() {
        db = Room.databaseBuilder(context,
                PostDataBase.class, "posts")
                .allowMainThreadQueries() // ask about this
                .build();
    }

    @Override
    public List<Post> getPosts(String username) {
        List<Post> posts = db.postDao().getByUsername(username);
        return posts;
    }

    @Override
    public List<User> getUsers() {
        UserDataBase userDB = Room.databaseBuilder(context,
                UserDataBase.class, "users")
                .allowMainThreadQueries() // ask about this
                .build();
        List<User> users = userDB.userDao().getAll();
        return users;
    }

//    @Override
//    public List<Post> findPosts(String keyword) {
//        return null;
//    }

    @Override
    public Post addPost(String username, String content) {
        UserDataBase userdb = Room.databaseBuilder(context,
                UserDataBase.class, "users")
                .allowMainThreadQueries() // ask about this
                .build();
        User user = userdb.userDao().getByUsername(username);


        Post post = new Post(username, "mipmap/ic_launcher", content);
        db.postDao().insertPost(post);
        updateDB();
        return post;
    }
}
