package base.controller;

import java.io.IOException;

import base.Base;
import base.model.Book;
import base.model.DatabaseHandler;
import base.model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class BookBorrow {

	@FXML
	private TextField txt_memberid;

	@FXML
	private TextField txt_code;

	@FXML
	void btn_back_click(ActionEvent event) throws IOException {
		Base.changeScene("view/Book.fxml");
	}

	@FXML
	void btn_next_click(ActionEvent event) throws IOException {
		try {
			var memid = Integer.parseInt(txt_memberid.getText());
			var bookcode = Integer.parseInt(txt_code.getText());

			Member member = DatabaseHandler.checkMemberIdtoBorrow(memid);
			if (member == null) {
				Base.showAlert(AlertType.ERROR, "Your Member Id is Expired! Renew now");
			} else {
				Book book =  DatabaseHandler.checkBookisAvailable(bookcode);
				
				if(book == null) {
					Base.showAlert(AlertType.ERROR, "This book can't available!");
				}
				else {
					Book obj =  DatabaseHandler.RentBook(memid,bookcode);
					
						Base.showAlert(AlertType.INFORMATION, "Success");
					
				}
			}
		} catch (Exception e) {
			Base.showAlert(AlertType.ERROR, e.getMessage());
		}
	}
}
