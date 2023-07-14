module com.example.th2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.th2 to javafx.fxml;
    exports com.example.th2;
}