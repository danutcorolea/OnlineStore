package dataObjects;

public class Adress {

    private int idAdress;
    private int idCustomer;
    private String country;
    private String locality;
    private String street;
    private int streetNumber;


    public Adress(int idAdress, int idCustomer, String country, String locality, String street, int streetNumber) {
        this.idAdress = idAdress;
        this.idCustomer = idCustomer;
        this.country = country;
        this.locality = locality;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    public int getIdAdress() {
        return idAdress;
    }

    public void setIdAdress(int idAdress) {
        this.idAdress = idAdress;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "idAdress=" + idAdress +
                ", idCustomer=" + idCustomer +
                ", country='" + country + '\'' +
                ", locality='" + locality + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                '}';
    }
}
