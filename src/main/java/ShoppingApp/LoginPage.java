package ShoppingApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class  LoginPage  {
//  Defining ID's
    @FXML
    TextField UserName2;
    @FXML
    PasswordField Password2;
    @FXML
    Label messagebox2;
    @FXML
    Button loginn1;

    public Stage stage;
    public Scene scene;
    public Parent root;

    //                 LOGIN FXML PAGE

//    login button
    public void loginn(ActionEvent event)throws IOException {

        if (UserName2.getText().isEmpty()|| Password2.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Fields cannot be empty!!!");
            alert.show();
         }
        else {
            try {
//              DB connection and data analyse
                DataBaseConnection connect = new DataBaseConnection();
                Connection connection = connect.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM signin WHERE USERNAME= ? AND PASSWORD=?;");
                statement.setString(1, UserName2.getText());
                statement.setString(2, Password2.getText());
                ResultSet result = statement.executeQuery();

                if (result.next()) {
                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Successfully logged in !!!");
                    //                    Controller communication
                    String username= UserName2.getText();
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("HomePage.fxml"));
                    root=loader.load();
                    HomePage homePage=loader.getController();
                    homePage.hello(username);
//                    root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                    stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Invalid Password !!!");
                    alert.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//   SignIn entering button
    public void siginn(ActionEvent event) throws IOException{
        root= FXMLLoader.load(getClass().getResource("sign-inpage.fxml"));
        stage=((Stage)((Node) event.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//    Admin entering button
    public void AdminPage(ActionEvent event)throws IOException{
        root=FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        stage=((Stage)((Node)event.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
