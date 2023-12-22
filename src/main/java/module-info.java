module ShoppingApp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ShoppingApp to javafx.fxml;
    exports ShoppingApp;
}