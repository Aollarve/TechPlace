package Controllers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import Models.Post;
import Models.Profile;
import Views.PostHolder;
import Views.ProfileHolder;
import project03.csc214.techplace.R;

/**
 * Created by andresollarvez on 4/28/18.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileHolder> {

    private List<Profile> mProfiles;
    private List<String> mFavProfiles;
    private String mUsername;
    private Context context;

    public ProfileAdapter(List<Profile> profiles, List<String> favs, String username, Context context) {
        this.mProfiles = profiles;
        this.mFavProfiles = favs;
        this.mUsername = username;
        this.context = context;
    }

    public ProfileHolder onCreateViewHolder(ViewGroup parent, int type) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_profile, parent, false);
        ProfileHolder holder = new ProfileHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ProfileHolder holder, int position) {
        Profile profile = mProfiles.get(position);
        String username = profile.getUsername();
        Boolean isFav = false;
        Boolean isUser = false;
        for(int i = 0; i < mFavProfiles.size(); i++) {
            if(mFavProfiles.get(i).equals(username)) {
                isFav = true;
                break;
            } else if(username.equals(mUsername)) {
                isUser = true;
                break;
            }
        }

        if(!isUser) {
            holder.bindProfile(profile, mUsername, isFav, context);
        }

    }

    @Override
    public int getItemCount() {
        return mProfiles.size();
    }

//    public void addPost(Post post) {
//        mProfiles.add(0, post);
//        notifyItemInserted(0);
//    }
}
