package in.shrividhya.urbanchef;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import in.shrividhya.urbanchef.data.Recipe;
import in.shrividhya.urbanchef.data.RecipeDao;
import in.shrividhya.urbanchef.data.RecipeDatabase;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class EntityReadWriteTest {
    private RecipeDao recipeDao;
    private RecipeDatabase recipeDatabase;

    @Before
    public void createDb() {
        recipeDatabase = Room.databaseBuilder(InstrumentationRegistry.getContext(), RecipeDatabase.class, "recipe").build();
        recipeDao = recipeDatabase.recipeDao();
    }

    @After
    public void closeDb() {
        recipeDatabase.close();
    }

    @Test
    public void testDb() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Recipe recipe = new Recipe();
                recipe.setTitle("shri");
                recipeDao.insertAll(recipe);
                Recipe recipeResult = recipeDao.findByTitle("shri");
                assertEquals(recipeResult, recipe);
            }
        }).start();
    }
}
