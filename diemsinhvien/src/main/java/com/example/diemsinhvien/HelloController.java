package com.example.diemsinhvien;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField classTextField;
    @FXML
    private TextField genderTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField scoreTextField;
    @FXML
    private Label resultLabel;

    private List<SinhVien> sinhVienList;

    public HelloController() {
        sinhVienList = new ArrayList<>();
    }

    @FXML
    private void addButtonClicked() {
        int id = Integer.parseInt(idTextField.getText());
        String name = nameTextField.getText();
        String className = classTextField.getText();
        String gender = genderTextField.getText();
        String address = addressTextField.getText();
        double score = Double.parseDouble(scoreTextField.getText());

        SinhVien sinhVien = new SinhVien(id, name, className, gender, address, score);
        sinhVienList.add(sinhVien);

        // Hiển thị thông tin sinh viên
        String resultText = "ID: " + id + "\nName: " + name + "\nClass: " + className +
                "\nGender: " + gender + "\nAddress: " + address + "\nScore: " + score;
        resultLabel.setText(resultText);
    }

    @FXML
    private void updateButtonClicked() {
        int id = Integer.parseInt(idTextField.getText());

        // Tìm sinh viên trong danh sách dựa vào ID
        for (SinhVien sinhVien : sinhVienList) {
            if (sinhVien.getId() == id) {
                String name = nameTextField.getText();
                String className = classTextField.getText();
                String gender = genderTextField.getText();
                String address = addressTextField.getText();
                double score = Double.parseDouble(scoreTextField.getText());

                sinhVien.setName(name);
                sinhVien.setClassName(className);
                sinhVien.setGender(gender);
                sinhVien.setAddress(address);
                sinhVien.setScore(score);

                // Hiển thị thông tin sinh viên
                String resultText = "ID: " + id + "\nName: " + name + "\nClass: " + className +
                        "\nGender: " + gender + "\nAddress: " + address + "\nScore: " + score;
                resultLabel.setText(resultText);

                return;
            }
        }

        resultLabel.setText("Sinh viên không tồn tại");
    }

    @FXML
    private void deleteButtonClicked() {
        int id = Integer.parseInt(idTextField.getText());

        // Xóa sinh viên khỏi danh sách dựa vào ID
        for (SinhVien sinhVien : sinhVienList) {
            if (sinhVien.getId() == id) {
                sinhVienList.remove(sinhVien);

                // Xóa thông tin sinh viên khỏi giao diện
                idTextField.clear();
                nameTextField.clear();
                classTextField.clear();
                genderTextField.clear();
                addressTextField.clear();
                scoreTextField.clear();
                resultLabel.setText("Sinh viên đã được xóa");

                return;
            }
        }

        resultLabel.setText("Sinh viên không tồn tại");
    }
}
