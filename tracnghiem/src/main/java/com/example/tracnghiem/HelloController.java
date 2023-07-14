package com.example.tracnghiem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class HelloController {
    @FXML
    private RadioButton A1;

    @FXML
    private RadioButton B1;

    @FXML
    private RadioButton C1;

    @FXML
    private RadioButton D1;

    @FXML
    private RadioButton A2;

    @FXML
    private RadioButton B2;

    @FXML
    private RadioButton C2;

    @FXML
    private RadioButton D2;

    @FXML
    private Label diem;

    private ToggleGroup group1;
    private ToggleGroup group2;

    public void initialize() {
        // Tạo ToggleGroup cho mỗi câu hỏi để chỉ cho phép chọn một đáp án duy nhất
        group1 = new ToggleGroup();
        A1.setToggleGroup(group1);
        B1.setToggleGroup(group1);
        C1.setToggleGroup(group1);
        D1.setToggleGroup(group1);

        group2 = new ToggleGroup();
        A2.setToggleGroup(group2);
        B2.setToggleGroup(group2);
        C2.setToggleGroup(group2);
        D2.setToggleGroup(group2);
    }

    @FXML
    private void submitQuiz() {
        int score = calculateScore();
        diem.setText("Điểm của bạn là : " + score);
    }

    private int calculateScore() {
        int score = 0;

        // Kiểm tra đáp án câu hỏi 1
        RadioButton selectedOption1 = (RadioButton) group1.getSelectedToggle();
        if (selectedOption1 != null) {
            if (selectedOption1 == B1) {
                score++;
            }
        }

        // Kiểm tra đáp án câu hỏi 2
        RadioButton selectedOption2 = (RadioButton) group2.getSelectedToggle();
        if (selectedOption2 != null) {
            if (selectedOption2 == D2) {
                score++;
            }
        }

        return score;
    }
}