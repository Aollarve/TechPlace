package Controllers;

import java.util.Date;

/**
 * Created by andresollarvez on 4/29/18.
 */

public interface IEditProfileController {
    void updateProfile(String username, String firstname, String lastname, Date birthdate, String hometown, String bio);

}
