package Models;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

/**
 * Created by andresollarvez on 4/26/18.
 */

@Database(entities = {Profile.class}, version = 1)
@TypeConverters({ProfileTypeConverter.class})
public abstract class ProfileDataBase extends RoomDatabase {

    private  static  ProfileDataBase INSTANCE;

    public abstract ProfileDao profileDao();

    public static ProfileDataBase getProfileDatabase(Context context) {
        if(INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(),
                            ProfileDataBase.class, "profiles")
                            .allowMainThreadQueries()
                            .build();
        }

        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
