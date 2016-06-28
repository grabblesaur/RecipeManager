package com.qqq.recipemanager.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qqq.recipemanager.R;
import com.qqq.recipemanager.adapter.RecipeGridAdapter;

public class RecipeGridFragment extends Fragment {

    public interface OnRecipeSelectedInterface {
        void onGridRecipeSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        OnRecipeSelectedInterface listener = (OnRecipeSelectedInterface) getActivity();

        // inflates our fragment view, which represents a LinearLayout with alone RecyclerView in it
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        // identify recyclerView
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        // sets the GridLayoutManager
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int numColumns = (int) (dpWidth/ 200);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), numColumns);
        recyclerView.setLayoutManager(layoutManager);

        // sets the adapter
        RecipeGridAdapter adapter = new RecipeGridAdapter(listener);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
