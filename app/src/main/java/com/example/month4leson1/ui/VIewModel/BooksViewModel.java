package com.example.month4leson1.ui.VIewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.month4leson1.ui.data.Data;
import com.example.month4leson1.ui.model.Books;

import java.util.List;

public class BooksViewModel extends ViewModel {
    private final Data data = new Data ();
    public MutableLiveData<List<Books>> dataBooks = new MutableLiveData<>();
    public MutableLiveData<Books> mutableLiveData = new MutableLiveData<>();

    public void fetchData(){
        dataBooks.setValue(data.getData());
    }
    public void getBooks (Books mod ){
        mutableLiveData.setValue(mod);
    }
}
