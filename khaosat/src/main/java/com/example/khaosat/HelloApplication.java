package com.example.khaosat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Tạo các thành phần giao diện
        Label question1Label = new Label("Câu hỏi 1:Bạn có thích động vật không ?");
        RadioButton option1Radio = new RadioButton("Phương án 1: Có ");
        RadioButton option2Radio = new RadioButton("Phương án 2: Không ");
        Label question2Label = new Label("Câu hỏi 2: Bạn là Nam hay Nữ ?");
        RadioButton option3Radio = new RadioButton("Phương án 1: Nam ");
        RadioButton option4Radio = new RadioButton("Phương án 2: Nữ ");
        Button submitButton = new Button("Gửi");

        // Xử lý sự kiện nút Gửi
        submitButton.setOnAction(event -> {
            // Lưu thông tin khảo sát vào tệp tin
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
                writer.write("Câu hỏi 1: Bạn có thích động vật không ? ");
                writer.write((option1Radio.isSelected() ? "Phương án 1: Có" : "Phương án 2: Không"));
                writer.newLine();
                writer.write("Câu hỏi 2: Bạn là Nam hay Nữ ? ");
                writer.write((option3Radio.isSelected() ? "Phương án 1: Nam " : "Phương án 2: Nữ "));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Thông báo thành công
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Khảo sát đã được gửi thành công!");
            alert.showAndWait();
        });

        // Tạo nhóm để chỉ chọn một phương án trong mỗi câu hỏi
        ToggleGroup group1 = new ToggleGroup();
        option1Radio.setToggleGroup(group1);
        option2Radio.setToggleGroup(group1);

        ToggleGroup group2 = new ToggleGroup();
        option3Radio.setToggleGroup(group2);
        option4Radio.setToggleGroup(group2);

        // Tạo layout và thêm các thành phần vào layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(question1Label, 0, 0);
        gridPane.add(option1Radio, 0, 1);
        gridPane.add(option2Radio, 1, 1);
        gridPane.add(question2Label, 0, 2);
        gridPane.add(option3Radio, 0, 3);
        gridPane.add(option4Radio, 1, 3);
        gridPane.add(submitButton, 0, 4, 2, 1);

        // Tạo scene và hiển thị ứng dụng
        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setTitle("Ứng dụng khảo sát");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}