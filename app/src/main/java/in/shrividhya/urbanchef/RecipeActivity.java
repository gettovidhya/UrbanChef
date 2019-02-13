package in.shrividhya.urbanchef;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class RecipeActivity extends AppCompatActivity {
    private static final String LOG_TAG = RecipeActivity.class.getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null) {
            Toast.makeText(this, "NOT SHOWING RECIPE: (Err) Data unavailable", Toast.LENGTH_LONG).show();
            Log.e(LOG_TAG, "Bundle årguments not passed, Not showing UI");
            finish();
        } else {
            setRecipeArguments(bundle);
        }
    }

    private void setRecipeArguments(Bundle bundle) {

    }
}
