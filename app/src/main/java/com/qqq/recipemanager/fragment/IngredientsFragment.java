package com.qqq.recipemanager.fragment;

import com.qqq.recipemanager.model.Recipes;

public class IngredientsFragment extends CheckBoxesFragment {

    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
