import java.sql.Date;


public class Cart {

    private int cartID;
    private int customerID;
    Date date;



    public Cart(int cartID, int customerID) {
        this.cartID = cartID;
        this.customerID = customerID;
        this.date = date;
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






    @Override
    public String toString() {
        return "Cart{" +
                "cartID = " + cartID + ", customerID = " + customerID + ", date = '" + date + '\'' + '}';
    }
}
