package objectProcessor;

import com.opencsv.CSVReader;
import dataObjects.Cart;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CartProcessor {



    public  List<Cart> parseCSVFileLineByLine() throws IOException {

        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\danut\\Desktop\\project\\CSVfiles\\Carts.txt"), ',');

        List<Cart> carts = new ArrayList<>();
        String[] record = null;

        reader.readNext();

        while((record = reader.readNext())!= null){

            Cart cart =new Cart();
            cart.setCartID(Integer.parseInt(record[0]));
            cart.setCustomerID(Integer.parseInt(record[1]));
            cart.setDate((record[2]));
            cart.setPurchaseID(Integer.parseInt(record[3]));
            cart.setCategory(record[4]);
            cart.setAmmount(Double.parseDouble(record[5]));

            carts.add(cart);

        }

        reader.close();
        System.out.println("Parsed " +carts.size() + "  cart objects");
        return carts;
    }


}
