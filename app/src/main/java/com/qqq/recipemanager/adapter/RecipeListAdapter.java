package com.qqq.recipemanager.adapter;

import com.qqq.recipemanager.R;
import com.qqq.recipemanager.fragment.RecipeListFragment;

public class RecipeListAdapter extends RecyclerAdapter{
    private final RecipeListFragment.OnRecipeSelectedInterface mListener;

    // simple constructor
    public RecipeListAdapter(RecipeListFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListener.onListRecipeSelected(index);
    }
}
