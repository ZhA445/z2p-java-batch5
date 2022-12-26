package base.controller;

import java.io.IOException;
import java.util.Optional;

import base.Base;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class Member {

	  @FXML
	    void btn_back_click(ActionEvent event) throws IOException {
		  Base.changeScene("view/Main.fxml");
	    }

	    @FXML
	    void btn_logout_click(ActionEvent event) {
	    	Optional<ButtonType> result = Base.showAlert(AlertType.CONFIRMATION, "Are you sure to exit?");
	    	if(result.get() == ButtonType.OK) {
	    		System.exit(0);
	    	}
	    }

	    @FXML
	    void btn_register_click(ActionEvent event) throws IOException {
	    	Base.changeScene("view/MemberRegister.fxml");
	    }

	    @FXML
	    void btn_search_click(ActionEvent event) throws IOException {
	    	Base.changeScene("view/MemberSearch.fxml");
	    }

	    @FXML
	    void btn_edit_click(ActionEvent event) throws IOException {
	    	Base.changeScene("view/MemberEdit.fxml");
	    }

	    @FXML
	    void btn_view_click(ActionEvent event) throws IOException {
	    	Base.changeScene("view/MemberView.fxml");
	    }

}
