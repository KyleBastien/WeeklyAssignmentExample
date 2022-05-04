package com.example.ad340kylebastienweeklyassignments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MatchesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_matches, container, false);

        List<Matches> matchesList = new ArrayList<>();
        matchesList.add(new Matches("Mark T", "Really cool guy", false, "https://i.imgur.com/kobQVOD.jpg"));
        matchesList.add(new Matches("Michael J", "Super cool guy", true, "https://i.imgur.com/fF3Iiih.jpg"));
        matchesList.add(new Matches("Alex T", "Less cool guy", false, "https://i.imgur.com/z4OKVlA.jpg"));

        // Set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        MatchesRecyclerViewAdapter adapter = new MatchesRecyclerViewAdapter(matchesList);
        recyclerView.setAdapter(adapter);
        int largePadding = getResources().getDimensionPixelSize(R.dimen.grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.small_grid_spacing);
        recyclerView.addItemDecoration(new MatchesItemDecoration(largePadding, smallPadding));

        return view;
    }
}