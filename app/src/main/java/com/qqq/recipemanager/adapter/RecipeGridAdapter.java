package com.qqq.recipemanager.adapter;

import com.qqq.recipemanager.R;
import com.qqq.recipemanager.fragment.RecipeGridFragment;

/**
 * Created by qqq on 28.06.2016.
 */
public class RecipeGridAdapter extends RecyclerAdapter {

    private final RecipeGridFragment.OnRecipeSelectedInterface mListener;

    // simple constructor
    public RecipeGridAdapter(RecipeGridFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListener.onGridRecipeSelected(index);
    }
}
