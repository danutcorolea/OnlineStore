package dataObjects;
import java.sql.Date;


public class Cart {

    private int cartID;
    private int customerID;
    private String category;
    private double ammount;
    Date date;



    public Cart(int cartID, int customerID, Date date, String category, double ammount) {
        this.cartID = cartID;
        this.customerID = customerID;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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
