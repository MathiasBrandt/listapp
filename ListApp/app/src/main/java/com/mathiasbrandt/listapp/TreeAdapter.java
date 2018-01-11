package com.mathiasbrandt.listapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by brandt on 11/01/2018.
 */

public class TreeAdapter extends RecyclerView.Adapter<TreeAdapter.TreeHolder> {
    private ArrayList<Tree> trees;

    public TreeAdapter(ArrayList<Tree> trees) {
        this.trees = trees;
    }

    @Override
    public TreeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new TreeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TreeHolder holder, int position) {
        Tree tree = trees.get(position);
        holder.image.setImageResource(tree.getResId());
    }

    @Override
    public int getItemCount() {
        return trees.size();
    }

    class TreeHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public TreeHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.list_item_image);
        }
    }
}
