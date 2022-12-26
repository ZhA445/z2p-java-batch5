package base.controller;

import java.io.IOException;

import base.Base;
import base.model.Author;
import base.model.DatabaseHandler;
import base.model.librarian;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class SignUp {
	
	 @FXML
	    private TextField txt_email;

	    @FXML
	    private TextField txt_nrc;

	    @FXML
	    private PasswordField txt_password;

	    @FXML
	    private TextField txt_phone;

	    @FXML
	    void btn_reset_click(ActionEvent event) {
	    	txt_email.setText("");
	    	txt_password.setText("");
	    	txt_nrc.setText("");
	    	txt_phone.setText("");
	    }

	    @FXML
	    void btn_signup_click(ActionEvent event) {
	    	try {
	    		//get data from input
		    	var email = txt_email.getText();
		    	var password = txt_password.getText();
		    	var nrc = txt_nrc.getText();
		    	var phone = txt_phone.getText();
		    			
		    	//create new librarian obj
		    	var libra  = new librarian();
		    	libra.setEmail(email);
		    	libra.setPassword(password);
		    	libra.setNrc(nrc);
		    	libra.setPhone(phone);
		    			
		    	//save to db
		    	DatabaseHandler.signupLibrarian(libra);
		    	Base.showAlert(AlertType.INFORMATION, "Success");
		    	
		    	//clear old data
		    	txt_email.setText(null);
		    	txt_password.setText(null);
		    	txt_nrc.setText(null);
		    	txt_phone.setText(null);
			} catch (Exception e) {
				Base.showAlert(AlertType.ERROR, e.getMessage());
			}
	    }

		@FXML
	    void lbl_login_click(MouseEvent event) throws IOException {
	    	Base.changeScene("view/Login.fxml");
	    }
}
