package com.example.biasharamanager.model;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.biasharamanager.data.StockRepository;

import java.util.List;

public class StockViewModel extends AndroidViewModel {

    public static com.example.biasharamanager.data.StockRepository repository;
    public final LiveData<List<com.example.biasharamanager.model.Product>> allProducts;

    public StockViewModel(@NonNull Application application) {
        super(application);
        repository = new com.example.biasharamanager.data.StockRepository(application);
        allProducts = repository.getAllProducts();
    }

    public LiveData<List<com.example.biasharamanager.model.Product>> getAllProducts(){
        return allProducts;
    }
    public static void insert(com.example.biasharamanager.model.Product product){
        repository.insert(product);
    }
    public LiveData<com.example.biasharamanager.model.Product> get(long id){
        return repository.get(id);
    }
    public static void update(com.example.biasharamanager.model.Product product){
        repository.update(product);
    }
    public static void delete(com.example.biasharamanager.model.Product product){
        repository.delete(product);
    }




}

