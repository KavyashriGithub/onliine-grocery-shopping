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

public class Admin_Delivery implements Initializable {
    @FXML
    public TableView<Admin_Delivery2> Tableview;
    @FXML
    public TableColumn<Admin_Delivery2, Integer>id;
    @FXML
    public TableColumn<Admin_Delivery2, String> firstN;
    @FXML
    public TableColumn<Admin_Delivery2, String> lastN;
    @FXML
    public TableColumn<Admin_Delivery2, Long> phoneNumber;
    @FXML
    public TableColumn<Admin_Delivery2, String>address;
    @FXML
    public TableColumn<Admin_Delivery2, Integer>pin;

    public Parent root;
    public Stage stage;
    public Scene scene;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstN.setCellValueFactory(new PropertyValueFactory<>("firstN"));
        lastN.setCellValueFactory(new PropertyValueFactory<>("lastN"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        pin.setCellValueFactory(new PropertyValueFactory<>("pin"));
    }
    DataBaseConnection connect=new DataBaseConnection();
    Connection connection=connect.getConnection();
    PreparedStatement statement;
    ResultSet result;

    public void ShowBut(ActionEvent event) throws SQLException {
        ObservableList<Admin_Delivery2> list1= FXCollections.observableArrayList();
        connect=new DataBaseConnection();
        connection=connect.getConnection();
        try{
            statement=connection.prepareStatement("SELECT * FROM DELIVERY_ADDRESS;");
            result=statement.executeQuery();
            while (result.next()){
                list1.add(new Admin_Delivery2(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6)));
                Tableview.setItems(list1);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void  BackBut(ActionEvent event)throws IOException {
        root= FXMLLoader.load(getClass().getResource("AdminSignin.fxml"));
        stage=((Stage)((Node) event.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
