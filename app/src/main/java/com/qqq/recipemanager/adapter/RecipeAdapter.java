package com.qqq.recipemanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qqq.recipemanager.R;
import com.qqq.recipemanager.fragment.RecipeListFragment;
import com.qqq.recipemanager.model.Recipes;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ListViewHolder>{
    private final RecipeListFragment.OnRecipeSelectedInterface mListener;

    public RecipeAdapter(RecipeListFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView mImageView;
        private TextView mTextView;
        private int mIndex;

        public ListViewHolder(View itemView) {
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.iv_item);
            mTextView = (TextView) itemView.findViewById(R.id.tv_text);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position) {
            mTextView.setText(Recipes.names[position]);
            mImageView.setImageResource(Recipes.resourceIds[position]);
            mIndex = position;
        }

        @Override
        public void onClick(View view) {
            mListener.onListRecipeSelected(mIndex);
        }
    }
}
