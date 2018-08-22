package objectProcessor;

import com.opencsv.CSVReader;
import dataObjects.Payment;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PaymentProcessor {

    public List<Payment> parseCSVFileLineByLine() throws IOException {

        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\danut\\Desktop\\project\\CSVfiles\\Payments.txt"), ',');

        List<Payment> payments = new ArrayList<>();
        String[] record = null;

        reader.readNext();

        while((record = reader.readNext())!= null){

            Payment payment = new Payment();
            payment.setIdPayment(Integer.parseInt(record[0]));
            payment.setIdCart(Integer.parseInt(record[1]));
            payment.setIdCustomer(Integer.parseInt(record[2]));
            payment.setStatus(record[3]);
            payment.setType(record[4]);
            payment.setAmmount(Double.parseDouble(record[5]));
            payments.add(payment);

        }

        reader.close();
        System.out.println("Parsed " +payments.size() + " payment objects");
        return payments;
    }
}
