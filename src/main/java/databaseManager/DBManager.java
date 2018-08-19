package databaseManager;

import dataObjects.Cart;
import java.sql.*;
import java.util.List;


public class DBManager {

    private static String QUERY_INSERT_CARTS = "INSERT INTO CARTS (idCarts, idCustomer) values (?,?);";
    private static String QUERY_INSERT_NEW_CART = "INSERT INTO CARTS (idCarts, idCustomer) values (?,?);";



    public void loadCarts(List<Cart> carts, Connection connection)
    {

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_CARTS))
        {
            for (Cart c: carts)
            {
            preparedStatement.setInt(1, c.getCartID());
            preparedStatement.setInt(2, c.getCustomerID());
          //  preparedStatement.setDate(3,c.getDate());
            preparedStatement.execute();
            }


        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {

        }

    }

    public void insertNewCart(Cart c, Connection connection)
    {

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_NEW_CART)) {

            preparedStatement.setInt(1, c.getCartID());
            preparedStatement.setInt(2, c.getCustomerID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}