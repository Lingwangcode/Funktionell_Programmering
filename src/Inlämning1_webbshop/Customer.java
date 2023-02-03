package Inlämning1_webbshop;

public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String socialSecurityNr;
    private String address;
    private String county;
    private String passWord;

    public Customer(int id, String firstName, String lastName, String socialSecurityNr, String address, String county, String passWord) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNr = socialSecurityNr;
        this.address = address;
        this.county = county;
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNr() {
        return socialSecurityNr;
    }

    public void setSocialSecurityNr(String socialSecurityNr) {
        this.socialSecurityNr = socialSecurityNr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void printOut(){
        System.out.println("Hej " + this.firstName + "! You can now start to search in our shoe store:\n" +
                "Press 1 for color\nPress 2 for brand\nPress 3 for size");
    }
}
