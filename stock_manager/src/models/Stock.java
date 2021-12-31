package models;

public class Stock {
    private double price;
    private boolean raisingState;

    // Rising State
    public boolean getRaisingState() {
        return raisingState;
    }

    public boolean setRaisingState(String value) {
        if (value.trim().equalsIgnoreCase("true") || value.trim().equalsIgnoreCase("false")) {
            raisingState = value.trim().equalsIgnoreCase("true");
            return true;
        } else {
            return false;
        }
    }

    // Price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Does the stock is in raising state.
    public boolean isStockInRaisingState() {
        return raisingState;
    }
}
