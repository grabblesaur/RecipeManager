package com.qqq.recipemanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qqq.recipemanager.R;
import com.qqq.recipemanager.adapter.RecipeListAdapter;

public class RecipeListFragment extends Fragment {

    private OnRecipeSelectedInterface mListener;

    public interface OnRecipeSelectedInterface {
        void onListRecipeSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mListener = (OnRecipeSelectedInterface) getActivity();

        // inflates our fragment view, which represents a LinearLayout with alone RecyclerView in it
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        // identify recyclerView
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        // sets the LinearLayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // sets the adapter
        RecipeListAdapter adapter = new RecipeListAdapter(mListener);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
