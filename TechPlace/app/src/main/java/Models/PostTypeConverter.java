package Models;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/**
 * Created by andresollarvez on 4/23/18.
 */

// ALL OF THIS WAS MOSTLY OBTAINED FROM A SINGLE SOURCE IN THE INTERNET
// HOWEVER IT CAME WITH A LOT OF PROBLEMS THAT I HAD TO FIX
// AS WELL AS DEPENDENCIES I HAD TO ADD

public class PostTypeConverter {
    @TypeConverter
    public static Long dateToString(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static Date stringToDate(Long value) {
        return value == null ? null : new Date(value);
    }
}
