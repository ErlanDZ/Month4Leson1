package com.example.month4leson1.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.month4leson1.R;
import com.example.month4leson1.databinding.ItemTaskBinding;
import com.example.month4leson1.ui.interfae.OnClick;
import com.example.month4leson1.ui.model.Books;

import java.util.ArrayList;
import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {
    ItemTaskBinding binding;
    List<Books> list = new ArrayList<>();
    private OnClick onItemClickListener;
    @NonNull
    @Override
    public BooksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.getContext()), parent ,false);
        return new ViewHolder(binding.getRoot());
    }
    public void addText ( List<Books> moviesList){
        this.list = moviesList;
        notifyDataSetChanged();
    }
    public void setOnItemClickListener (OnClick onClick){
        this.onItemClickListener = onClick;
    }


    @Override
    public void onBindViewHolder(@NonNull  BooksAdapter.ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bind(Books books) {
            binding.txtTitle.setText(books.getTitle());
            binding.imageItem.setImageResource(books.getImage());

            itemView.setOnClickListener(v -> {
               onItemClickListener.itemClick(getAdapterPosition(), books);
            });
        }
    }
}
