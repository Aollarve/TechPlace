package Controllers;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.widget.Toast;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Models.Profile;
import Models.ProfileDataBase;
import Models.User;
import Models.UserDataBase;

/**
 * Created by andresollarvez on 4/22/18.
 */

public class RegisterController implements IRegisterController {

    Context context;
    UserDataBase db;
    ProfileDataBase profDB;

    public RegisterController(Context context) {
        this.context = context;
        db = Room.databaseBuilder(context,
                UserDataBase.class, "users")
                .allowMainThreadQueries() // ask about this
                .build();

        profDB = Room.databaseBuilder(context,
                ProfileDataBase.class, "profiles")
                .allowMainThreadQueries() // ask about this
                .build();


    }

    @Override
    public void updateDB() {
        db = Room.databaseBuilder(context,
                UserDataBase.class, "users")
                .allowMainThreadQueries() // ask about this
                .build();

        profDB = Room.databaseBuilder(context,
                ProfileDataBase.class, "profiles")
                .allowMainThreadQueries() // ask about this
                .build();
    }

    @Override
    public void registerUser(String username, String email, String password) {
        User user = new User();
        user.setUserName(username);
        user.setEmail(email);
        user.setPassword(password);
//        user.addFavoriteUser();
        db.userDao().insertUser(user);
        Profile profile = new Profile();
        User nuser = db.userDao().getByUsername(username);
        profile.setUserId(nuser.getUserId());
        profile.setUsername(username);
        profDB.profileDao().insertProfile(profile);
        updateDB();
    }

    @Override
    public Boolean isUsernameTaken(String username) {
        User user = db.userDao().getByUsername(username);
        if(user == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Boolean isEmailTaken(String email) {
        User user = db.userDao().getByEmail(email);
        if(user == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public  Boolean isUsernameValid(String username) {
        Pattern validUsername = Pattern.compile("[a-zA-Z0-9\\._\\-]{3,}", Pattern.CASE_INSENSITIVE);
        Matcher match = validUsername.matcher(username);

        return match.find();
    }

    @Override
    public Boolean isEmailValid(String email) {
        Pattern validEmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher match = validEmail.matcher(email);

        return match.find();
    }

    @Override
    public Boolean isPasswordValid(String password) {
        Pattern validPassword = Pattern.compile("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", Pattern.CASE_INSENSITIVE);
        Matcher match = validPassword.matcher(password);

        return match.find();
    }
}
