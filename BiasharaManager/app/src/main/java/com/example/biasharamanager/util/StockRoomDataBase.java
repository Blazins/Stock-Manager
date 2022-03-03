package com.example.biasharamanager.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.biasharamanager.data.StockDao;
import com.example.biasharamanager.model.Product;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Product.class},version = 1,exportSchema = false)
@TypeConverters({Converter.class})
public abstract class StockRoomDataBase extends RoomDatabase {
    public static final int NUMBER_OF_THREADS = 4;
    public static final String DATABASE_NAME = "stock_database";
    private static volatile StockRoomDataBase INSTANCE;
    public static final ExecutorService databaseWriterExecutor
            = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static final RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    //allows us to do things in the background
                    databaseWriterExecutor.execute(()->{
                        StockDao stockDao = INSTANCE.stockDao();
                        stockDao.deleteAll(); //clean slate-fresh table

                        //writing to our table
                    });
                    //invoke DAO and write


                }
            };

    public static StockRoomDataBase getDatabase(final Context context){
        //make sure we go back to the background thread and that there are no issues
        if(INSTANCE == null){
            synchronized (StockRoomDataBase.class){
                if(INSTANCE == null){
                    //Making sure we only have one instance-
                    // of ROOM database created throughout the entire project
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            StockRoomDataBase.class,DATABASE_NAME)
                            .addCallback(sRoomDatabaseCallback)
                            //callback allows us to add things to it when we first create it
                            .build();
                }
            }
        }

        return INSTANCE;
    }
    public abstract StockDao stockDao();


}
