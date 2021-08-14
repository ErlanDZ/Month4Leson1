package com.example.month4leson1.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.month4leson1.R;
import com.example.month4leson1.databinding.FragmentDetailBinding;
import com.example.month4leson1.databinding.FragmentHomeBinding;
import com.example.month4leson1.ui.VIewModel.BooksViewModel;
import com.example.month4leson1.ui.model.Books;


public class DetailFragment extends Fragment {
    FragmentDetailBinding binding;
    int  books;
    private BooksViewModel booksViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initialization();
        getDate();
        return root;
    }
    private void initialization() {
        booksViewModel = new ViewModelProvider(requireActivity()).get(BooksViewModel.class);
    }

    private void getDate() {
     booksViewModel.mutableLiveData.observe(getViewLifecycleOwner(), new Observer<Books>() {
         @Override
         public void onChanged(Books books) {
             binding.txtTitleDetail.setText(books.getTitle());
           binding.txtDescriptionDetail.setText(books.getDescription());
               binding.imageItemDetail.setImageResource(books.getImage());
         }
     });

//               binding.txtTitleDetail.setText(booksViewModel.getBooks(books).getTitle());
//               binding.txtDescriptionDetail.setText(booksViewModel.getBooks(books).getDescription());
//               binding.imageItemDetail.setImageResource(booksViewModel.getBooks(books).getImage());


    }
}