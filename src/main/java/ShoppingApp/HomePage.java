package ShoppingApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePage {

// Defining - ID's
    @FXML
    Label Uname;
    public Parent root;
    public Stage stage;
    public Scene scene;

//    Controller with Communication
   public void hello(String username){
       Uname.setText(username);
   }


//    MyCart button
    public void MyCart(ActionEvent event) throws IOException{
        String username=Uname.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Mycart.fxml"));
        root=loader.load();
        MyCart myCart=loader.getController();
        myCart. display2(username);
//        root = FXMLLoader.load(getClass().getResource("Mycart.fxml"));
        stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//    My Orders But
    public void MyOders(ActionEvent event)throws IOException{
//     controller communication of username to my orders!!!
        String username=Uname.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("MyOrders.fxml"));
        root=loader.load();
        MYORDERS Myorder=loader.getController();
        Myorder.display3(username);
        stage=((Stage) ((Node)event.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    //   Product  button
    public void Cvegii(ActionEvent event) throws IOException{
//       Controller with communication
        String username=Uname.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("ProductsVegi.fxml"));
        root=loader.load();
        Products products=loader.getController();
        products. display(username);
//        root = FXMLLoader.load(getClass().getResource("ProductsVegi.fxml"));
        stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void CategoryFruits(ActionEvent event) throws IOException{
//       Controller with communication
        String username=Uname.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("CategoryFruit.fxml"));
        root=loader.load();
        Products products=loader.getController();
        products. displayFruit(username);
        stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void CategoriesMilk1(ActionEvent event) throws IOException {
//       Controller with communication
        String username = Uname.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CategoryMilkProducts.fxml"));
        root = loader.load();
        Products products = loader.getController();
        products.displayMilk(username);
        stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void CategoryOil1(ActionEvent event) throws IOException {
//       Controller with communication
        String username = Uname.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CategoryOil.fxml"));
        root = loader.load();
        Products products = loader.getController();
        products.displayOil(username);
        stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void BackAbotu(ActionEvent event) throws IOException{
        root=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage=((Stage)((Node)event.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Logoutbut(ActionEvent event) throws IOException{
        root=FXMLLoader.load(getClass().getResource("Loginpage.fxml"));
        stage=((Stage)((Node)event.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
