package com.example.month4leson1.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.month4leson1.R;
import com.example.month4leson1.databinding.FragmentHomeBinding;
import com.example.month4leson1.ui.BooksAdapter;
import com.example.month4leson1.ui.VIewModel.BooksViewModel;
import com.example.month4leson1.ui.interfae.OnClick;
import com.example.month4leson1.ui.model.Books;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private BooksViewModel booksViewModel;
    BooksAdapter adapter = new BooksAdapter();
    FragmentHomeBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.btnFill.setOnClickListener(v -> {
           binding.btnFill.setVisibility(View.GONE);
            booksViewModel.fetchData();
        });
        setupViews();
        initialization();
        setUpObservers();
        dertail();
        return root;
    }

    private void dertail() {
        adapter.setOnItemClickListener((position, model) -> {
           booksViewModel.getBooks(model);
            NavController navController = Navigation.findNavController(requireActivity(), R.id.fragment);
            navController.navigate(R.id.action_homeFragment_to_detailFragment);
        });
    }


    private void setupViews() {
        binding.recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewHome.setAdapter(adapter);
    }



    private void setUpObservers() {
        booksViewModel.dataBooks.observe(getViewLifecycleOwner(), books -> {
            binding.btnFill.setVisibility(View.GONE);
            adapter.addText(books);
        });
    }

    private void initialization() {
        booksViewModel = new ViewModelProvider(requireActivity()).get(BooksViewModel.class);
    }
}