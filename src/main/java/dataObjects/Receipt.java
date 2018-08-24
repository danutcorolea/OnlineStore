package dataObjects;

import databaseManager.DBConnection;
import databaseManager.DBManager;

import java.sql.Connection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Receipt {

    private static  final AtomicInteger count = new AtomicInteger(0);
    private int idReceipt;
    private int idCustomer;
    private int idCart;
    double totalPayment;

    List<Purchase> purchases;


    public Receipt(){

    }

    public Receipt(int idReceipt,int idCart, List<Purchase> purchases, double totalPayment) {
        this.idReceipt = count.incrementAndGet();
        this.idCart = idCart;
        this.purchases = purchases;
        this.totalPayment = totalPayment;
    }

    public int getIdCart() {
        return idCart;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public int getIdReceipt() {
        return idReceipt;
    }



    public Receipt generateReceipt(int cartID)throws Exception {


        DBManager db1 = new DBManager();
        Connection connection1 = DBConnection.getConnection();
        purchases = db1.getPurchasesByCart(cartID,connection1);
        Payment payment = new Payment();
        totalPayment = payment.computeTotalAmmountOfPayments(db1.getPaymentByCart(cartID,connection1));

        Receipt receipt = new Receipt(idReceipt, cartID,purchases,totalPayment);

        return receipt;
    }



    @Override
    public String toString() {
        return "Receipt{" +
                "idCart=" + idCart +
                ", purchases=" + purchases +
                ", totalPayment=" + totalPayment +
                '}';
    }
}
