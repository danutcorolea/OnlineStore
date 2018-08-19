package dataObjects;

public class Customer {


    private  String name;
    private  String surname;
    private  String email;
    private  String country;
    private  String locality;
    private  String street;
    private  int streetNumber;
    private  int idCustomer;

    public  Customer(){

    }

    public Customer(int idCustomer, String name, String surname, String email, String country, String locality, String street, int streetNumber) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.country = country;
        this.locality = locality;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
