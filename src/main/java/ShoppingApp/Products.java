package ShoppingApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Products  {
//   Defining the LABEL,TEXT FIELDS AND BUTTON - ID
    @FXML
    Label Pwelcome,UsernameFruits,MilkUsername,OilUsername,
        Tomatoname,Tomatoprice,Totaltomato,
        pumN,pumP,TotalPum,
        CarrotN,carrotP,Totalcarrot,
        CybageN,CybageP,TotalCybage,
        GarlicN,GarlicP,TotalGarlic,
        MashroomN,MashroomP,TotalMashroom,
        OnionN,OnionP,TotalOnion,
        CucN,CucP,TotalCuc,
        PotatoN,PotatoP,TotalPotato,
        MangoN,MangoP,TotalMango,
        AppleN,AppleP,TotalApple,
        BananaN,BananaP,TotalBanana,
        PinappleN,PinP,TotalPin,
        MilkN,MilkP,TotalMilk,
        ChzN,ChzP,TotalChz,
        ButterN,ButterP,TotalButter;

    @FXML
    TextField TomatoQuantity,pumQ,carrotQ,CybageQ,GarlicQ,
        MashroomQ,OnionQ,CucQ,PotatoQ,MangoQ,AppleQ,BananaQ,PinQ,MilkQ,ChzQ,ButterQ;

    public Parent root;
    public Scene scene;
    public Stage stage;

    //     DB Connection
    DataBaseConnection connect=new DataBaseConnection();
    Connection connection=connect.getConnection();
    PreparedStatement statement;
    ResultSet result;


//    Communication with controller function
  public void display(String username2){
        Pwelcome.setText(username2);
  }
  public void displayFruit(String usernameF){UsernameFruits.setText(usernameF);}
  public void displayMilk(String usernameM){MilkUsername.setText(usernameM);}
    public void displayOil(String usernameO){OilUsername.setText(usernameO);}

//  coming back to homePage - button
    public void BackP(ActionEvent event) throws IOException{
        String username= Pwelcome.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("HomePage.fxml"));
        root=loader.load();
        HomePage homePage=loader.getController();
        homePage.hello(username);

//        root= FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage=((Stage)((Node) event.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//  Tomato product
public  void Tomato1(ActionEvent event) throws SQLException {

    Tomato2();// calling
}
  public void Tomato2()throws SQLException{
      if (TomatoQuantity.getText().isEmpty()||Totaltomato.getText().isEmpty()){
          Alert alert=new Alert(Alert.AlertType.WARNING);
          alert.setContentText("Please enter the Quantity u need and Press = for total");
          alert.show();
      }else{
    try {
//        entering the dat into DataBase!!
        statement=connection.prepareStatement("INSERT INTO add_to_cart (USERNAME,PRODUCTNAME,PRICE,QUANTITY,TOTAL) VALUES (?,?,?,?,?);");
        statement.setString(1,Pwelcome.getText());
        statement.setString(2,Tomatoname.getText());
        statement.setString(3,Tomatoprice.getText());
        statement.setString(4,TomatoQuantity.getText());
        statement.setString(5,Totaltomato.getText());
        statement.execute();
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Product Add to cart");
            alert.show();

    }catch (SQLException e){
        e.printStackTrace();
    }
      }
  }
    //    Calculation button of price * Quantity part!!
    public void Ctomato(){
        int result= Integer.valueOf(Tomatoprice.getText()) * Integer.valueOf(TomatoQuantity.getText());
        Totaltomato.setText(String.valueOf(result));
    }
//    ---------------------------------------------------------------------------------------------------
//    pumpkin product
    public  void Pumpkin(ActionEvent event) throws SQLException {

        Pumpkin1();//calling
    }
    public void Pumpkin1()throws SQLException{
        if (pumQ.getText().isEmpty()||TotalPum.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter the Quantity u need and Press = for total");
            alert.show();
        }else{
      try {
            statement=connection.prepareStatement("INSERT INTO add_to_cart (USERNAME,PRODUCTNAME,PRICE,QUANTITY,TOTAL) VALUES (?,?,?,?,?);");
            statement.setString(1,Pwelcome.getText());
            statement.setString(2,pumN.getText());
            statement.setString(3,pumP.getText());
            statement.setString(4,pumQ.getText());
            statement.setString(5,TotalPum.getText());
            statement.execute();
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Product Add to cart");
            alert.show();

        }catch (SQLException e){
            e.printStackTrace();
        }
        }
    }
    //    Calculation button of price * Quantity part!!
    public void Cpum(){
        int result= Integer.valueOf(pumP.getText()) * Integer.valueOf(pumQ.getText());
        TotalPum.setText(String.valueOf(result));
    }
    //---------------------------------------------------------------------------------------------------------
// Carrot product
    public void Carrot(ActionEvent event)throws SQLException{
        if (carrotQ.getText().isEmpty()||Totalcarrot.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter the Quantity u need and Press = for total");
            alert.show();
        }else{
      try{
          statement=connection.prepareStatement("INSERT INTO add_to_cart (USERNAME,PRODUCTNAME,PRICE,QUANTITY,TOTAL) VALUES (?,?,?,?,?);");
          statement.setString(1,Pwelcome.getText());
          statement.setString(2,CarrotN.getText());
          statement.setString(3,carrotP.getText());
          statement.setString(4,carrotQ.getText());
          statement.setString(5,Totalcarrot.getText());
          statement.execute();
          Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
          alert.setContentText("Product Add to cart");
          alert.show();

      }catch (SQLException e){
          e.printStackTrace();
      }
        }

    }
    public void Ccarrot(){
      int result=Integer.valueOf(carrotP.getText())*Integer.valueOf(carrotQ.getText());
      Totalcarrot.setText(String.valueOf(result));
    }
//    -----------------------------------------------------------------------------------------------------------

//   Cybage Product
     public void CybageBut(ActionEvent event)throws SQLException{
         if (CybageQ.getText().isEmpty()||TotalCybage.getText().isEmpty()){
             Alert alert=new Alert(Alert.AlertType.WARNING);
             alert.setContentText("Please enter the Quantity u need and Press = for total");
             alert.show();
         }else{
         try{
             statement=connection.prepareStatement("INSERT INTO add_to_cart (USERNAME,PRODUCTNAME,PRICE,QUANTITY,TOTAL) VALUES (?,?,?,?,?);");
             statement.setString(1,Pwelcome.getText());
             statement.setString(2,CybageN.getText());
             statement.setString(3,CybageP.getText());
             statement.setString(4,CybageQ.getText());
             statement.setString(5,TotalCybage.getText());
             statement.execute();
             Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
             alert.setContentText("Product Add to cart");
             alert.show();

         }catch (SQLException e){
             e.printStackTrace();
         }
         }
     }
    public void CCybage(){
        int result=Integer.valueOf(CybageP.getText())*Integer.valueOf(CybageQ.getText());
        TotalCybage.setText(String.valueOf(result));
    }
//    ------------------------------------------------------------------------------------------------------

//    Garlic Product
    public void GarlicBut(ActionEvent event) throws SQLException{
        if (GarlicQ.getText().isEmpty()||TotalGarlic.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter the Quantity u need and Press = for total");
            alert.show();
        }else{
      try{
            statement=connection.prepareStatement("INSERT INTO add_to_cart (USERNAME,PRODUCTNAME,PRICE,QUANTITY,TOTAL) VALUES (?,?,?,?,?);");
            statement.setString(1,Pwelcome.getText());
            statement.setString(2,GarlicN.getText());
            statement.setString(3,GarlicP.getText());
            statement.setString(4,GarlicQ.getText());
            statement.setString(5,TotalGarlic.getText());
            statement.execute();
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Product Add to cart");
            alert.show();

        }catch (SQLException e){
            e.printStackTrace();
        }
        }
    }
    public void CGarlic(){
        int result=Integer.valueOf(GarlicP.getText())*Integer.valueOf(GarlicQ.getText());
        TotalGarlic.setText(String.valueOf(result));
    }
//-----------------------------------------------------------------------------------------------------------

//Mushroom Product
    public void MashroomBut(ActionEvent event) throws SQLException{
        if (MashroomQ.getText().isEmpty()||TotalMashroom.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter the Quantity u need and Press = for total");
            alert.show();
        }else{
      try{
        statement=connection.prepareStatement("INSERT INTO add_to_cart (USERNAME,PRODUCTNAME,PRICE,QUANTITY,TOTAL) VALUES (?,?,?,?,?);");
        statement.setString(1,Pwelcome.getText());
        statement.setString(2,MashroomN.getText());
        statement.setString(3,MashroomP.getText());
        statement.setString(4,MashroomQ.getText());
        statement.setString(5,TotalMashroom.getText());
        statement.execute();
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Product Add to cart");
        alert.show();

    }catch (SQLException e){
        e.printStackTrace();
    }
        }
  }
    public void CMashroom(){
        int result=Integer.valueOf(MashroomP.getText())*Integer.valueOf(MashroomQ.getText());
        TotalMashroom.setText(String.valueOf(result));
    }
//------------------------------------------------------------------------------------------------------------


//    ONION PRODUCT
public void OnionBut(ActionEvent event) throws SQLException{
    if (OnionQ.getText().isEmpty()||TotalOnion.getText().isEmpty()){
        Alert alert=new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Please enter the Quantity u need and Press = for total");
        alert.show();
    }else {
        try {
            statement = connection.prepareStatement("INSERT INTO add_to_cart (USERNAME,PRODUCTNAME,PRICE,QUANTITY,TOTAL) VALUES (?,?,?,?,?);");
            statement.setString(1, Pwelcome.getText());
            statement.setString(2, OnionN.getText());
            statement.setString(3, OnionP.getText());
            statement.setString(4, OnionQ.getText());
            statement.setString(5, TotalOnion.getText());
            statement.execute();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Product Add to cart");
            alert.show();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    public void COnion(){
        int result=Integer.valueOf(OnionP.getText())*Integer.valueOf(OnionQ.getText());
        TotalOnion.setText(String.valueOf(result));
    }
//--------------------------------------------------------------------------------------------------------------
//  CUCUMBER PRODUCT
public void CucBut(ActionEvent event) throws SQLException{
    if (CucQ.getText().isEmpty()||TotalCuc.getText().isEmpty()){
        Alert alert=new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Please enter the Quantity u need and Press = for total");
        alert.show();
    }else{
      try{
        statement=connection.prepareStatement("INSERT INTO add_to_cart (USERNAME,PRODUCTNAME,PRICE,QUANTITY,TOTAL) VALUES (?,?,?,?,?);");
        statement.setString(1,Pwelcome.getText());
        statement.setString(2,CucN.getText());
        statement.setString(3,CucP.getText());
        statement.setString(4,CucQ.getText());
        statement.setString(5,TotalCuc.getText());
        statement.execute();
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Product Add to cart");
        alert.show();

    }catch (SQLException e){
        e.printStackTrace();
    }
    }
}
    public void CCuc(){
        int result=Integer.valueOf(CucP.getText())*Integer.valueOf(CucQ.getText());
        TotalCuc.setText(String.valueOf(result));
    }
//    ----------------------------------------------------------------------------------------------------
//    Potato Product
public void PotatoBut(ActionEvent event) throws SQLException{
      if (PotatoQ.getText().isEmpty()||TotalPotato.getText().isEmpty()){
          Alert alert=new Alert(Alert.AlertType.WARNING);
          alert.setContentText("Please enter the Quantity u need and Press = for total");
          alert.show();
      }else{
    try{
        statement=connection.prepareStatement("INSERT INTO add_to_cart (USERNAME,PRODUCTNAME,PRICE,QUANTITY,TOTAL) VALUES (?,?,?,?,?);");
        statement.setString(1,Pwelcome.getText());
        statement.setString(2,PotatoN.getText());
        statement.setString(3,PotatoP.getText());
        statement.setString(4,PotatoQ.getText());
        statement.setString(5,TotalPotato.getText());
        statement.execute();
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Product Add to cart");
        alert.show();

    }catch (SQLException e){
        e.printStackTrace();
    }
      }
}
    public void CPotato(){
        int result=Integer.valueOf(PotatoP.getText())*Integer.valueOf(PotatoQ.getText());
        TotalPotato.setText(String.valueOf(result));
    }
//    -----------------------------------------------------------------------------------------------------------
//    -----------------------------------------------------------------------------------------------------------
//                                               Product Fruits
public void BackFruits(ActionEvent event)throws IOException{
    //  coming back to homePage - button
    String username= UsernameFruits.getText();
    FXMLLoader loader=new FXMLLoader(getClass().getResource("HomePage.fxml"));
    root=loader.load();
    HomePage homePage=loader.getController();
    homePage.hello(username);
//        root= FXMLLoader.load(getClass().getResource("HomePage.fxml"));
    stage=((Stage)((Node) event.getSource()).getScene().getWindow());
    scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
}
    public void MangoAddBut(ActionEvent event) throws SQLException{
        if (MangoQ.getText().isEmpty()||TotalMango.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter the Quantity u need and Press = for total");
            alert.show();
        }else{
            try{
                statement=connection.prepareStatement("INSERT INTO add_to_cart (USERNAME,PRODUCTNAME,PRICE,QUANTITY,TOTAL) VALUES (?,?,?,?,?);");
                statement.setString(1,UsernameFruits.getText());
                statement.setString(2,MangoN.getText());
                statement.setString(3,MangoP.getText());
                statement.setString(4,MangoQ.getText());
                statement.setString(5,TotalMango.getText());
                statement.execute();
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Product Add to cart");
                alert.show();

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void CMango(){
        int result=Integer.valueOf(MangoP.getText())*Integer.valueOf(MangoQ.getText());
        TotalMango.setText(String.valueOf(result));
    }

    public void AppleAddBut(ActionEvent event) throws SQLException{
        if (AppleQ.getText().isEmpty()||TotalApple.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter the Quantity u need and Press = for total");
            alert.show();
        }else{
            try{
                statement=connection.prepareStatement("INSERT INTO add_to_cart (USERNAME,PRODUCTNAME,PRICE,QUANTITY,TOTAL) VALUES (?,?,?,?,?);");
                statement.setString(1,UsernameFruits.getText());
                statement.setString(2,AppleN.getText());
                statement.setString(3,AppleP.getText());
                statement.setString(4,AppleQ.getText());
                statement.setString(5,TotalApple.getText());
                statement.execute();
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Product Add to cart");
                alert.show();

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void CApple(){
        int result=Integer.valueOf(AppleP.getText())*Integer.valueOf(AppleQ.getText());
        TotalApple.setText(String.valueOf(result));
    }

    public void BananaAddBut(ActionEvent event) throws SQLException{
        if (BananaQ.getText().isEmpty()||TotalBanana.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter the Quantity u need and Press = for total");
            alert.show();
        }else{
            try{
                statement=connection.prepareStatement("INSERT INTO add_to_cart (USERNAME,PRODUCTNAME,PRICE,QUANTITY,TOTAL) VALUES (?,?,?,?,?);");
                statement.setString(1,UsernameFruits.getText());
                statement.setString(2,BananaN.getText());
                statement.setString(3,BananaP.getText());
                statement.setString(4,BananaQ.getText());
                statement.setString(5,TotalBanana.getText());
                statement.execute();
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Product Add to cart");
                alert.show();

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void CBanana(){
        int result=Integer.valueOf(BananaP.getText())*Integer.valueOf(BananaQ.getText());
        TotalBanana.setText(String.valueOf(result));
    }

    public void PinAddBut(ActionEvent event) throws SQLException{
        if (PinQ.getText().isEmpty()||TotalPin.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter the Quantity u need and Press = for total");
            alert.show();
        }else{
            try{
                statement=connection.prepareStatement("INSERT INTO add_to_cart (USERNAME,PRODUCTNAME,PRICE,QUANTITY,TOTAL) VALUES (?,?,?,?,?);");
                statement.setString(1,UsernameFruits.getText());
                statement.setString(2,PinappleN.getText());
                statement.setString(3,PinP.getText());
                statement.setString(4,PinQ.getText());
                statement.setString(5,TotalPin.getText());
                statement.execute();
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Product Add to cart");
                alert.show();

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void CPin(){
        int result=Integer.valueOf(PinP.getText())*Integer.valueOf(PinQ.getText());
        TotalPin.setText(String.valueOf(result));
    }
//    -----------------------------------------------------------------------------------------------------------
//    -----------------------------------------------------------------------------------------------------------
//                                               Product Milk
public void BackMilk(ActionEvent event)throws IOException{
    //  coming back to homePage - button
    String username= MilkUsername.getText();
    FXMLLoader loader=new FXMLLoader(getClass().getResource("HomePage.fxml"));
    root=loader.load();
    HomePage homePage=loader.getController();
    homePage.hello(username);
//        root= FXMLLoader.load(getClass().getResource("HomePage.fxml"));
    stage=((Stage)((Node) event.getSource()).getScene().getWindow());
    scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
}
//------------------------------------------------------------------------------------------------------------------
    public void Milk(ActionEvent event) throws SQLException{
        if (MilkQ.getText().isEmpty()||TotalMilk.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter the Quantity u need and Press = for total");
            alert.show();
        }else{
            try{
                statement=connection.prepareStatement("INSERT INTO add_to_cart (USERNAME,PRODUCTNAME,PRICE,QUANTITY,TOTAL) VALUES (?,?,?,?,?);");
                statement.setString(1,MilkUsername.getText());
                statement.setString(2,MilkN.getText());
                statement.setString(3,MilkP.getText());
                statement.setString(4,MilkQ.getText());
                statement.setString(5,TotalMilk.getText());
                statement.execute();
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Product Add to cart");
                alert.show();

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void CMilk(){
        int result=Integer.valueOf(MilkP.getText())*Integer.valueOf(MilkQ.getText());
        TotalMilk.setText(String.valueOf(result));
    }
//------------------------------------------------------------------------------------------------------------

    public void Chz(ActionEvent event) throws SQLException{
        if (ChzQ.getText().isEmpty()||TotalChz.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter the Quantity u need and Press = for total");
            alert.show();
        }else{
            try{
                statement=connection.prepareStatement("INSERT INTO add_to_cart (USERNAME,PRODUCTNAME,PRICE,QUANTITY,TOTAL) VALUES (?,?,?,?,?);");
                statement.setString(1,MilkUsername.getText());
                statement.setString(2,ChzN.getText());
                statement.setString(3,ChzP.getText());
                statement.setString(4,ChzQ.getText());
                statement.setString(5,TotalChz.getText());
                statement.execute();
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Product Add to cart");
                alert.show();

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void CChz(){
        int result=Integer.valueOf(ChzP.getText())*Integer.valueOf(ChzQ.getText());
        TotalChz.setText(String.valueOf(result));
    }
//    ---------------------------------------------------------------------------------------------------------
    public void Butter(ActionEvent event) throws SQLException{
        if (ButterQ.getText().isEmpty()||TotalButter.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter the Quantity u need and Press = for total");
            alert.show();
        }else{
            try{
                statement=connection.prepareStatement("INSERT INTO add_to_cart (USERNAME,PRODUCTNAME,PRICE,QUANTITY,TOTAL) VALUES (?,?,?,?,?);");
                statement.setString(1,MilkUsername.getText());
                statement.setString(2,ButterN.getText());
                statement.setString(3,ButterP.getText());
                statement.setString(4,ButterQ.getText());
                statement.setString(5,TotalButter.getText());
                statement.execute();
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Product Add to cart");
                alert.show();

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void CButter(){
        int result=Integer.valueOf(ButterP.getText())*Integer.valueOf(ButterQ.getText());
        TotalButter.setText(String.valueOf(result));
    }

//    -----------------------------------------------------------------------------------------------------------
//    -----------------------------------------------------------------------------------------------------------
//                                               Product Oil
public void BackOil(ActionEvent event)throws IOException{
    //  coming back to homePage - button
        String username= OilUsername.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("HomePage.fxml"));
        root=loader.load();
        HomePage homePage=loader.getController();
        homePage.hello(username);
//        root= FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage=((Stage)((Node) event.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
}

}
















