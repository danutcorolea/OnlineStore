package objectProcessor;

import com.opencsv.CSVReader;
import dataObjects.Cart;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartProcessor {

    List<Cart> carts;

    {
        try {
            carts = parseCSVFileLineByLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  List<Cart> parseCSVFileLineByLine() throws IOException {

        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\danut\\Desktop\\CSVfiles\\Carts.txt"), ',');

        List<Cart> carts = new ArrayList<>();
        String[] record = null;

        reader.readNext();

        while((record = reader.readNext())!= null){

            Cart cart =new Cart();
            cart.setCartID(Integer.parseInt(record[0]));
            cart.setCustomerID(Integer.parseInt(record[1]));
          //  cart.setDate(Date.valueOf(record[2]));

            carts.add(cart);
        }

        reader.close();

        return carts;
    }


}
