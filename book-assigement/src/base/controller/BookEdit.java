package base.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import base.Base;
import base.model.Author;
import base.model.Book;
import base.model.BookCategory;
import base.model.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class BookEdit implements Initializable {

	@FXML
	private ComboBox<String> cbo_author;

	@FXML
	private ComboBox<String> cbo_category;

	@FXML
	private TextField txt_code;

	@FXML
	private DatePicker txt_publish_date;

	@FXML
	private TextField txt_search_code;

	@FXML
	private TextField txt_title;

	private List<Author> authorList;
	private List<BookCategory> categoryList;
	private Book book = new Book();

	@FXML
	void btn_back_click(ActionEvent event) throws IOException {
		Base.changeScene("view/Book.fxml");
	}

	@FXML
	void btn_delete_click(ActionEvent event) {

	}

	@FXML
	void btn_logout_click(ActionEvent event) {
		Optional<ButtonType> result = Base.showAlert(AlertType.CONFIRMATION, "Are you sure to exit?");
		if (result.get() == ButtonType.OK) {
			System.exit(0);
		}
	}

	@FXML
	void btn_reset_click(ActionEvent event) {
		reset();
	}

	private void reset() {
		txt_code.setText("");
		txt_title.setText("");
		txt_publish_date.setValue(null);
		cbo_category.getSelectionModel().clearSelection();
		cbo_author.getSelectionModel().clearSelection();
	}

	@FXML
	void btn_save_click(ActionEvent event) {
		try {
			book.setTitle(txt_title.getText());
			book.setPublish(txt_publish_date.getValue());
			
			var select_author_index = cbo_author.getSelectionModel().getSelectedIndex();
			var select_bookcat_index = cbo_category.getSelectionModel().getSelectedIndex();
			
			book.setAuthor(authorList.get(select_author_index));
			book.setCategory(categoryList.get(select_bookcat_index));
			
			DatabaseHandler.UpdateBook(book);
			
			Base.showAlert(AlertType.INFORMATION, "Update Success");
			reset();
		} catch (Exception e) {
			Base.showAlert(AlertType.ERROR, e.getMessage());
		}
	}

	@FXML
	void search_click(MouseEvent event) {
		var code = txt_search_code.getText();
		if (code.isEmpty()) {
			Base.showAlert(AlertType.ERROR, "Enter Book Code");
			return;
		}

		book = DatabaseHandler.findBookByCode(Integer.parseInt(code));

		if (book == null) {
			Base.showAlert(AlertType.WARNING, "No Book with Code: " + code);
		} else {
			txt_code.setText(String.valueOf(book.getCode()));
			txt_title.setText(book.getTitle());
			txt_publish_date.setValue(book.getPublish());
			cbo_author.getSelectionModel().select(book.getAuthorName());
			cbo_category.getSelectionModel().select(book.getCategoryName());
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		authorList = DatabaseHandler.findAllAuthor();

		List<String> authorNameList = authorList.stream().map(obj -> obj.getName()).toList();
		cbo_author.setItems(FXCollections.observableArrayList(authorNameList));

		categoryList = DatabaseHandler.findAllBookCategory();

		List<String> categoryNameList = categoryList.stream().map(obj -> obj.getName()).toList();
		cbo_category.setItems(FXCollections.observableArrayList(categoryNameList));

	}
}
