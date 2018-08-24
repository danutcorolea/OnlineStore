package databaseManager;

import dataObjects.Cart;
import dataObjects.Customer;
import dataObjects.Payment;
import dataObjects.Purchase;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBManager {

    private static String QUERY_INSERT_CARTS = "INSERT INTO CARTS (idCart, idCustomer, date , idPurchase) values (?,?,?,?);";
    private static String QUERY_INSERT_CUSTOMERS = "INSERT INTO CUSTOMERS (Name, Surname, Email, Country, Locality, Number) values (?,?,?,?,?,?);";
    private static String QUERY_INSERT_PAYMENTS = "INSERT INTO PAYMENTS (idPayment, idCart, idCustomer, Status, Type, Ammount) values (?,?,?,?,?,?);";
    private static String QUERY_INSERT_PURCHASES = "INSERT INTO PURCHASES (idPurchase, idCustomer, idCart, Category , Ammount) values (?,?,?,?,?);";
    private static String QUERY_GET_PURCHASES = "Select Category, Ammount from purchases where purchases.idCart=?";
    private static String QUERY_GET_PAYMENTS = "Select Type, Ammount from payments where payments.idCart=?";
    private static String QUERY_GET_PAYMENTS_BY_DATE ="SELECT Ammount from payments, carts where payments.idCart = carts.idCart and carts.Date=?";
    private static String QUERY_INSERT_PDF = "INSERT INTO PDFSTORAGE(idReceipt, pdf) values (?,?)";


    public void loadCarts(List<Cart> carts, Connection connection) throws SQLException {

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_PURCHASES)) {

            for (Cart c : carts) {
                preparedStatement.setInt(1, c.getPurchaseID());
                preparedStatement.setInt(2, c.getCustomerID());
                preparedStatement.setInt(3, c.getCartID());
                preparedStatement.setString(4, c.getCategory());
                preparedStatement.setDouble(5, c.getAmmount());
                preparedStatement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_CARTS)) {

            for (Cart c : carts) {
                preparedStatement.setInt(1, c.getCartID());
                preparedStatement.setInt(2, c.getCustomerID());
                preparedStatement.setString(3, c.getDate());
                preparedStatement.setInt(4, c.getPurchaseID());
                preparedStatement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void loadCustomers(List<Customer> customers, Connection connection) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_CUSTOMERS)) {
            for (Customer cs : customers) {
                preparedStatement.setString(1, cs.getName());
                preparedStatement.setString(2, cs.getSurname());
                preparedStatement.setString(3, cs.getEmail());
                preparedStatement.setString(4, cs.getCountry());
                preparedStatement.setString(5, cs.getLocality());
                preparedStatement.setInt(6, cs.getStreetNumber());
                preparedStatement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void loadPayments(List<Payment> payments, Connection connection) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_PAYMENTS)) {
            for (Payment p : payments) {
                preparedStatement.setInt(1, p.getIdPayment());
                preparedStatement.setInt(2, p.getIdCart());
                preparedStatement.setInt(3, p.getIdCustomer());
                preparedStatement.setString(4, p.getStatus());
                preparedStatement.setString(5, p.getType());
                preparedStatement.setDouble(6, p.getAmmount());
                preparedStatement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void loadPDF(int idCart, String root , Connection connection) throws Exception
    {
        File pdfFile = new File(root);
        byte[] pdfData = new byte[(int) pdfFile.length()];
        DataInputStream dis = new DataInputStream(new FileInputStream(pdfFile));
        dis.readFully(pdfData);
        dis.close();

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_PDF)){
        preparedStatement.setInt(1,idCart);
        preparedStatement.setBytes(2,pdfData);
        preparedStatement.executeUpdate();

        }
        catch (SQLException e){}



    }

    public List<Purchase> getPurchasesByCart(int idCart, Connection connection) throws SQLException {
        List<Purchase> purchases = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_PURCHASES)) {

            preparedStatement.setInt(1, idCart);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                String category = resultSet.getString("Category");
                double ammount = resultSet.getDouble("Ammount");
                purchases.add(new Purchase(category, ammount));
            }


        }

        return purchases;
    }

    public List<Payment> getPaymentByCart(int idCart, Connection connection) throws SQLException {
        List<Payment> payments = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_PAYMENTS)) {

            preparedStatement.setInt(1, idCart);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                String type = resultSet.getString("Type");
                double ammount = resultSet.getDouble("Ammount");
                payments.add(new Payment(type, ammount));
            }


        }

        return payments;
    }

    public double getTotalPaymentsByDate(String date, Connection connection)throws  SQLException
    {

        List<Double> lisOfAmmounts = new ArrayList<Double>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_PAYMENTS_BY_DATE)) {

            preparedStatement.setString(1, date);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                double ammount = resultSet.getDouble("Ammount");
                lisOfAmmounts.add(ammount);

            }
            double totalAmmount = 0;
            for (double ammount: lisOfAmmounts) {
                totalAmmount = totalAmmount + ammount;
            }

        return totalAmmount;

        }

    }



    }
