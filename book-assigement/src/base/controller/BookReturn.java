package base.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import base.Base;
import base.model.Book;
import base.model.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class BookReturn {

	@FXML
	private TextField txt_bookcode;

	@FXML
    private TextField txt_memberid;

	@FXML
	void btn_back_click(ActionEvent event) throws IOException {
		Base.changeScene("view/Book.fxml");
	}

	@FXML
	void btn_done_click(ActionEvent event) {
		try {
			var id = Integer.parseInt(txt_memberid.getText());
			var code = Integer.parseInt(txt_bookcode.getText());
			
			//Check Return date Before or Late
			Book book = DatabaseHandler.checkReturnDate(code);
			if(book == null) {
				//If Return is Late
				book = DatabaseHandler.checkLateReturnDate(code);
				if(book == null) {
					Base.showAlert(AlertType.ERROR, "Check your Id and Code");
				}
				else {
					//Count amount
					LocalDate date = DatabaseHandler.countRentamount(code);
					if(date == null) {
						Base.showAlert(AlertType.ERROR, "System Error");
					}
					else {
						//Checking Id and code
						book= DatabaseHandler.checkIdAndcode(id, code);
						if(book == null) {
							Base.showAlert(AlertType.ERROR, "Check your Id and Code");
						}
						else {
							//When Return is After
							DatabaseHandler.ReturnBook(code);
							LocalDate now = LocalDate.now();
							int days = now.compareTo(date);
							
							int amount = 3000 + (days * 200);
							String output = "";
							output += "Member id: " + id + "\n";
							output += "Book Code: " + code + "\n";
							output += "Total Amount : " + amount + " Ks";
							Base.showAlert(AlertType.INFORMATION, output);
						}
					}
				}
			}
			else {
				//Checking id and code
				book = DatabaseHandler.checkIdAndcode(id, code);
				if(book == null) {
					Base.showAlert(AlertType.ERROR, "Check your Id and Code");
				}
				else {
					//When Return is Before
					DatabaseHandler.ReturnBook(code);
					String output = "";
					output += "Member id: " + id + "\n";
					output += "Book Code: " + code + "\n";
					output += "Total Amount : " + 3000 + " Ks";
					Base.showAlert(AlertType.INFORMATION, output);
				}
			}
		} catch (Exception e) {
			Base.showAlert(AlertType.ERROR, e.getMessage());
		}
	}
}
