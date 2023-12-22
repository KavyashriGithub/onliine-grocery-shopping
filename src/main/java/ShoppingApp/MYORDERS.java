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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MYORDERS implements Initializable {
    //    Table ID
    @FXML
    public TableView<MYORDERS2> Tableview;

    //    columns ID's
    @FXML
    public TableColumn<MYORDERS, Integer>Id;

    @FXML
    public TableColumn<MYORDERS, String>UserN;

    @FXML
    public TableColumn<MYORDERS, String>Item;

    @FXML
    public TableColumn<MYORDERS, Integer>Prize;

    @FXML
    public TableColumn<MYORDERS, Integer>Quantity;

    @FXML
    public TableColumn<MYORDERS, Integer>Total;

    @FXML
    Label MyOrdersUsername,messageBox1,GrandTotal;

    public Parent root;
    Stage stage;
    Scene scene;


//    controller communication of username
    public void display3(String username){
        MyOrdersUsername.setText(username);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        UserN.setCellValueFactory(new PropertyValueFactory<>("UserN"));
        Item.setCellValueFactory(new PropertyValueFactory<>("Item"));
        Prize.setCellValueFactory(new PropertyValueFactory<>("Price"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        Total.setCellValueFactory(new PropertyValueFactory<>("Total"));
    }
    DataBaseConnection connect=new DataBaseConnection();
    Connection connection=connect.getConnection();
    PreparedStatement statement;
    ResultSet result;


    public void ShowMyOrders(ActionEvent event) throws SQLException {
        ObservableList<MYORDERS2> list1=FXCollections.observableArrayList();
        connect=new DataBaseConnection();
        connection=connect.getConnection();
        try{
//            statement=connection.prepareStatement("SELECT * FROM add_to_cart;");
//            result=statement.executeQuery();
            statement=connection.prepareStatement("SELECT* FROM add_to_cart WHERE USERNAME = ?;");
            statement.setString(1, MyOrdersUsername.getText());
            result=statement.executeQuery();
            while (result.next()){
                list1.add(new MYORDERS2(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getInt(5),
                        result.getInt(6)));
                Tableview.setItems(list1);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
   public void DeleteMyOrders(ActionEvent event)throws SQLException{
       MYORDERS2 selected=Tableview.getSelectionModel().getSelectedItem();
       if (Tableview.getSelectionModel().isEmpty()){
           messageBox1.setText("Select item you want to Delete");
       }
       else {
           int value = selected.getId();
           try {
               statement = connection.prepareStatement("DELETE FROM add_to_cart WHERE ID = ?");
               statement.setInt(1, value);
               statement.executeUpdate();
               Tableview.getItems().remove(selected);
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
   }
    //  Grand Total Method  Button
    public void GrandTotalBut(ActionEvent event)throws IOException{
        int total=0;
        for (MYORDERS2 myorders: Tableview.getItems()){
            total=total+myorders.getTotal();
            GrandTotal.setText(String.valueOf(total));
        }
    }
//    Back button to Home
    public void HomeBackBut(ActionEvent event)throws IOException {
//        communication with controller username back to home!!
        String username=MyOrdersUsername.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("HomePage.fxml"));
        root=loader.load();
        HomePage homePage=loader.getController();
        homePage.hello(username);
        stage=((Stage) ((Node)event.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}