package Controllers;

/**
 * Created by andresollarvez on 4/22/18.
 */

public interface ILoginController {
    Boolean checkValid(String emailUsername, String password);
    Boolean isEmailValid(String email);
    String getUsername(String emailUsername);
}
