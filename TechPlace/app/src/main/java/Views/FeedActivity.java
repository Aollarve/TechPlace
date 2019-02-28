package Views;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import Controllers.FeedController;
import Controllers.PostRecyclerFragment;
import Controllers.ProfilePagerAdapter;
import Models.Post;
import Models.PostDataBase;
import project03.csc214.techplace.R;

public class FeedActivity extends AppCompatActivity {

    FeedController mFeedController;
//    PostRecyclerFragment mPostRecyclerFragment;
    ProfilePagerAdapter adapter;
//    ListView mListView;
    TextView mUsernameTextView;
    EditText mPostEditText;
//            , mFindPostsEditText;
    String mUsername = "", mContent = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        controllerSetup();
        mUsernameTextView = findViewById(R.id.username_text);
        mPostEditText = findViewById(R.id.write_post_editText);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mUsername = extras.getString("username");
            mUsernameTextView.setText(mUsername);
        }

//        mListView = findViewById(R.id.listView);
//        PostDataBase db = Room.databaseBuilder(getApplicationContext(),
//                PostDataBase.class, "posts")
//                .allowMainThreadQueries()
//                .build();

//        List<Post> postsInDb = db.postDao().getAll();
//        int sizeOfPostCollection = postsInDb.size();
//        String[] data = new String[sizeOfPostCollection];
//        for (int i = 0; i < postsInDb.size(); i++) {
//            data[i] = postsInDb.get(i).getUsername() + " : " + postsInDb.get(i).getPostContent();
//        }

//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
//        mListView.setAdapter(adapter);

        List<Post> postsInDb = mFeedController.getPosts("andres");

//        mPostRecyclerFragment = new PostRecyclerFragment();
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.fragment_placeholder, mPostRecyclerFragment);
//        ft.commit();

        adapter = new ProfilePagerAdapter(getSupportFragmentManager(), mUsername);
        ViewPager mViewPager = findViewById(R.id.activity_feed_view_pager);
        mViewPager.setAdapter(adapter);
    }

    public void controllerSetup() {
        mFeedController = new FeedController(getApplicationContext());
    }

    public void onProfileClick(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("username", mUsername);
        startActivity(intent);
    }


    public void onWritePostButtonClick(View view) {
        mContent = mPostEditText.getText().toString();
        if(mPostEditText.length() >= 1) {
            Post post = mFeedController.addPost(mUsername, mContent);
            mContent = "";
            mPostEditText.setText(mContent);
//            mPostRecyclerFragment.newPost(post);
            adapter.newPost(post);
//            updateListView();
        }
    }

    public void onSearchPostsButtonClick(View view) {

    }

}
