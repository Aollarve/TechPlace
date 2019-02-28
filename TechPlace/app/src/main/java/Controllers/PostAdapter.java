package Controllers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import Models.Post;
import Views.PostHolder;
import project03.csc214.techplace.R;

/**
 * Created by andresollarvez on 4/25/18.
 */

public class PostAdapter extends RecyclerView.Adapter<PostHolder> {

    private List<Post> mPosts;

    public PostAdapter(List<Post> posts) {
        this.mPosts = posts;
    }

    public PostHolder onCreateViewHolder(ViewGroup parent, int type) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_post, parent, false);
        PostHolder holder = new PostHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position) {
        Post post = mPosts.get(position);
        holder.bindPost(post);
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public void addPost(Post post) {
        mPosts.add(0, post);
        notifyItemInserted(0);
    }
}
