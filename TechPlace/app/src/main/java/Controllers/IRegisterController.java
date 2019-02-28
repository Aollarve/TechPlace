package Controllers;

import android.content.Context;

/**
 * Created by andresollarvez on 4/22/18.
 */

public interface IRegisterController {
    void updateDB();
    void registerUser(String username, String email, String password);
    Boolean isUsernameTaken(String username);
    Boolean isEmailTaken(String email);
    Boolean isUsernameValid(String username);
    Boolean isEmailValid(String email);
    Boolean isPasswordValid(String password);
}
