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

public class Sign_In implements Initializable {

               //Declaring id
    @FXML
    TextField  FirstName1,LastName1,userName1,Email1;
    @FXML
    PasswordField password1,confirmpassword1;
    @FXML
    Label messageLable1;

    public Stage stage;
    public Scene scene;
    public Parent root;

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
        FirstName1.setTextFormatter(new TextFormatter<String>(filter));
        LastName1.setTextFormatter(new TextFormatter<String>(filter));
    }
//                     Back Button!!!

    public void back2(ActionEvent event) throws  IOException {
        root=FXMLLoader.load(getClass().getResource("Loginpage.fxml"));
        stage=((Stage)((Node)event.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // Creating connaction with JDBC
    DataBaseConnection connect= new DataBaseConnection();
    Connection connection=connect.getConnection();
    PreparedStatement statement;
    ResultSet result;

   // Condition to not being fields empty AND  password and Conformation password should be same!!

    public void create1(ActionEvent event)throws IOException {

        try {
            if (FirstName1.getText().isEmpty() || LastName1.getText().isEmpty() || userName1.getText().isEmpty() || Email1.getText().isEmpty()) {
                messageLable1.setText("Fields cannot be empty");
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Fields cannot be empty");
                alert.show();
            } else if (password1.getText().equals(confirmpassword1.getText())) {
                if (Email1.getText().contains("@")){
                    if (userName1.getText().length()<12 && password1.getText().length()<14 && FirstName1.getText().length()<14 ){
                    userinfo();
                    //        controller communication
                    String username= userName1.getText();
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("HomePage.fxml"));
                    root=loader.load();
                    HomePage homePage=loader.getController();
                    homePage.hello(username);
                    stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    }else{
                        Alert alert=new Alert(Alert.AlertType.WARNING);
                        alert.setContentText("Text fields cannot be more then 10 ");
                        alert.show();
                    }
                }
                else {
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Enter @ in Email TextField");
                    alert.show();
                }
            } else {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Password and conformPassword should be same!!! ");
                alert.show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       // UserName should not be same AND  Inserting the user data to DB

        public void userinfo() throws SQLException {
            try {
                statement = connection.prepareStatement("SELECT * FROM signin WHERE USERNAME = ?");
                statement.setString(1,userName1.getText());
                result=statement.executeQuery();

                if (result.next()){
                    messageLable1.setText("UserName is already used");
                }else {
                    statement=connection.prepareStatement("INSERT INTO signin (FIRSTNAME,LASTNAME,USERNAME,EMAIL,PASSWORD) VALUES (?,?,?,?,?);");
                    statement.setString(1,FirstName1.getText());
                    statement.setString(2,LastName1.getText());
                    statement.setString(3,userName1.getText());
                    statement.setString(4,Email1.getText());
                    statement.setString(5,confirmpassword1.getText());
                    statement.execute();
                    messageLable1.setText("Successfully Created");
                   }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }


}
