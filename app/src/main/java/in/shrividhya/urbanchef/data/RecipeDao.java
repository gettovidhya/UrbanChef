package in.shrividhya.urbanchef.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface RecipeDao {

    @Query("SELECT * FROM recipe")
    List<Recipe> getAll();

    @Query("SELECT * FROM recipe WHERE chefId IN (:chefIds)")
    List<Recipe> loadAllByIds(int[] chefIds);

    @Query("SELECT * FROM recipe WHERE title LIKE :name LIMIT 1")
    Recipe findByTitle(String name);

    @Query("SELECT * FROM recipe WHERE recipeId LIKE :id LIMIT 1")
    Recipe findById(int id);

    @Insert
    void insertAll(Recipe... recipes);

    @Delete
    void delete(Recipe recipe);
}
