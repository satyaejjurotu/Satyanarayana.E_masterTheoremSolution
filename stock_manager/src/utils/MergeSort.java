package utils;

import java.util.ArrayList;

import models.Stock;

public class MergeSort {
    // Merges two subarrays of stocks[].
    // First subarray is stocks[l..m]
    // Second subarray is stocks[m+1..r]
    public void merge(ArrayList<Stock> stocks, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        ArrayList<Stock> L = new ArrayList<Stock>(n1);
        ArrayList<Stock> R = new ArrayList<Stock>(n2);

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            L.add(i, stocks.get(l + i));
        for (int j = 0; j < n2; ++j)
            R.add(j, stocks.get(m + 1 + j));

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L.get(i).getPrice() <= R.get(j).getPrice()) {
                stocks.set(k, L.get(i));
                i++;
            } else {
                stocks.set(k, R.get(j));
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            stocks.set(k, L.get(i));
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            stocks.set(k, R.get(j));
            j++;
            k++;
        }
    }

    // Main function that sorts stocks[l..r] using
    // merge()
    public void sort(ArrayList<Stock> stocks, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(stocks, l, m);
            sort(stocks, m + 1, r);

            // Merge the sorted halves
            merge(stocks, l, m, r);
        }
    }
}
