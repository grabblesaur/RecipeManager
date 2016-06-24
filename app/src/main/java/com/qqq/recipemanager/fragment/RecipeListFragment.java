package com.qqq.recipemanager.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qqq.recipemanager.R;
import com.qqq.recipemanager.adapter.RecipeAdapter;

public class RecipeListFragment extends Fragment{

    public interface OnRecipeSelectedInterface {
        void onListRecipeSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        OnRecipeSelectedInterface listener = (OnRecipeSelectedInterface) getActivity();

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRecyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        RecipeAdapter adapter = new RecipeAdapter(listener);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
