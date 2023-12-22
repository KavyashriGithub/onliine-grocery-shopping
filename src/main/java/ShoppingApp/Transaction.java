package ShoppingApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Transaction {
    @FXML
    RadioButton SelectBut;
    @FXML
    Label Prize,Prize1,UPIPrize,PaymentsUsername;
    @FXML
    TextField CN,CT,CVV,CV,UPN,UPNUM,UPID,name1;

    public Parent root;
    Stage stage,stage1;
    Scene scene;

//    Communication with controllers
    public void PriceAmount(String Price){
        Prize.setText(Price);
        Prize1.setText(Price);
        UPIPrize.setText(Price);
    }
    public void UsernameP(String username1){
        PaymentsUsername.setText(username1);}

//    Your transaction is done
    public void DoneBut(ActionEvent event)throws IOException{
        if(SelectBut.isSelected()){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Your Order As Been Placed !!!");
            alert.show();
            String username= PaymentsUsername.getText();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("HomePage.fxml"));
            root=loader.load();
            HomePage homePage=loader.getController();
            homePage.hello(username);
//        root= FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else if(name1.getText().isEmpty()){
            Alert alert1=new Alert(Alert.AlertType.WARNING);
            alert1.setContentText("Please enter a name !!!");
            alert1.show();
        }else {
            Alert alert2=new Alert(Alert.AlertType.WARNING);
            alert2.setContentText("Select Cash on delivery");
            alert2.show();
        }

    }
    public void SelectBut(ActionEvent event) {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("YOU Have Selected Cash on Delivery!!!");
        alert.show();
    }

    public void CrPay(ActionEvent event) throws IOException {
        if(CN.getText().isEmpty()||CT.getText().isEmpty()||CV.getText().isEmpty()||CVV.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter the info above");
            alert.show();
        }else{
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Your Order As Been Placed !!!");
                alert.show();
            String username= PaymentsUsername.getText();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("HomePage.fxml"));
            root=loader.load();
            HomePage homePage=loader.getController();
            homePage.hello(username);
//        root= FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void UPIPay(ActionEvent event) throws IOException {
        if (UPID.getText().isEmpty()||UPN.getText().isEmpty()||UPNUM.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter the info above");
            alert.show();
        }else{
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Your Order As Been Placed !!!");
            alert.show();
            String username= PaymentsUsername.getText();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("HomePage.fxml"));
            root=loader.load();
            HomePage homePage=loader.getController();
            homePage.hello(username);
//        root= FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void PaymentBack(ActionEvent event)throws IOException {
        String username= PaymentsUsername.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("HomePage.fxml"));
        root=loader.load();
        HomePage homePage=loader.getController();
        homePage.hello(username);
//        root= FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
