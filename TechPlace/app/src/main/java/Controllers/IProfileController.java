package Controllers;

import Models.Profile;

/**
 * Created by andresollarvez on 4/26/18.
 */

public interface IProfileController {

    Profile getProfile(String username);
}
