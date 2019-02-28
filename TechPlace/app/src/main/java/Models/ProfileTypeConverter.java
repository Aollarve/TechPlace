package Models;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by andresollarvez on 4/26/18.
 */

// ALL OF THIS WAS MOSTLY OBTAINED FROM A SINGLE SOURCE IN THE INTERNET
// HOWEVER IT CAME WITH A LOT OF PROBLEMS THAT I HAD TO FIX
// AS WELL AS DEPENDENCIES I HAD TO ADD

public class ProfileTypeConverter {

    @TypeConverter
    public static Long dateToString(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static Date stringToDate(Long value) {
        return value == null ? null : new Date(value);
    }
}
