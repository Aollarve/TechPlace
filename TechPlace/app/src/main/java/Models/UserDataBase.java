package Models;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

/**
 * Created by andresollarvez on 4/22/18.
 */

@Database(entities = {User.class}, version = 1)
@TypeConverters({UserTypeConverter.class})
public abstract class UserDataBase extends RoomDatabase {

    private  static  UserDataBase INSTANCE;

    public abstract UserDao userDao();

    public static UserDataBase getUserDatabase(Context context) {
        if(INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(),
                            UserDataBase.class, "users")
                    .allowMainThreadQueries()
                    .build();
        }

        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
