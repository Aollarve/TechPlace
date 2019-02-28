package Controllers;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.Date;

import Models.PostDataBase;
import Models.Profile;
import Models.ProfileDataBase;
import Models.UserDataBase;

/**
 * Created by andresollarvez on 4/29/18.
 */

public class EditProfileController implements IEditProfileController {

    Context context;
    UserDataBase db;
    ProfileDataBase profDb;

    public EditProfileController(Context context) {
        this.context = context;
        db = Room.databaseBuilder(context,
                UserDataBase.class, "users")
                .allowMainThreadQueries() // ask about this
                .build();

        profDb = Room.databaseBuilder(context,
                ProfileDataBase.class, "profiles")
                .allowMainThreadQueries() // ask about this
                .build();
    }

    @Override
    public void updateProfile(String username, String firstname, String lastname, Date birthdate, String hometown, String bio) {
        Profile prof = profDb.profileDao().getByUsername(username);
        prof.setUsername(username);
        prof.setFirstName(firstname);
        prof.setLastName(lastname);
        prof.setBirthdate(birthdate.toString());
        prof.setHometown(hometown);
        prof.setBio(bio);

        profDb.profileDao().deleteProfile(prof);
        profDb.profileDao().insertProfile(prof);

    }
}
