package Views;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Models.Post;
import project03.csc214.techplace.R;
/**
 * Created by andresollarvez on 4/25/18.
 */

public class PostHolder extends RecyclerView.ViewHolder {

    private View mView;
    private TextView mUsername;
    private ImageView mPicture;
    private TextView mContent;
    private TextView mDate;

    public PostHolder(View view) {
        super(view);
        mView = view;
        mUsername = view.findViewById(R.id.username_text);
        mPicture = view.findViewById(R.id.picture_image);
        mContent = view.findViewById(R.id.content_text);
        mDate = view.findViewById(R.id.date_text);


    }

    public void bindPost(final Post post) {
        mUsername.setText(post.getUsername());
        Uri picture = Uri.parse("android.resource://project03.csc214.techplace/" + post.getPicture());
        mPicture.setImageURI(picture);
        mContent.setText(post.getPostContent());
        DateFormat dateFormat = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
        String strDate = dateFormat.format(post.getPostDate());
        mDate.setText(strDate);

//        mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CountryDialogFragment dialogFragment = new CountryDialogFragment();
//                Bundle bundle = new Bundle();
//                bundle.putString("name", country.getName());
//                bundle.putString("capital", country.getCapital());
//                bundle.putFloat("GDP", country.getGDP());
//                bundle.putFloat("perCapitaGDP", country.getPerCapitaGDP());
//                bundle.putString("description", country.getDescription());
//                FragmentManager fragmentManager = ((FragmentActivity) mView.getContext()).getSupportFragmentManager();
//                dialogFragment.setArguments(bundle);
//                dialogFragment.show(fragmentManager, "Fragment Manager");
//
//            }
//        });
    }

}
