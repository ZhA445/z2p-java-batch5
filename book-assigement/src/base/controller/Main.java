package base.controller;

import java.io.IOException;
import java.util.Optional;

import base.Base;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class Main {
	 @FXML
	    void book_click(MouseEvent event) throws IOException {
		 Base.changeScene("view/Book.fxml");
	    }

	    @FXML
	    void btn_logout_click(ActionEvent event) {
	    	Optional<ButtonType> result = Base.showAlert(AlertType.CONFIRMATION, "Are you sure to exit?");
	    	if(result.get() == ButtonType.OK) {
	    		System.exit(0);
	    	}
	    }

	    @FXML
	    void librarian_click(MouseEvent event) throws IOException {
	    	Base.changeScene("view/Librarian.fxml");
	    }

	    @FXML
	    void member_click(MouseEvent event) throws IOException {
	    	Base.changeScene("view/Member.fxml");
	    }
}
