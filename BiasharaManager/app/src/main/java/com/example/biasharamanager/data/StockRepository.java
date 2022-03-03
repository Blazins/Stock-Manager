package com.example.biasharamanager.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.biasharamanager.model.Product;
import com.example.biasharamanager.util.StockRoomDataBase;

import java.util.List;

/*Not part of Room Database
collect data from all sources
For code organization
 */
public class StockRepository {
    private final com.example.biasharamanager.data.StockDao stockDao;
    private final LiveData<List<Product>> allProducts;

    public StockRepository(Application application) {
        StockRoomDataBase stockRoomDataBase = StockRoomDataBase.getDatabase(application);
        stockDao = stockRoomDataBase.stockDao();
        allProducts = stockDao.getProducts();
    }

    public LiveData<List<Product>> getAllProducts(){
        return allProducts;
    }

    public void insert(Product product){
        //Insertion in the background thread
        StockRoomDataBase.databaseWriterExecutor.execute(()->{
            stockDao.insertProduct(product);
        });
    }

    public LiveData<Product> get(long id){
        return stockDao.get(id);
    }
    public void update(Product product){
        StockRoomDataBase.databaseWriterExecutor.execute(()
                ->stockDao.update(product));
    }
    public void delete(Product product){
        StockRoomDataBase.databaseWriterExecutor.execute(()
        ->stockDao.delete(product));
    }




}
