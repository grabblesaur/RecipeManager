package com.qqq.recipemanager.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.qqq.recipemanager.R;
import com.qqq.recipemanager.fragment.RecipeListFragment;
import com.qqq.recipemanager.fragment.ViewPagerFragment;

public class MainActivity extends AppCompatActivity implements RecipeListFragment.OnRecipeSelectedInterface {
    public static final String RECIPE_LIST_FRAGMENT = "recipe list fragment";
    public static final String VIEWPAGER_FRAGMENT = "viewpager fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // sets RecipeListFragment in FrameLayout
        RecipeListFragment savedFragment = (RecipeListFragment) getSupportFragmentManager()
                .findFragmentByTag(RECIPE_LIST_FRAGMENT);
        if (savedFragment == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            RecipeListFragment fragment = new RecipeListFragment();
            fragmentTransaction.add(R.id.placeHolder, fragment, RECIPE_LIST_FRAGMENT);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onListRecipeSelected(int index) {

        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
