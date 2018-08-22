package dataObjects;

import databaseManager.DBConnection;
import databaseManager.DBManager;

import java.sql.Connection;
import java.util.List;

public class Receipt {

    private int idRecceipt;
    private int idCustomer;
    private int idCart;
    List<Purchase> purchases;
    double totalPayment;


    public Receipt(){};


    public Receipt(int idCart, List<Purchase> purchases, double totalPayment) {
        this.idCart = idCart;
        this.purchases = purchases;
        this.totalPayment = totalPayment;
    }

    public Receipt generateReceipt(int cartID)throws Exception {

        DBManager db1 = new DBManager();
        Connection connection1 = DBConnection.getConnection();
        purchases = db1.getPurchasesByCart(cartID,connection1);
        Payment payment = new Payment();
        totalPayment = payment.computeTotalAmmountOfPayments(db1.getPaymentByCart(cartID,connection1));

        Receipt receipt = new Receipt(cartID,purchases,totalPayment);

        return receipt;
    }

    @Override
    public String toString() {
        return "Receipt with " +
                "CartID" + idCart +
                ", contains " + purchases +
                ", having a total of" + totalPayment +
                '}';
    }
}
