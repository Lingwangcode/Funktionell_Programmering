package jdbc.namnbytesprogram;

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

    public void changeNissesName(String nameBefore, String nameNow){
        int antalRowChanged = 0;
        try(Connection conn = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("namn"),
                p.getProperty("password"));
            PreparedStatement stmt = conn.prepareStatement("update tomtenissar set namn = ? where namn like ?");
            ){

            stmt.setString(1,nameNow);
            stmt.setString(2, nameBefore);

            antalRowChanged = stmt.executeUpdate();

            if (antalRowChanged == 0){
                System.out.println("Fel nisse name " + nameBefore);
            }
            else if(antalRowChanged > 1){
                System.out.println("OBS. namn på fler rader ändrades");
            }
            else{
                System.out.println("Name is now changed successfully");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
