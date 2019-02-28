package Controllers;

import java.util.List;

import Models.Post;
import Models.User;

/**
 * Created by andresollarvez on 4/23/18.
 */

public interface IFeedController {
    void updateDB();
    List<Post> getPosts(String username);
    List<User> getUsers();
//    List<Post> findPosts(String keyword);
    Post addPost(String username, String content);
}
