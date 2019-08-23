package in.shrividhya.urbanchef;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.shrividhya.urbanchef.data.Recipe;
import in.shrividhya.urbanchef.data.RecipeDao;
import in.shrividhya.urbanchef.data.RecipeDatabase;

public class MainActivity extends AppCompatActivity {

    private static String LOG_TAG = MainActivity.class.getName();
    private static MainActivity _instance;
    private boolean isShowingRecipe = false;
    private static String FRAGMENT_STATE = "state_of_fragment";
    public  static RecipeDao recipeDao = null;
    long recipeId;

    public static MainActivity getInstance() {
        if(_instance == null){
            _instance = new MainActivity();
        }
        return _instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_USER);
        setContentView(R.layout.activity_main);
        Button toggler = findViewById(R.id.toggler);
        if(savedInstanceState != null) {
            isShowingRecipe = savedInstanceState.getBoolean(FRAGMENT_STATE);
        }

        toggler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(isShowingRecipe) {
//                    hideRecipeFragment();
//                } else {
                    showRecipeFragment();
//                }
            }
        });
        addSampleDataToTable();
    }

    private void addSampleDataToTable() {
        recipeDao = RecipeDatabase.getDatabase(getApplicationContext()).getRecipeDao();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(LOG_TAG, "Inserting sample data");
                Recipe recipe = new Recipe();
//                if(recipeDao.findByTitle("BIRYANI") == null) {
                    recipe.setTitle("HELLO");
                    recipe.setCategory("HII");
                    recipe.setChefId("SHRI");
                    recipe.setDescription("Here goes the description");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    JSONObject recipeInfo = Recipe.newJSONObject("15 MINUTES", "xyz");
                    recipe.setInfo(recipeInfo);
//                    recipe.setInfo("{\"text\":\"30 Minutes\",\"text\":\"easy\",\"text\":\"2 People\"}");
                    recipeId = recipeDao.insert(recipe);
                    recipe.setRecipeId((int) recipeId);
                    Log.d(LOG_TAG, "Sample data insertion success");
                    Log.d(LOG_TAG, "rid: "+recipe.getInfo());
                    Log.d(LOG_TAG, "rid: "+recipe.getRecipeId());
                    List rid=recipeDao.getAll();
                    Log.d(LOG_TAG, "info: recipeId: "+recipeId+" "+((rid!=null)?((Recipe) rid.get(rid.size()-1)).toString():"novalue"));
//                }
            }
        }).start();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(FRAGMENT_STATE, isShowingRecipe);
        super.onSaveInstanceState(outState);
    }

    public void showRecipeFragment() {
        RecipeFragment recipeFragment = RecipeFragment.getInstance();
        Bundle arguments = new Bundle();
        arguments.putInt("recipeId", (int) recipeId);
        recipeFragment.setArguments(arguments);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, recipeFragment).addToBackStack(null).commit();
        isShowingRecipe = true;
    }

    public void hideRecipeFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        RecipeFragment recipeFragment = (RecipeFragment) fragmentManager.findFragmentById(R.id.fragment_container);
        if(recipeFragment != null) {
            fragmentManager.beginTransaction().remove(recipeFragment).commit();
        }
        isShowingRecipe = false;
    }

    public void showRecipe() {

    }

//    public void startRecipeActivity(View view) {
//        Intent intent = new Intent(this, RecipeActivity.class);
//
//        HashMap<String, String> specialInfo = new HashMap<>();
//        specialInfo.put("timeTaken", "30 MINUTES");
//        specialInfo.put("difficulty", "EASY");
//        specialInfo.put("servings", "2 PEOPLE");
//
//        ArrayList<String> tags = new ArrayList<>();
//        tags.add("keto");
//        tags.add("vegan");
//        tags.add("200-400 kcal");
//
//        HashMap<String, String> nutritionDetails = new HashMap<>();
//        specialInfo.put("Protein", "12g");
//        specialInfo.put("Carbohydrates", "50g");
//        specialInfo.put("Calories", "300 kcal");
//        specialInfo.put("Fat", "4g");
//
//        Bundle recipeBundle = new Bundle();
//        recipeBundle.putString("meal", "LUNCH");
//        recipeBundle.putString("name", "Chicken Biryani");
//        recipeBundle.putString("description", "Here goes the description");
//
//        recipeBundle.putSerializable("name", specialInfo);
//        recipeBundle.putSerializable("tags", tags);
//        recipeBundle.putSerializable("nutritionDetails", nutritionDetails);
//        startActivity(intent);
//
//    }
}
