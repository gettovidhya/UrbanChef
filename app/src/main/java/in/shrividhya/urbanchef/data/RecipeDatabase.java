package in.shrividhya.urbanchef.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

@Database(entities = {Recipe.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class RecipeDatabase extends RoomDatabase {
    private static RecipeDatabase _instance;
    public abstract RecipeDao getRecipeDao();

    public static RecipeDatabase getDatabase(final Context context){
        if(_instance == null) {
            synchronized (RecipeDatabase.class) {
                if(_instance == null) {
                    _instance = Room.databaseBuilder(context, RecipeDatabase.class, "recipe").build();
                }
            }
        }
        return _instance;
    }
}
