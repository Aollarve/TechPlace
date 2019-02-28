package Models;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by andresollarvez on 4/22/18.
 */

// ALL OF THIS WAS MOSTLY OBTAINED FROM A SINGLE SOURCE IN THE INTERNET
    // HOWEVER IT CAME WITH A LOT OF PROBLEMS THAT I HAD TO FIX
    // AS WELL AS DEPENDENCIES I HAD TO ADD

public class UserTypeConverter {
    @TypeConverter
    public static String listOfUsersToString(List<String> users) {
        Gson gson = new Gson();
        String json = gson.toJson(users);
        return json;
    }

    @TypeConverter
    public static List<String> stringToListOfUsers(String users) {
        Type listType = new TypeToken<List<String>>() {}.getType();
        return new Gson().fromJson(users, listType);
    }
}
