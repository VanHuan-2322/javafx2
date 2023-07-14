module com.example.th1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.th1 to javafx.fxml;
    exports com.example.th1;
}