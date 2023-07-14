module com.example.tracnghiem {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.tracnghiem to javafx.fxml;
    exports com.example.tracnghiem;
}