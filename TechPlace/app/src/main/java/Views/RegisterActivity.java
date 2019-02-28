package Views;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Controllers.RegisterController;
import Models.Profile;
import Models.ProfileDataBase;
import Models.User;
import Models.UserDataBase;
import project03.csc214.techplace.R;

public class RegisterActivity extends AppCompatActivity {

//    private final int FEED_REQUEST_CODE = 1;
    RegisterController mRegisterController;
    TextView mUsernameTakenTextView, mUsernameInvalidTextView, mEmailTakenTextView, mEmailInvalidTextView, mEmailsDifferentTextView, mPasswordInvalidTextView, mPasswordsDifferentTextView;
    Boolean mUsernameTaken, mEmailTaken, mEmailsDifferent, mPasswordInvalid, mPasswordsDifferent;
    EditText mUsernameEditText, mEmailEditText, mEmailRepeatEditText, mPasswordEditText, mPasswordRepeatEditText;
    String mUsername, mEmail, mEmailRepeat, mPassword, mPasswordRepeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        controllerSetup();

        mUsernameEditText = findViewById(R.id.username_editText);
        mEmailEditText = findViewById(R.id.email_editText);
        mEmailRepeatEditText = findViewById(R.id.repeat_email_editText);
        mPasswordEditText = findViewById(R.id.password_editText);
        mPasswordRepeatEditText = findViewById(R.id.repeat_password_editText);

        mUsernameTakenTextView = findViewById(R.id.username_taken_text);
        mUsernameInvalidTextView = findViewById(R.id.username_invalid_text);
        mEmailTakenTextView = findViewById(R.id.email_taken_text);
        mEmailInvalidTextView = findViewById(R.id.email_invalid_text);
        mEmailsDifferentTextView = findViewById(R.id.emails_different_text);
        mPasswordInvalidTextView = findViewById(R.id.password_invalid_text);
        mPasswordsDifferentTextView = findViewById(R.id.passwords_different_text);


        mUsernameTakenTextView.setVisibility(View.GONE);
        mUsernameInvalidTextView.setVisibility(View.GONE);
        mEmailTakenTextView.setVisibility(View.GONE);
        mEmailInvalidTextView.setVisibility(View.GONE);
        mEmailsDifferentTextView.setVisibility(View.GONE);
        mPasswordInvalidTextView.setVisibility(View.GONE);
        mPasswordsDifferentTextView.setVisibility(View.GONE);


    }

    public void controllerSetup() {
        mRegisterController = new RegisterController(getApplicationContext());
    }

    public void onRegisterButtonClick(View view) {

        mUsername = mUsernameEditText.getText().toString();
        mEmail = mEmailEditText.getText().toString();
        mEmailRepeat = mEmailRepeatEditText.getText().toString();
        mPassword = mPasswordEditText.getText().toString();
        mPasswordRepeat = mPasswordRepeatEditText.getText().toString();

        Boolean proceed = true;
        if(!mEmail.equals(mEmailRepeat)) {
            proceed = false;
            mEmailTakenTextView.setVisibility(View.GONE);
            mEmailInvalidTextView.setVisibility(View.GONE);
            mEmailsDifferentTextView.setVisibility(View.VISIBLE);
        } else if(!mRegisterController.isEmailValid(mEmail)){
            proceed = false;
            mEmailTakenTextView.setVisibility(View.GONE);
            mEmailInvalidTextView.setVisibility(View.VISIBLE);
            mEmailsDifferentTextView.setVisibility(View.GONE);
        } else if(mRegisterController.isEmailTaken(mEmail)) {
            proceed = false;
            mEmailTakenTextView.setVisibility(View.VISIBLE);
            mEmailInvalidTextView.setVisibility(View.GONE);
            mEmailsDifferentTextView.setVisibility(View.GONE);
        } else {
            mEmailTakenTextView.setVisibility(View.GONE);
            mEmailInvalidTextView.setVisibility(View.GONE);
            mEmailsDifferentTextView.setVisibility(View.GONE);
        }

        if(!mPassword.equals(mPasswordRepeat)) {
            proceed = false;
            mPasswordInvalidTextView.setVisibility(View.GONE);
            mPasswordsDifferentTextView.setVisibility(View.VISIBLE);
        }  else if(!mRegisterController.isPasswordValid(mPassword)) {
            proceed = false;
            mPasswordInvalidTextView.setVisibility(View.VISIBLE);
            mPasswordsDifferentTextView.setVisibility(View.GONE);
        } else {
            mPasswordInvalidTextView.setVisibility(View.GONE);
            mPasswordsDifferentTextView.setVisibility(View.GONE);
        }

        if(!mRegisterController.isUsernameValid(mUsername)) {
            proceed = false;
            mUsernameInvalidTextView.setVisibility(View.VISIBLE);
            mUsernameTakenTextView.setVisibility(View.GONE);
        } else if(mRegisterController.isUsernameTaken(mUsername)) {
            proceed = false;
            mUsernameInvalidTextView.setVisibility(View.GONE);
            mUsernameTakenTextView.setVisibility(View.VISIBLE);
        } else {
            mUsernameInvalidTextView.setVisibility(View.GONE);
            mUsernameTakenTextView.setVisibility(View.GONE);
        }

        if(proceed) {
            mRegisterController.registerUser(mUsername, mEmail, mPassword);
            ProfileDataBase profileDB = Room.databaseBuilder(this,
                    ProfileDataBase.class, "profiles")
                    .allowMainThreadQueries()
                    .build();

            List<Profile> profilesInDb = profileDB.profileDao().getAll();
//            Toast.makeText(getApplicationContext(), Integer.toString(profilesInDb.size()), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, FeedActivity.class);
            intent.putExtra("username", mUsername);
//            startActivityForResult(intent, FEED_REQUEST_CODE);
            startActivity(intent);
        }

//        UserDataBase db = Room.databaseBuilder(getApplicationContext(),
//                UserDataBase.class, "users")
//                .allowMainThreadQueries() // ask about this
//                .build();
//
//        List<User> usersInDb = db.userDao().getAll();
//        if(db.userDao().getByUsername())

    }

}
