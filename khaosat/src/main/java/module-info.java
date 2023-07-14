module com.example.khaosat {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.khaosat to javafx.fxml;
    exports com.example.khaosat;
}