package com.qqq.recipemanager.fragment;

import com.qqq.recipemanager.model.Recipes;

/**
 * Created by qqq on 28.06.2016.
 */
public class DirectionsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.directions[index].split("`");
    }
}
