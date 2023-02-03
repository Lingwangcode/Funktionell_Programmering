package Inlämning1_webbshop;

public class Product {

    private int id;
    private String code;
    private String size;
    private String color;
    private String brand;

    private int price;
    private int amount;

    public Product(int id, String code, String size, String color, String brand, int price, int amount) {
        this.id = id;
        this.code = code;
        this.size = size;
        this.color = color;
        this.brand = brand;
        this.price = price;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String kod) {
        this.code = code;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
