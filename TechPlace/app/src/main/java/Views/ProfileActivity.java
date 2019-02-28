package Views;

import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import Controllers.Profile2PagerAdapter;
import Controllers.ProfileController;
import Controllers.ProfilePagerAdapter;
import Models.Profile;
import project03.csc214.techplace.R;

public class ProfileActivity extends AppCompatActivity {

    ProfileController mProfileController;
    Profile2PagerAdapter adapter;
    TextView mUsernameTextView, mFullNameTextView, mHometownTextView, mBirthdateTextView, mBioTextView;
    ImageView mPictureImageView;
    String mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        controllerSetup();
        mUsernameTextView = findViewById(R.id.username_text);
        mFullNameTextView = findViewById(R.id.fullname_text);
        mBirthdateTextView = findViewById(R.id.birthdate_text);
        mHometownTextView = findViewById(R.id.hometown_text);
        mBioTextView = findViewById(R.id.bio_text);
        mPictureImageView = findViewById(R.id.picture_image);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mUsername = extras.getString("username");
            Profile profile = mProfileController.getProfile(mUsername);
            mUsernameTextView.setText(profile.getUsername());
            mFullNameTextView.setText(profile.getFirstName() + " " + profile.getLastName());
            mBirthdateTextView.setText(profile.getBirthdate().toString());
            mHometownTextView.setText(profile.getHometown());
            mBioTextView.setText(profile.getBio());
            Uri picture = Uri.parse("android.resource://project03.csc214.techplace/" + profile.getPicture());
            mPictureImageView.setImageURI(picture);
        }

        adapter = new Profile2PagerAdapter(getSupportFragmentManager(), mUsername);
        ViewPager mViewPager = findViewById(R.id.activity_profile_view_pager);
        mViewPager.setAdapter(adapter);

    }

    private void controllerSetup() {
        mProfileController = new ProfileController(getApplicationContext());
    }
}
