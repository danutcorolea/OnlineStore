import com.opencsv.CSVReader;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;


public class Test {

   public static void main(String[] args) throws Exception {
        DBManager db1 = new DBManager();
        CartProcessor cartProcessor = new CartProcessor();
         Connection connection1 = DBConnection.getConnection();
       // db1.loadCarts(   cartProcessor.parseCSVFileLineByLine(),connection1 );

        Cart cart = new Cart(100,100);
        db1.insertNewCart(cart,connection1);

   }


}


