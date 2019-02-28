package Controllers;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.widget.Toast;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Models.User;
import Models.UserDataBase;

/**
 * Created by andresollarvez on 4/22/18.
 */

public class LoginController implements ILoginController {

    Context context;
    UserDataBase db;

    public LoginController(Context context) {
        this.context = context;
        db = Room.databaseBuilder(context,
                UserDataBase.class, "users")
                .allowMainThreadQueries() // ask about this
                .build();
    }

    @Override
    public Boolean checkValid(String emailUsername, String password) {
        // hash password

        if(isEmailValid(emailUsername)) {
            User user = db.userDao().getByEmail(emailUsername);
            if(user == null) {
                return false;
            } else if(user.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        } else {
            User user = db.userDao().getByUsername(emailUsername);
            if(user == null) {
                return false;
            } else if(user.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public Boolean isEmailValid(String email) {
        Pattern validEmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher match = validEmail.matcher(email);

        return match.find();
    }

    @Override
    public String getUsername(String emailUsername) {
        if(isEmailValid(emailUsername)) {
            User user = db.userDao().getByEmail(emailUsername);
            return user.getUserName();
        } else {
            return emailUsername;
        }

    }

}
