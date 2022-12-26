package base.controller;

import java.io.IOException;

import base.Base;
import base.model.DatabaseHandler;
import base.model.librarian;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class Login {

	@FXML
	private TextField txt_email;

	@FXML
	private PasswordField txt_password;

	@FXML
	void btn_login_click(ActionEvent event) throws IOException {
		
		String email = txt_email.getText();
		String password = txt_password.getText();
		
		librarian obj = DatabaseHandler.login(email,password);
		
		if(obj == null) {
			Base.showAlert(AlertType.ERROR, "Your password is incorrect!");
		}
		else {
			Base.loginUser = obj;
			Base.changeScene("view/Main.fxml");
		}
	}

	@FXML
	void lbl_signup_click(MouseEvent event) throws IOException {
		Base.changeScene("view/SignUp.fxml");
	}
}
