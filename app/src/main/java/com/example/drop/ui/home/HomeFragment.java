package com.example.drop.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drop.Cards;
import com.example.drop.CardsAdapter;
import com.example.drop.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    RecyclerView recyclerView;
    CardsAdapter cardsAdapter;

    List<Cards> cardsList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        cardsList = new ArrayList<>();

        recyclerView = root.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));

        cardsList.add(new Cards("12345","12345",R.drawable.drop, "90"));
        cardsList.add(new Cards("12345","12345",R.drawable.drop, "90"));
        cardsList.add(new Cards("12345","12345",R.drawable.drop, "90"));
        cardsList.add(new Cards("12345","12345",R.drawable.drop, "90"));
        cardsList.add(new Cards("12345","12345",R.drawable.drop, "90"));
        cardsList.add(new Cards("12345","12345",R.drawable.drop, "90"));
        cardsList.add(new Cards("12345","12345",R.drawable.drop, "90"));
        cardsList.add(new Cards("12345","12345",R.drawable.drop, "90"));

        cardsAdapter = new CardsAdapter(root.getContext(), cardsList);
        recyclerView.setAdapter(cardsAdapter);



        return root;
    }
}