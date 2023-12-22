package ShoppingApp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    public Connection connection;

// Creating the function which can be called within the package
   public Connection getConnection(){
       String dbName="vegigo";
       String username="root";
       String password="Password";
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,username,password);// entering the username and password that i have set in installing part of SQL
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return connection;
   }
}
