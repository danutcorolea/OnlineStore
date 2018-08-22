package dataObjects;

import java.util.List;

public class Payment {

    private int idPayment;
    private int idCart;
    private int idCustomer;
    private String Status;
    private String type;
    private double ammount;

    public Payment(){}

    public Payment(String type, double ammount) {
        this.type = type;
        this.ammount = ammount;
    }

    public Payment(int idPayment, int idCart, int idCustomer, String status, String type, double ammount) {
        this.idPayment = idPayment;
        this.idCart = idCart;
        this.idCustomer = idCustomer;
        Status = status;
        this.type = type;
        this.ammount = ammount;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = type;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "type='" + type + '\'' +
                ", ammount=" + ammount +
                '}';
    }

    public double computeTotalAmmountOfPayments (List<Payment> payments){
        double result = 0;
        for (Payment p: payments) {
            result = result + p.ammount;
        }

        return  result;
    }
}
