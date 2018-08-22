package dataObjects;

public class Purchase {

    private int idPurchase;
    private String category;
    private double ammount;

    public Purchase(String category, double ammount) {
        this.category = category;
        this.ammount = ammount;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "category='" + category + '\'' +
                ", ammount=" + ammount +
                '}';
    }
}
