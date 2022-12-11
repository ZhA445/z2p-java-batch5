package com.mmit.controller;

import java.io.IOException;
import java.util.Optional;

import com.mmit.Start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class Main {

	  @FXML
	    void author_click(MouseEvent event) throws IOException {
		  Start.changeScene("view/Authors.fxml");
	    }

	    @FXML
	    void book_click(MouseEvent event) throws IOException {
	    	Start.changeScene("view/Books.fxml");
	    }

	    @FXML
	    void btn_logout_click(ActionEvent event) {
	    	Optional<ButtonType> result = Start.showAlert(AlertType.CONFIRMATION, "Are you sure to logout!");
	    	
	    	if(result.get() == ButtonType.OK)
	    		System.exit(0);
	    }

	    @FXML
	    void category_click(MouseEvent event) throws IOException {
	    	Start.changeScene("view/Categories.fxml");
	    }

	    @FXML
	    void user_click(MouseEvent event) throws IOException {
	    	Start.changeScene("view/User.fxml");
	    }

}
