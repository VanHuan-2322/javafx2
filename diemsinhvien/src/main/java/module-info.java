module com.example.diemsinhvien {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.diemsinhvien to javafx.fxml;
    exports com.example.diemsinhvien;
}