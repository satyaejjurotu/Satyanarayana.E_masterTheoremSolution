import java.util.ArrayList;
import java.util.Scanner;

import models.Stock;
import models.StockHandler;

public class App {
    static StockHandler stockHandler;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        getStockDetailsFromUser(scanner);
        boolean isExitOption = false;
        do {
            printOperationMessages();
            isExitOption = doOperations(scanner, scanner.nextInt());
        } while (!isExitOption);
    }

    private static void getStockDetailsFromUser(Scanner sc) {
        System.out.println("Enter the no of companies :");
        int totalCompanies = sc.nextInt();
        ArrayList<Stock> theStocks = new ArrayList<Stock>();
        stockHandler = new StockHandler();
        for (int i = 1; i <= totalCompanies; i++) {
            Stock stock = new Stock();
            System.out.println("Enter current stock price of the company " + i + " :");
            double stockPrice = sc.nextDouble();
            stock.setPrice(stockPrice);

            boolean isValidString = true;
            do {
                System.out.println("Whether company's stock price rose today compare to yesterday? ");
                String risingState = sc.next();
                isValidString = stock.setRaisingState(risingState);
                if (!isValidString) {
                    System.out.println("Invalid String. Enter only \"true\" or \"false\".");
                } else {
                    theStocks.add(stock);
                    if (stockHandler.isRaisingStock(stock))
                        stockHandler.increaseRaisingStockCount();
                }
            } while (!isValidString);
        }
        stockHandler.setStocks(theStocks);
        stockHandler.mergeSort();
    }

    private static boolean doOperations(Scanner sc, int ch) {
        switch (ch) {
            case 1:
                System.out.println("Stock prices in ascending order are :");
                stockHandler.displayStockPricesInAscendingOrder();
                break;
            case 2:
                System.out.println("Stock prices in descending order are :");
                stockHandler.displayStockPricesInDescendingOrder();
                break;
            case 3:
                System.out.println("Total no of companies whose stock price rose today :"
                        + stockHandler.getIncreasingStockCount());
                break;
            case 4:
                System.out.println("Total no of companies whose stock price declined today :"
                        + stockHandler.getDecreasingStockCount());
                break;
            case 5:
                System.out.println("Enter the key value :");
                double value = sc.nextDouble();
                if (stockHandler.isStockPriceAvailable(value))
                    System.out.println("Stock of value " + value + " is present");
                else
                    System.out.println("Value not found");
                break;
            case 0:
                System.out.println("Exited Successfully");
                return true;
            default:
                System.out.println("Invalid Input. Enter only from 0 to 5.");
                return false;
        }

        return false;
    }

    private static void printOperationMessages() {
        System.out.println(
                "\n\n--------------------------------------------\r\n" +
                        "Enter the operation that you want to perform\r\n" +
                        "1. Display the companies stock prices in ascending order\r\n" +
                        "2. Display the companies stock prices in descending order\r\n" +
                        "3. Display the total no of companies for which stock prices rose today\r\n" +
                        "4. Display the total no of companies for which stock prices declined today\r\n" +
                        "5. Search a specific stock price\r\n" +
                        "0. press 0 to exit");
    }
}
