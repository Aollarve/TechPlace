package Controllers;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Controllers.PostAdapter;
import Models.Post;
import Models.PostDataBase;
import Models.ProfileDataBase;
import Models.User;
import Models.UserDataBase;
import project03.csc214.techplace.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Post2RecyclerFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private PostAdapter mAdapter;
    private String mUsername;

    private static final String USERNAME = "username";
    private static final String CONTENT = "content";
    private static final String PICTURE = "picture";
    private static final String DATE = "date";

    public Post2RecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post_recycler, container, false);

        mUsername = getArguments().getString("username");

        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity()));
        PostDataBase db = Room.databaseBuilder(getContext(),
                PostDataBase.class, "posts")
                .allowMainThreadQueries()
                .build();

        UserDataBase userdb = Room.databaseBuilder(getContext(),
                UserDataBase.class, "users")
                .allowMainThreadQueries()
                .build();

        List<Post> postsInDb = new ArrayList<Post>();
//        for(String fav : favs) {
//            for(Post post : db.postDao().getByUsername(fav)) {
//                postsInDb.add(post);
//            }
//        }

        for(Post post : db.postDao().getAll()) {
            if(post.getUsername().equals(mUsername)) {
                postsInDb.add(post);
            }
        }
        Collections.reverse(postsInDb);

//        int sizeOfPostCollection = postsInDb.size();
//        String[] data = new String[sizeOfPostCollection];
//        for (int i = 0; i < postsInDb.size(); i++) {
//            data[i] = postsInDb.get(i).getUsername() + " : " + postsInDb.get(i).getPostContent();
//        }
        mAdapter = new PostAdapter(postsInDb);
        mRecyclerView.setAdapter(mAdapter);
        return view;

    }

//    public void newPost(Post post) {
//        mAdapter.addPost(post);
//        mRecyclerView.smoothScrollToPosition(0);
//    }
}

