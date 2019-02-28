package Views;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Controllers.ProfileController;
import Models.Post;
import Models.Profile;
import Models.ProfileDataBase;
import Models.User;
import Models.UserDataBase;
import project03.csc214.techplace.R;

/**
 * Created by andresollarvez on 4/26/18.
 */

public class ProfileHolder extends RecyclerView.ViewHolder {

    private View mView;
    private ImageView mPicture;
    private TextView mUsername;
    private TextView mFullName;
    private Button mFavorite;

    public ProfileHolder(View view) {
        super(view);
        mView = view;
        mPicture = view.findViewById(R.id.picture_image);
        mUsername = view.findViewById(R.id.username_text);
        mFullName = view.findViewById(R.id.fullname_text);
        mFavorite = view.findViewById(R.id.favorite_button);


    }

    public void bindProfile(final Profile profile, final String username, Boolean favorite, final Context context) {
        mUsername.setText(profile.getUsername());
        Uri picture = Uri.parse("android.resource://project03.csc214.techplace/" + profile.getPicture());
        mPicture.setImageURI(picture);
        mFullName.setText(profile.getFirstName() + " " + profile.getLastName());
        if(favorite) {
            mFavorite.setText("Delete from Favorites");
        } else {
            mFavorite.setText("Add to Favorites");
        }

        mFavorite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UserDataBase db = Room.databaseBuilder(context,
                        UserDataBase.class, "users")
                        .allowMainThreadQueries() // ask about this
                        .build();
                User user = db.userDao().getByUsername(username);

                if(mFavorite.getText().toString().equals("Delete from Favorites")) {
                    user.removeFavoriteUser(profile.getUsername());
                    db.userDao().deleteUser(user);
                    db.userDao().insertUser(user);
                    mFavorite.setText("Add to Favorites");
                } else {
                    user.addFavoriteUser(profile.getUsername());
                    db.userDao().deleteUser(user);
                    db.userDao().insertUser(user);
                    mFavorite.setText("Delete from Favorites");
                }

            }
        });

    }

}