package com.example.biasharamanager.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "stock_table")
public class Product {

    @ColumnInfo(name = "product_ID")
    @PrimaryKey(autoGenerate = true)
    public long productId;

    public String product;

    public int each_product_buying_price;

    public int each_product_selling_price;

    public int stock_quantity_added;

    public int stock_quantity_sold;

    @ColumnInfo(name = "Stock")
    public int stock_quantity = stock_quantity_sold - stock_quantity_added;

    //add query to sum up each product buying price
    @ColumnInfo(name = "Capital Invested Today")
    public int total_buying_price = each_product_buying_price * stock_quantity_added;

    @ColumnInfo(name = "Sales For The Day")
    public int total_selling_price = each_product_selling_price * stock_quantity_sold;

    @ColumnInfo(name = "Today's Profit")
    public int total_profit = total_selling_price - total_buying_price;

    @ColumnInfo(name = "date_bought")
    public Date purchase_Date;

    @ColumnInfo(name = "date_sold")
    public Date sell_date;

    public com.example.biasharamanager.model.Priority priority;

    public boolean isSold;

    public Product(String product, int each_product_buying_price, int each_product_selling_price, int stock_quantity_added, int stock_quantity_sold, int stock_quantity, int total_buying_price, int total_selling_price, int total_profit, Date purchase_Date, Date sell_date, com.example.biasharamanager.model.Priority priority, boolean isSold) {
        this.product = product;
        this.each_product_buying_price = each_product_buying_price;
        this.each_product_selling_price = each_product_selling_price;
        this.stock_quantity_added = stock_quantity_added;
        this.stock_quantity_sold = stock_quantity_sold;
        this.stock_quantity = stock_quantity;
        this.total_buying_price = total_buying_price;
        this.total_selling_price = total_selling_price;
        this.total_profit = total_profit;
        this.purchase_Date = purchase_Date;
        this.sell_date = sell_date;
        this.priority = priority;
        this.isSold = isSold;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getEach_product_buying_price() {
        return each_product_buying_price;
    }

    public void setEach_product_buying_price(int each_product_buying_price) {
        this.each_product_buying_price = each_product_buying_price;
    }

    public int getEach_product_selling_price() {
        return each_product_selling_price;
    }

    public void setEach_product_selling_price(int each_product_selling_price) {
        this.each_product_selling_price = each_product_selling_price;
    }

    public int getStock_quantity_added() {
        return stock_quantity_added;
    }

    public void setStock_quantity_added(int stock_quantity_added) {
        this.stock_quantity_added = stock_quantity_added;
    }

    public int getStock_quantity_sold() {
        return stock_quantity_sold;
    }

    public void setStock_quantity_sold(int stock_quantity_sold) {
        this.stock_quantity_sold = stock_quantity_sold;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public int getTotal_buying_price() {
        return total_buying_price;
    }

    public void setTotal_buying_price(int total_buying_price) {
        this.total_buying_price = total_buying_price;
    }

    public int getTotal_selling_price() {
        return total_selling_price;
    }

    public void setTotal_selling_price(int total_selling_price) {
        this.total_selling_price = total_selling_price;
    }

    public int getTotal_profit() {
        return total_profit;
    }

    public void setTotal_profit(int total_profit) {
        this.total_profit = total_profit;
    }

    public Date getPurchase_Date() {
        return purchase_Date;
    }

    public void setPurchase_Date(Date purchase_Date) {
        this.purchase_Date = purchase_Date;
    }

    public Date getSell_date() {
        return sell_date;
    }

    public void setSell_date(Date sell_date) {
        this.sell_date = sell_date;
    }

    public com.example.biasharamanager.model.Priority getPriority() {
        return priority;
    }

    public void setPriority(com.example.biasharamanager.model.Priority priority) {
        this.priority = priority;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", product='" + product + '\'' +
                ", each_product_buying_price=" + each_product_buying_price +
                ", each_product_selling_price=" + each_product_selling_price +
                ", stock_quantity_added=" + stock_quantity_added +
                ", stock_quantity_sold=" + stock_quantity_sold +
                ", stock_quantity=" + stock_quantity +
                ", total_buying_price=" + total_buying_price +
                ", total_selling_price=" + total_selling_price +
                ", total_profit=" + total_profit +
                ", purchase_Date=" + purchase_Date +
                ", sell_date=" + sell_date +
                ", priority=" + priority +
                ", isSold=" + isSold +
                '}';
    }
}

