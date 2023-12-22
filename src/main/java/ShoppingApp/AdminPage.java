package ShoppingApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminPage {

    //Declaring  ID's
    @FXML
    TextField UserName;
    @FXML
    PasswordField Password;
    @FXML
    Label message2;

    public Stage stage;
    public Scene scene;
    public Parent root;

    //                        ADMIN PAGE

//Condition to not being fields empty

    public void AdminLogin(ActionEvent event) throws SQLException {
 if ( UserName.getText().equals("")|| Password.getText().equals("")){
     message2.setText("Please enter UserName and Password");
 }
 else{
     // Connection to DB TO verify the Admin userName and Password!!!
     try {

         DataBaseConnection Connect=new DataBaseConnection();
         Connection connection= Connect.getConnection();
         PreparedStatement statement=connection.prepareStatement("SELECT * FROM adminlogin WHERE Username = ? AND Password = ? ;");// Prepared statement in DB
         statement.setString(1,UserName.getText());
         statement.setString(2,Password.getText());
         ResultSet result=statement.executeQuery();
         if (result.next()){
             String username= UserName.getText();
             FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminSignin.fxml"));
             root=loader.load();
             Admin_SigninInfo admin_signinInfo=loader.getController();
             admin_signinInfo.go(username);
//             root=FXMLLoader.load(getClass().getResource("AdminSignin.fxml"));
             stage=((Stage)((Node)event.getSource()).getScene().getWindow());
             scene=new Scene(root);
             stage.setScene(scene);
             stage.show();
         }
         else {
             message2.setText("Invalid Username or Password");
         }
     }
     catch ( Exception e){
         e.printStackTrace();
     }
 }
    }
    public void BackBut( ActionEvent event)throws IOException{
        root=FXMLLoader.load(getClass().getResource("Loginpage.fxml"));
        stage=((Stage)((Node)event.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
