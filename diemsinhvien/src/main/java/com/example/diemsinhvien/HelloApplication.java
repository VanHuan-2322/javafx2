package com.example.diemsinhvien;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class HelloApplication extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

            Scene scene = new Scene(root, 400, 300);

            primaryStage.setTitle("Quản lý điểm số sinh viên");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
