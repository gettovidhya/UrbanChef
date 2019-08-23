package in.shrividhya.urbanchef.data;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;

import org.json.JSONObject;

public class Converters {
    @TypeConverter
    public static String JSONToString(JSONObject jsonObject){
        try {
            Gson gson = new Gson();
            return gson.toJson(jsonObject);
        } catch (Exception e) {
            return null;
        }
    }

    @TypeConverter
    public static JSONObject StringToJSON(String str) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(str, JSONObject.class);
        } catch (Exception e) {
            return null;
        }
    }
}
