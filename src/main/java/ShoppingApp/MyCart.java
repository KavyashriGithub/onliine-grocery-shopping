package ShoppingApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

// Creating a table implements and initialization is required
public class MyCart implements Initializable {

//    Table ID
    @FXML
    public TableView<MyCart2>TableView;

//    columns ID's
    @FXML
    public TableColumn<MyCart2, Integer>Id;

    @FXML
    public TableColumn<MyCart2, String>Username;

    @FXML
    public TableColumn<MyCart2, String>Item;

    @FXML
    public TableColumn<MyCart2, Integer>Price;

    @FXML
    public TableColumn<MyCart2, Integer>Quantity;

    @FXML
    public TableColumn<MyCart2, Integer>Total;

    @FXML
     public Button BUT1, Remove;

    @FXML
    Label messagelabel1, CartCommunication,GrandTotal;
    public Parent root,root1;
    public Stage stage,stage1;
    public Scene scene,scene1;

// Connection for DB
    DataBaseConnection connect= new DataBaseConnection();
    Connection connection=connect.getConnection();
    PreparedStatement statement;
    ResultSet result;
//controller communication
    public void display2(String username2){
        CartCommunication.setText(username2);
    }

//    Initializing the values
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        Username.setCellValueFactory(new PropertyValueFactory<>("Username"));
        Item.setCellValueFactory(new PropertyValueFactory<>("Item"));
        Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        Total.setCellValueFactory(new PropertyValueFactory<>("Total"));

    }
//        show button inserting the Selected products in Cart table
       public void But1(ActionEvent event) throws SQLException{
        ObservableList<MyCart2>list= FXCollections.observableArrayList();
        connect=new DataBaseConnection();
        connection=connect.getConnection();
        try{
            statement=connection.prepareStatement("SELECT* FROM add_to_cart WHERE USERNAME = ?;");
            statement.setString(1, CartCommunication.getText());
            result=statement.executeQuery();
            while (result.next()){

                list.add(new MyCart2(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getInt(5),
                        result.getInt(6)));
                TableView.setItems(list);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
//          Deleting the unwanted item in cart
    public void Remove1(ActionEvent event){
        MyCart2 selected=TableView.getSelectionModel().getSelectedItem();
         if (TableView.getSelectionModel().isEmpty()){
             messagelabel1.setText("Select item you want to Delete");
         }
         else {
                 int value = selected.getId();
                 try {
                     statement = connection.prepareStatement("DELETE FROM add_to_cart WHERE ID = ?");
                     statement.setInt(1, value);
                     statement.executeUpdate();
                     TableView.getItems().remove(selected);
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
         }

    }
//        Back button  to Products
    public void Back1(ActionEvent event) throws IOException {
//        controller communication
        String username= CartCommunication.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("HomePage.fxml"));
        root=loader.load();
        HomePage homePage=loader.getController();
        homePage.hello(username);
//        Parent root= FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage=((Stage)((Node) event.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//  Grand Total Method  Button
    public void GrandTotalBut(ActionEvent event)throws IOException{

        int total=0;
        for (MyCart2 myCart: TableView.getItems()){
            total=total+myCart.getTotal();
            GrandTotal.setText(String.valueOf(total));
        }
    }
//    Button to delivery Address page
    public void BuyCartbut(ActionEvent event)throws IOException{
        if(GrandTotal.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Calculate the grand total");
            alert.show();
        }else {
            String username= GrandTotal.getText();//Total communication
            String username1= CartCommunication.getText();// username communication
            FXMLLoader loader=new FXMLLoader(getClass().getResource("DeliveryAddress.fxml"));
            root1=loader.load();
            DeliveryAddress deliveryAddress=loader.getController();
            deliveryAddress.gTotal(username);
            deliveryAddress.Username(username1);
            stage1=((Stage)((Node) event.getSource()).getScene().getWindow());
            scene1=new Scene(root1);
            stage1.setScene(scene1);
            stage1.show();
        }
    }
}

