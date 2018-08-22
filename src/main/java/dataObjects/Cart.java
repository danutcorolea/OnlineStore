package dataObjects;
import java.sql.Date;
import java.time.LocalDate;


public class Cart {

    private int cartID;
    private int customerID;
    private int purchaseID;
    private String category;
    private double ammount;
    private String date;



    public Cart(int cartID, int customerID, String date, int purchaseID, String category, double ammount) {
        this.cartID = cartID;
        this.customerID = customerID;
        this.purchaseID = purchaseID;
        this.date = date;
        this.category = category;
        this.ammount = ammount;
    }

    public Cart() {

    }

    public int getCartID() {
        return cartID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(int purchaseID) {
        this.purchaseID = purchaseID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartID=" + cartID +
                ", customerID=" + customerID +
                ", category='" + category + '\'' +
                ", ammount=" + ammount +
                ", date=" + date +
                '}';
    }
}
