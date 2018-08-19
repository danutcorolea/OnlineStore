package dataObjects;

public class Payment {

    private int idPayment;
    private int idCart;
    private int idCustomer;
    private String Status;
    private String Type;
    private double ammount;

    public Payment(){}

    public Payment(int idPayment, int idCart, int idCustomer, String status, String type, double ammount) {
        this.idPayment = idPayment;
        this.idCart = idCart;
        this.idCustomer = idCustomer;
        Status = status;
        Type = type;
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
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }
}
