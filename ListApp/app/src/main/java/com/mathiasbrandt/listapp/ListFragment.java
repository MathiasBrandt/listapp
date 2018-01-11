package com.mathiasbrandt.listapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private ActivityCallback callback;

    public ListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_list, container, false);

        Button btn = layout.findViewById(R.id.list_button);
        btn.setOnClickListener(view -> callback.goToDetails());

        RecyclerView list = layout.findViewById(R.id.list_view);
        ArrayList<Tree> trees = new ArrayList<>();
        trees.add(new Tree(R.drawable.tree));
        trees.add(new Tree(R.drawable.tree2));
        trees.add(new Tree(R.drawable.tree3));
        trees.add(new Tree(R.drawable.tree4));
        trees.add(new Tree(R.drawable.tree5));
        TreeAdapter ta = new TreeAdapter(trees);
        list.setAdapter(ta);

        return layout;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (ActivityCallback) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }
}
