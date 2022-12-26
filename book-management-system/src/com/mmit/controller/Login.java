package com.mmit.controller;

import java.io.IOException;

import com.mmit.Start;
import com.mmit.model.DatabaseHandler;
import com.mmit.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Login {

	@FXML
	private TextField txt_password;

	@FXML
	private TextField txt_username;

	@FXML
	void btn_cancel_click(ActionEvent event) {
		txt_password.setText("");
		txt_username.setText("");
	}

	@FXML
	void btn_login_click(ActionEvent event) throws IOException {

		String user_name = txt_username.getText();
		String password = txt_password.getText();

		User obj = DatabaseHandler.login(user_name, password);

		if (obj == null) {
			Start.showAlert(AlertType.ERROR, "Your password is incorrect!");
		} else {// login success
			Start.loginUser = obj;
			Start.changeScene("view/Main.fxml");
		}
	}
}
