package utils;

import java.util.ArrayList;

import models.Stock;

public class BinarySearch {
    public boolean hasStockPrice(ArrayList<Stock> stocks, double price) {
        int length = stocks.size() -1; 
        return hasValue(stocks, price, 0, length);
    }

    /// Stocks must be sorted.
    public boolean hasValue(ArrayList<Stock> stocks, double price, int start, int end){
        // exit loop and return false if we cross the end.
        if(start>end) return false;
        int position = (start + end) /2;
        Stock centerStock = stocks.get(position);
        
        if(centerStock.getPrice() == price) return true;
        else if(centerStock.getPrice() < price) return hasValue(stocks, price, position+1, end);
        else return hasValue(stocks, price, start, position-1);
    }
}
