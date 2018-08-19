package objectProcessor;

import com.opencsv.CSVReader;
import dataObjects.Customer;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerProcessor {

    public List<Customer> parseCSVFileLineByLine() throws IOException {

        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\danut\\Desktop\\CSVfiles\\Carts.txt"), ',');

        List<Customer> customers = new ArrayList<>();
        String[] record = null;

        reader.readNext();

        while((record = reader.readNext())!= null){

            Customer customer = new Customer();
            customer.setIdCustomer(Integer.parseInt(record[0]));
            customer.setName(record[1]);
            customer.setSurname(record[2]);
            customer.setEmail(record[3]);
            customer.setCountry(record[4]);
            customer.setLocality(record[5]);
            customer.setStreet(record[6]);
            customer.setStreetNumber(Integer.parseInt(record[7]));
            customers.add(customer);
        }

        reader.close();

        return customers;
    }
}
