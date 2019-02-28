package Controllers;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import Models.Profile;
import Models.ProfileDataBase;
import Models.User;
import Models.UserDataBase;
import project03.csc214.techplace.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileRecyclerFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ProfileAdapter mAdapter;
    private String mUsername;


    public ProfileRecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_recycler, container, false);
        this.mUsername = getArguments().getString("username");

        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity()));
        ProfileDataBase profileDB = Room.databaseBuilder(getContext(),
                ProfileDataBase.class, "profiles")
                .allowMainThreadQueries()
                .build();

        List<Profile> profilesInDb = profileDB.profileDao().getAll();

        UserDataBase userDB = Room.databaseBuilder(getContext(),
                UserDataBase.class, "users")
                .allowMainThreadQueries()
                .build();

        User user = userDB.userDao().getByUsername(mUsername);

        List<String>  favsInDb = user.getFavoriteUsers();

//        Toast.makeText(getContext(), Integer.toString(favsInDb.size()), Toast.LENGTH_LONG).show();
//        int sizeOfPostCollection = postsInDb.size();
//        String[] data = new String[sizeOfPostCollection];
//        for (int i = 0; i < postsInDb.size(); i++) {
//            data[i] = postsInDb.get(i).getUsername() + " : " + postsInDb.get(i).getPostContent();
//        }
        mAdapter = new ProfileAdapter(profilesInDb, favsInDb, mUsername, getContext());
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

}
