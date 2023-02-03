package jdbc.läggaPresentSP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Uppkoppling {

    Properties p = new Properties();

    public Uppkoppling(){
        try{
            p.load(new FileInputStream("src/jdbc/cosole_daskboard_tomten/settings.properties"));

        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPresentByName(String name){
        int antalRowChanged = 0;
        try(Connection conn = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("namn"),
                p.getProperty("password"));
            CallableStatement stmt = conn.prepareCall("call addPresent(?)");
            ){

            stmt.setString(1,name);


            antalRowChanged = stmt.executeUpdate();

            if (antalRowChanged == 0){
                System.out.println("Inga presenter lades till ");
            }
            else if(antalRowChanged > 1){
                System.out.println("Presenten lades till flera gånger");
            }
            else{
                System.out.println("Det gick bra att lägga till en present");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
