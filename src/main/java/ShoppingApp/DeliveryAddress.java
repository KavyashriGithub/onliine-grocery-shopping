package ShoppingApp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class DeliveryAddress implements Initializable {
    @FXML
    Label GrandTDeliver,deliveryUsername;
@FXML
TextField FName,LName,PNumber,Pin;
@FXML
TextArea Address;

public Parent root;
public Stage stage;
public Scene scene;

DataBaseConnection connect=new DataBaseConnection();
Connection connection=connect.getConnection();
PreparedStatement statement;
Result result;

//Communication controller
    public void gTotal (String username){
        GrandTDeliver.setText(username);
    }
    public void Username (String username1){deliveryUsername.setText(username1);}

//    ini
     @Override
       public void initialize(URL url, ResourceBundle resourceBundle) {
         UnaryOperator<TextFormatter.Change> filter= change -> {
             String text = change.getText();
             if (text.matches("[a-z A-Z]")) {
                 return  change;
             }else{
                 change.setText("");
             }
             return change;
         };
         FName.setTextFormatter(new TextFormatter<String>(filter));
         LName.setTextFormatter(new TextFormatter<String>(filter));

         PNumber.textProperty().addListener(new ChangeListener<String>() {
             @Override
             public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                 if (!newValue.matches("\\d*")||PNumber.getText().length()>10){
                     PNumber.setText(newValue.replaceAll("[\\D]",""));
                     PNumber.setText(oldValue);
                 }
             }
         });
         Pin.textProperty().addListener(new ChangeListener<String>() {
             @Override
             public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                 if (!newValue.matches("\\d*")||Pin.getText().length()>8){
                     Pin.setText(newValue.replaceAll("[\\D]",""));
                     Pin.setText(oldValue);
                 }
             }
         });
    }

//    BUY Button to save the address of the person
public void BUY(ActionEvent event) throws IOException {

    try{
        if (FName.getText().isEmpty()||LName.getText().isEmpty()||PNumber.getText().isEmpty()||Address.getText().isEmpty()||Pin.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Fields Cannot be empty!!!");
            alert.show();
        }
        else if (FName.getText().length()<14 && LName.getText().length()<10){
        statement=connection.prepareStatement("INSERT INTO DELIVERY_ADDRESS (FIRSTNAME,LASTNAME,PHONENUMBER,ADDRESS,PIN)VALUES(?,?,?,?,?);");
        statement.setString(1,FName.getText());
        statement.setString(2,LName.getText());
        statement.setString(3,PNumber.getText());
        statement.setString(4,Address.getText());
        statement.setString(5,Pin.getText());
        statement.execute();
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Address has been set");
            alert.show();

            //        Communication with controller (Prize)
            String Prize= GrandTDeliver.getText();
            String username= deliveryUsername.getText();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Transaction.fxml"));
            root=loader.load();
            Transaction transaction=loader.getController();
            transaction.PriceAmount(Prize);
            transaction.UsernameP(username);
//            switching scenes
            stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("First name and Last name is to long");
            alert.show();
        }

}catch (SQLException e){
    e.printStackTrace();
    }

}
    //        Back button  to Products
    public void BackDeli(ActionEvent event) throws IOException {
//        controller communication
        String username= deliveryUsername.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("HomePage.fxml"));
        root=loader.load();
        HomePage homePage=loader.getController();
        homePage.hello(username);
        stage=((Stage)((Node) event.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
