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

public class Admin_Order implements Initializable {
@FXML
    public TableView<Admin_Order2>Tableview;
@FXML
    public TableColumn<Admin_Order2, Integer> id;
    @FXML
    public TableColumn<Admin_Order2, String> userN;
    @FXML
    public TableColumn<Admin_Order2, String> item;
    @FXML
    public TableColumn<Admin_Order2, Integer>prize;
    @FXML
    public TableColumn<Admin_Order2, Integer>quantity;
    @FXML
    public TableColumn<Admin_Order2, Integer>total;

    public Parent root;
    public Stage stage;
    public Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        userN.setCellValueFactory(new PropertyValueFactory<>("userN"));
        item.setCellValueFactory(new PropertyValueFactory<>("item"));
        prize.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
    }
    DataBaseConnection connect=new DataBaseConnection();
    Connection connection=connect.getConnection();
    PreparedStatement statement;
    ResultSet result;
    public void Show(ActionEvent event) throws SQLException {
        ObservableList<Admin_Order2> list1= FXCollections.observableArrayList();
        connect=new DataBaseConnection();
        connection=connect.getConnection();
        try{
            statement=connection.prepareStatement("SELECT * FROM add_to_cart;");
            result=statement.executeQuery();
            while (result.next()){
                list1.add(new Admin_Order2(
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
   public void  BackOrder(ActionEvent event)throws IOException {
       root= FXMLLoader.load(getClass().getResource("AdminSignin.fxml"));
       stage=((Stage)((Node) event.getSource()).getScene().getWindow());
       scene=new Scene(root);
       stage.setScene(scene);
       stage.show();
   }
}
