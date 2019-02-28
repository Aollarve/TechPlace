package Controllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import Models.Post;

/**
 * Created by andresollarvez on 4/28/18.
 */

public class ProfilePagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> mFragments;
    private PostRecyclerFragment mPostRecyclerFragment;
    private ProfileRecyclerFragment mProfileRecyclerFragment;

    public ProfilePagerAdapter(FragmentManager manager, String username) {
        super(manager);
//        mCountries = co
        mFragments = new ArrayList<>();
        mPostRecyclerFragment = new PostRecyclerFragment();
        mProfileRecyclerFragment = new ProfileRecyclerFragment();
        Bundle args = new Bundle();
        args.putString("username", username);
        Bundle args2 = new Bundle();
        args2.putString("username", username);
        mProfileRecyclerFragment.setArguments(args);
        mPostRecyclerFragment.setArguments(args);
        mFragments.add(mPostRecyclerFragment);
        mFragments.add(mProfileRecyclerFragment);

    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    public void newPost(Post post) {
        mPostRecyclerFragment.newPost(post);
    }

}
