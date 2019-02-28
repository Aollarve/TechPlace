package Views;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Controllers.LoginController;
import Models.User;
import Views.FeedActivity;
import project03.csc214.techplace.R;
import Views.RegisterActivity;

public class MainActivity extends AppCompatActivity {

//    private final int FEED_REQUEST_CODE = 1; // Changed LOGIN_REQUEST_CODE to FEED_REQUEST_CODE
//    private final int REGISTER_REQUEST_CODE = 2;
    LoginController mLoginController;
    EditText mEmailUserNameEditText, mPasswordEditText;
//    Button mLoginButton, mRegisterbutton;
    String mEmailUsername, mPassword; // These two variables were not present in the UML


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controllerSetup();
        mEmailUserNameEditText = findViewById(R.id.email_username_editText);
        mPasswordEditText = findViewById(R.id.password_editText);
//        mLoginButton = findViewById(R.id.login_button);
//        mRegisterbutton = findViewById(R.id.register_button);

        if(savedInstanceState != null) {
            mEmailUsername = savedInstanceState.getString("emailusername");
            mPassword = savedInstanceState.getString("password");
            mEmailUserNameEditText.setText(mEmailUsername);
            mPasswordEditText.setText(mPassword);
        }


    }

    private void controllerSetup() {
        mLoginController = new LoginController(getApplicationContext());
    }

    public void onLoginButtonClick(View view) {
        // Launch the feed activity

        mEmailUsername =  mEmailUserNameEditText.getText().toString();
        mPassword = mPasswordEditText.getText().toString();

        if(mLoginController.checkValid(mEmailUsername, mPassword)) {
            Intent intent = new Intent(this, FeedActivity.class);
//            startActivityForResult(intent, FEED_REQUEST_CODE);
            intent.putExtra("username", mLoginController.getUsername(mEmailUsername));
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Incorrect Login Information", Toast.LENGTH_LONG).show();
            mPasswordEditText.setText("");
        }

    }

    public void onRegisterButtonClick(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
//        startActivityForResult(intent, REGISTER_REQUEST_CODE);
//        intent.putExtra("context", (Parcelable) getApplicationContext());
//        List<User> users = null;
//        intent.putParcelableArrayListExtra("context", (ArrayList<? extends Parcelable>) users);
        startActivity(intent);
    }




}
