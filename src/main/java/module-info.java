module com.example.loginpagedemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens com.example.loginpagedemo to javafx.fxml;
    exports com.example.loginpagedemo;
}