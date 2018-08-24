package dataObjects;

import databaseManager.DBConnection;
import databaseManager.DBManager;
import objectProcessor.CartProcessor;
import objectProcessor.CustomerProcessor;
import objectProcessor.PaymentProcessor;
import objectProcessor.ReceiptWriter;

import java.sql.Connection;

public class Store{

    public void loadStore()throws Exception{

        DBManager db = new DBManager();
        CustomerProcessor customerProcessor = new CustomerProcessor();
        CartProcessor cartProcessor = new CartProcessor();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        Connection connection = DBConnection.getConnection();

        db.loadCustomers(customerProcessor.parseCSVFileLineByLine(),connection);
        db.loadCarts(cartProcessor.parseCSVFileLineByLine(),connection);
        db.loadPayments(paymentProcessor.parseCSVFileLineByLine(),connection);
    }

    public String createReceipt(int idCart)throws Exception{


        ReceiptWriter receiptWriter = new ReceiptWriter();
        Receipt receipt = new Receipt();
        receipt = receipt.generateReceipt(idCart);


        return receiptWriter.createReceiptPDF(receipt);
    }

    public void computeTotalSalesOfDay (String date) throws Exception
    {
        DBManager db = new DBManager();
        Connection connection = DBConnection.getConnection();

        db.getTotalPaymentsByDate(date, connection);

    }

    public void loadReciptToDB(int idCart, String root)throws Exception
    {


        DBManager db = new DBManager();
        Connection connection = DBConnection.getConnection();
        db.loadPDF(idCart,root, connection);


    }
}
