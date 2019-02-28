package Controllers;

import android.arch.persistence.room.Room;
import android.content.Context;

import Models.PostDataBase;
import Models.Profile;
import Models.ProfileDataBase;
import Models.User;
import Models.UserDataBase;

/**
 * Created by andres on 4/26/18.
 */

public class ProfileController implements IProfileController {

    Context context;
    UserDataBase userDB;
    ProfileDataBase profileDB;
    PostDataBase postDB;


    public ProfileController(Context context) {
        this.context = context;
        profileDB = Room.databaseBuilder(context,
                ProfileDataBase.class, "profiles")
                .allowMainThreadQueries() // ask about this
                .build();

        userDB = Room.databaseBuilder(context,
                UserDataBase.class, "users")
                .allowMainThreadQueries() // ask about this
                .build();
    }

    @Override
    public Profile getProfile(String username) {
        Profile profile = profileDB.profileDao().getByUsername(username);
        if(profile != null) {
            return profile;
        } else {
            Profile newprof = new Profile();
            User user = userDB.userDao().getByUsername(username);
            newprof.setUserId(user.getUserId());
            newprof.setUsername(username);
            return newprof;
        }
    }
}
