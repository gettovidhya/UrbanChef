package in.shrividhya.urbanchef;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.shrividhya.urbanchef.data.Recipe;
import in.shrividhya.urbanchef.data.RecipeDao;
import in.shrividhya.urbanchef.data.RecipeDatabase;

public class RecipeFragment extends Fragment {
    private static final String LOG_TAG = RecipeFragment.class.getName();
    private int recipeId;
    public Recipe recipe;
    private RecipeDatabase recipeDatabase;
    private RecipeDao recipeDao;
    private static RecipeFragment _instance;

    public static RecipeFragment getInstance() {
        if(_instance == null) {
            _instance = new RecipeFragment();
        }
        return _instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_recipe, container, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            setRecipeArguments(arguments);

            TextView recipeTitle = rootView.findViewById(R.id.recipeTitle);
            TextView category = rootView.findViewById(R.id.category);
            TextView recipeInfo = rootView.findViewById(R.id.recipeInfoText1);
            TextView tags = rootView.findViewById(R.id.tagsText);
            TextView description = rootView.findViewById(R.id.description);
            TextView nutritionDetails = rootView.findViewById(R.id.nutritionDetails);

            if(recipe == null) recipe = new Recipe();
            recipeTitle.setText(recipe.getTitle());
//        recipeInfo.setText(recipe.getInfo());
            category.setText(recipe.getCategory());
//        tags.setText(recipe.getTags());
            description.setText(recipe.getDescription());
            nutritionDetails.setText(recipe.getNutritionDetails());
        }
        // TODO: Add event listener for page viewer

        return rootView;
    }

    private void setRecipeArguments(Bundle arguments) {
        recipeId = arguments.getInt("recipe_id");
//        recipe = (Recipe) arguments.getSerializable("recipeDetails");
        Context context = this.getContext();
        if(context != null) {
            recipeDatabase = Room.databaseBuilder(getContext(), RecipeDatabase.class, "recipe").build();
            recipeDao = recipeDatabase.getRecipeDao();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    recipe = new Recipe();
                    recipe = recipeDao.findById(recipeId);
                }
            }).start();
        } else {
            Log.d(LOG_TAG, "Error creating DB, Context is null");
        }
    }
}
