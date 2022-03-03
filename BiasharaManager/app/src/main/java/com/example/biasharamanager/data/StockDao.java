package com.example.biasharamanager.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.biasharamanager.model.Product;

import java.util.List;
/*
Dao has the CRUD operations, interacts directly with SQLite
All encapsulated within the Room Database
 */

@Dao
public interface StockDao {
    //CRUD operations

    @Insert
    void insertProduct(Product product);

    @Query("DELETE FROM stock_table")
    void deleteAll();

    @Query("SELECT * FROM stock_table")
    LiveData<List<Product>> getProducts();

    @Query("SELECT * FROM stock_table WHERE stock_table.product_ID == :id")
    LiveData<Product> get(long id);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);
}
