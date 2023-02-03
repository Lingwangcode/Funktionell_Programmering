package Inlämning1_webbshop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Repository implements RepositoryInterface{

    private Properties p = new Properties();
    public Repository() {

        try{
            p.load(new FileInputStream("src/Inlämning1_webbshop/settings.properties"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Customer getCustomer (String name, String password){
        ResultSet rs = null;
        Customer customer = null;
        try (Connection conn = DriverManager.getConnection(p.getProperty("connectionString"),
                    p.getProperty("namn"),
                    p.getProperty("password"));
                 PreparedStatement stmt = conn.prepareStatement("select * from kund where förnamn = ? && lösenord = ?");
            ) {

                stmt.setString(1, name);
                stmt.setString(2, password);
                rs = stmt.executeQuery();


                while (rs.next()) {
                    customer = new Customer(rs.getInt("id"), rs.getString("förnamn"),
                    rs.getString("efternamn"), rs.getString("personnummer"), rs.getString("adress"),
                    rs.getString("ort"), rs.getString("lösenord"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public List<Product> getAllProductToList () {
        List<Product> product = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("namn"), p.getProperty("password"));
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select produkt.id as id, produkt.kod as kod, produkt.pris as pris, färg.namn as färg, \n" +
                         "märke.namn as märke, storlek.EU_storlek as storlek, produkt.antal from produkt\n" +
                         "inner join färg on produkt. färgid = färg.id\n" +
                         "inner join märke on produkt. märkeid = märke.id\n" +
                         "inner join storlek on produkt.storlekId = storlek.id\n order by id ")) {
             Product p = null;

             while (rs.next()) {
                 p = new Product(rs.getInt("id"), rs.getString("kod"),
                         rs.getString("storlek"), rs.getString("färg"),
                         rs.getString("märke"), rs.getInt("pris"), rs.getInt("antal"));

                    product.add(p);
                }

                return product;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        public void printOutAllColorOrBrandOrSize(String searchNr) {
        switch (searchNr){
            case "1" -> {getAllColor(); System.out.println("Enter the color you want: ");}
            case "2" -> {getAllBrand(); System.out.println("Enter the brand you want: ");}
            case "3" -> {getAllSize(); System.out.println("Enter the size you want: ");}

        }
    }

    public void getProductsByColor(String input){

        getAllProductToList().stream().filter(p -> p.getColor().equalsIgnoreCase(input)).
                forEach(p -> System.out.println(p.getId() + ". BRAND: " + p.getBrand() + "\tCOLOR: " + p.getColor()
                        + "\tSIZE: " + p.getSize() + "\tPRICE: " + p.getPrice()));

    }

    public void printOutProduktByInput(String searchNr, String input){
        switch (searchNr){
            case "1" -> getProductsByColor(input);
            case "2" -> getProductsByBrand(input);
            case "3" -> getProductsBySize(input);

        }
    }

    public void getProductsBySize(String input){

        getAllProductToList().stream().filter(p -> p.getSize().equalsIgnoreCase(input)).
                forEach(p -> System.out.println(p.getId() + ". BRAND: " + p.getBrand() + "\tCOLOR: " + p.getColor()
                        + "\tSIZE: " + p.getSize() + "\tPRICE: " + p.getPrice()));

    }

    public void getProductsByBrand(String input){
        getAllProductToList().stream().filter(p->p.getBrand().equalsIgnoreCase(input)).
                forEach(p-> System.out.println(p.getId() + ". BRAND: " + p.getBrand() + "\tCOLOR: " + p.getColor()
                        + "\tSIZE: " + p.getSize() + "\tPRICE: " + p.getPrice()));
    }

    public List<Size> getAllSize (){
        List <Size> category = new ArrayList<>();
        Size s = null;
        try (Connection conn = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("namn"),
                p.getProperty("password"));
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from storlek");
        ) {

            while (rs.next()) {
                s = new Size(rs.getInt("id"), rs.getString("EU_storlek"));
                category.add(s);
            }


            category.forEach(ca -> System.out.println(ca.getSize()));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    public List<Color> getAllColor (){
        List <Color> color = new ArrayList<>();
        Color c = null;
        try (Connection conn = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("namn"),
                p.getProperty("password"));
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from Färg");
        ) {

            while (rs.next()) {
                c= new Color(rs.getInt("id"), rs.getString("namn"));
                color.add(c);
            }


            color.forEach(ca -> System.out.println(ca.getName()));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return color;
    }


    public List<Brand> getAllBrand (){
        List <Brand> brand = new ArrayList<>();
        Brand b = null;
        try (Connection conn = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("namn"),
                p.getProperty("password"));
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from märke");
        ) {

            while (rs.next()) {
                b= new Brand(rs.getInt("id"), rs.getString("namn"));
                brand.add(b);
            }


            brand.forEach(br -> System.out.println(br.getName()));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brand;
    }

    public void addToCart(String customerName, String passWord, String productNr ){

            int productId = Integer.parseInt(productNr);
            int customerId = getCustomer(customerName,passWord).getId();
            try(Connection conn = DriverManager.getConnection(p.getProperty("connectionString"),
                    p.getProperty("namn"),
                    p.getProperty("password"));
                CallableStatement stmt = conn.prepareCall("call addToCart(?,?,?)");
            ){

                stmt.setInt(1,productId);
                stmt.setInt(2,Integer.MAX_VALUE);
                stmt.setInt(3,customerId);
                stmt.execute();
                System.out.println("A new order has been added");

            } catch (SQLException e) {
                System.out.println("Something went wrong. Order failed.");
                System.out.println(e.getMessage());
            }

    }



}
