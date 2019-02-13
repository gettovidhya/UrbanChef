package in.shrividhya.urbanchef;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_USER);
        setContentView(R.layout.activity_main);
    }

    public void startRecipeActivity(View view) {
        Intent intent = new Intent(this, RecipeActivity.class);

        HashMap<String, String> specialInfo = new HashMap<>();
        specialInfo.put("timeTaken", "30 MINUTES");
        specialInfo.put("difficulty", "EASY");
        specialInfo.put("servings", "2 PEOPLE");

        ArrayList<String> tags = new ArrayList<>();
        tags.add("keto");
        tags.add("vegan");
        tags.add("200-400 kcal");

        HashMap<String, String> nutritionDetails = new HashMap<>();
        specialInfo.put("Protein", "12g");
        specialInfo.put("Carbohydrates", "50g");
        specialInfo.put("Calories", "300 kcal");
        specialInfo.put("Fat", "4g");

        Bundle recipeBundle = new Bundle();
        recipeBundle.putString("meal", "LUNCH");
        recipeBundle.putString("name", "Chicken Biryani");
        recipeBundle.putString("description", "Here goes the description");

        recipeBundle.putSerializable("name", specialInfo);
        recipeBundle.putSerializable("tags", tags);
        recipeBundle.putSerializable("nutritionDetails", nutritionDetails);
        startActivity(intent);

    }
}
