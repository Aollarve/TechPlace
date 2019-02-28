package Models;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

/**
 * Created by andresollarvez on 4/23/18.
 */

@Database(entities = {Post.class}, version = 1)
@TypeConverters({PostTypeConverter.class})
public abstract class PostDataBase extends RoomDatabase {

    private  static  PostDataBase INSTANCE;

    public abstract PostDao postDao();

    public static PostDataBase getPostDatabase(Context context) {
        if(INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(),
                            PostDataBase.class, "posts")
                            .allowMainThreadQueries()
                            .build();
        }

        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
