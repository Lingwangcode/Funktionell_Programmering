package jdbc.cosole_daskboard_tomten;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Uppkoppling implements RepositoryInterface{
    private Properties properties = new Properties();
    public Uppkoppling() {

        try{
            properties.load(new FileInputStream("src/jdbc/cosole_daskboard_tomten/settings.properties"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Nisse> getAllNisse() {
        List<Nisse> allNisse = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(properties.getProperty("connectionString"),
                properties.getProperty("namn"), properties.getProperty("password"));
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tomtenissar")) {

            while(rs.next()){

                int id = rs.getInt("id");
                String namn = rs.getString("namn");
                allNisse.add(new Nisse(id, namn));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allNisse;
    }

    public int countRows(String tabellnamn){
        int count = -1;
        try (Connection conn = DriverManager.getConnection(properties.getProperty("connectionString"),
                properties.getProperty("namn"), properties.getProperty("password"));
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select count(*) as antal from " + tabellnamn)) {

            while(rs.next()){
                count = rs.getInt("antal");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public int getAntalBarn(){
        return countRows("barn");
    }

    public double getGodhetAvg(){
        double barnGodhetAvg = 0;
        try (Connection conn = DriverManager.getConnection(properties.getProperty("connectionString"),
                properties.getProperty("namn"), properties.getProperty("password"));
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select avg (godhetnummer) as avg from rapport"))
        {
            while(rs.next()){
                barnGodhetAvg = rs.getInt("avg");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return barnGodhetAvg;

}
}
