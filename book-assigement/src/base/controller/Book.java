package base.controller;

import java.io.IOException;

import base.Base;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Book {

	@FXML
	void btn_add_click(ActionEvent event) throws IOException {
		Base.changeScene("view/BookAdd.fxml");
	}

	@FXML
	void btn_back_click(ActionEvent event) throws IOException {
		Base.changeScene("view/Main.fxml");
	}

	@FXML
	void btn_borrow_click(ActionEvent event) throws IOException {
		Base.changeScene("view/BookBorrow.fxml");
	}

	@FXML
	void btn_edit_click(ActionEvent event) throws IOException {
		Base.changeScene("view/BookEdit.fxml");
	}

	@FXML
	void btn_list_click(ActionEvent event) throws IOException {
		Base.changeScene("view/BookList.fxml");
	}

	@FXML
	void btn_return_click(ActionEvent event) throws IOException {
		Base.changeScene("view/BookReturn.fxml");
	}

	@FXML
	void btn_search_click(ActionEvent event) throws IOException {
		Base.changeScene("view/BookSearch.fxml");
	}
}
