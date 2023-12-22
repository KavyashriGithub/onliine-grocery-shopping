package ShoppingApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Welcomepage {

    //Declaring  ID Names
         @FXML
        Button Shopnow;

        public Stage stage;
        public Scene scene;
        public Parent root;

     //                       WELCOME FXML PAGE

     //This code is used for switching fxml files with the use of button(Shopnow)

        public void shopbut(ActionEvent event) throws IOException {
            root= FXMLLoader.load(getClass().getResource("Loginpage.fxml"));
            stage=((Stage)((Node) event.getSource()).getScene().getWindow());
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }