package models;

import java.util.ArrayList;

import utils.BinarySearch;
import utils.MergeSort;

public class StockHandler {
    private int raisingStockCount = 0;
    private ArrayList<Stock> stocks = new ArrayList<Stock>();

    // Stocks
    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }

    public boolean isRaisingStock(Stock stock) {
        return stock.getRaisingState();
    }

    // Stock counts
    public void increaseRaisingStockCount() {
        raisingStockCount++;
    }

    public int getIncreasingStockCount() {
        return this.raisingStockCount;
    }

    public int getDecreasingStockCount() {
        return this.stocks.size() - raisingStockCount;
    }

    // search stock
    public boolean isStockPriceAvailable(double price) {
        BinarySearch binarySearch = new BinarySearch();
        return binarySearch.hasStockPrice(stocks, price);
    }

    public void mergeSort() {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(stocks, 0, stocks.size() - 1);
    }

    public void displayStockPricesInAscendingOrder() {
        for (int i = 0; i < stocks.size(); i++) {
            System.out.print(stocks.get(i).getPrice() + " ");
        }
        System.out.println();
    }

    public void displayStockPricesInDescendingOrder() {
        for (int i = stocks.size() - 1; i >= 0; i--) {
            System.out.print(stocks.get(i).getPrice() + " ");
        }
        System.out.println();
    }

}
