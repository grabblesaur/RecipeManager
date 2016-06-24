package com.qqq.recipemanager.activity;

import android.app.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.qqq.recipemanager.R;
import com.qqq.recipemanager.fragment.RecipeListFragment;
import com.qqq.recipemanager.model.Recipes;

public class MainActivity extends AppCompatActivity implements RecipeListFragment.OnRecipeSelectedInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        RecipeListFragment fragment = new RecipeListFragment();
        fragmentTransaction.add(R.id.placeHolder, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onListRecipeSelected(int index) {
        Toast.makeText(MainActivity.this, Recipes.names[index], Toast.LENGTH_LONG).show();
    }
}
