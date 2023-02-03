package jdbc.prepared_statement;

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

    public Child getChildByName(String name){

        ResultSet rs1 = null;
        try(Connection conn = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("namn"),
                p.getProperty("password"));
           PreparedStatement stmt1 = conn.prepareStatement("select * from barn where namn = ?");
            ){

            stmt1.setString(1,name);
            rs1 = stmt1.executeQuery();


            Child child = null;
            while(rs1.next()){
                child = new Child(rs1.getInt("id"), rs1.getString("namn"), rs1.getBoolean("snäll"));
            }
            return child;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
