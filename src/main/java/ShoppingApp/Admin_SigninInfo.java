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

public class Admin_SigninInfo implements Initializable {
    @FXML
    public TableView<Admin_SigninInfo2> TableView;

    //    columns ID's
    @FXML
    public TableColumn<Admin_SigninInfo2, Integer> id;

    @FXML
    public TableColumn<Admin_SigninInfo2, String> FirstN;

    @FXML
    public TableColumn<Admin_SigninInfo2, String> LastN;

    @FXML
    public TableColumn<Admin_SigninInfo2, String> UserN;

    @FXML
    public TableColumn<Admin_SigninInfo2, String> Email;

    @FXML
    public TableColumn<Admin_SigninInfo2, String> Password;
    @FXML
    Label AdminName;

    public Parent root;
    public Stage stage;
    public Scene scene;

    // Connection for DB
    DataBaseConnection connect= new DataBaseConnection();
    Connection connection=connect.getConnection();
    PreparedStatement statement;
    ResultSet result;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        FirstN.setCellValueFactory(new PropertyValueFactory<>("FirstN"));
        LastN.setCellValueFactory(new PropertyValueFactory<>("LastN"));
        UserN.setCellValueFactory(new PropertyValueFactory<>("UserN"));
        Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        Password.setCellValueFactory(new PropertyValueFactory<>("Password"));

    }
    public void go(String username){
        AdminName.setText(username);
    }
    public void Show(ActionEvent event)throws SQLException {
        ObservableList<Admin_SigninInfo2> list= FXCollections.observableArrayList();
        connect=new DataBaseConnection();
        connection=connect.getConnection();
        try {
            statement=connection.prepareStatement("SELECT * FROM signin;");
            result=statement.executeQuery();
            while (result.next()){

                list.add(new Admin_SigninInfo2(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6)));
                TableView.setItems(list);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void OrderBut(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("AdminOrder.fxml"));
        stage=((Stage)((Node) event.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void DeliveryBut(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("AdminDelivery.fxml"));
        stage=((Stage)((Node) event.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void BackBut(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Loginpage.fxml"));
        stage=((Stage)((Node) event.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}