package base.controller;

import java.io.IOException;
import java.net.URL;
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

public class BookAdd implements Initializable {

	@FXML
	private ComboBox<String> cbo_author;

	@FXML
	private ComboBox<String> cbo_category;

	@FXML
	private TextField txt_code;

	@FXML
	private DatePicker txt_publish;

	@FXML
	private TextField txt_title;

	List<Author> authorList;
	List<BookCategory> categoryList;
	
	@FXML
	void btn_add_click(ActionEvent event) {
		try {
			var code = txt_code.getText();
			var title = txt_title.getText();
			var publish = txt_publish.getValue();
			
			var book = new Book();
			book.setCode(Integer.parseInt(code));
			book.setTitle(title);
			book.setPublish(publish);
			
			int author_select_index = cbo_author.getSelectionModel().getSelectedIndex();
			int bookcat_select_index = cbo_category.getSelectionModel().getSelectedIndex();
			
			Author select_author = authorList.get(author_select_index);
			BookCategory select_bookcat = categoryList.get(bookcat_select_index);
			
			book.setAuthor(select_author);
			book.setCategory(select_bookcat);
			
			//save to database
			DatabaseHandler.AddBook(book);
			
			Base.showAlert(AlertType.INFORMATION, "Success");
			
			reset();
		} catch (Exception e) {
			Base.showAlert(AlertType.ERROR, e.getMessage());
		}
	}

	@FXML
	void btn_back_click(ActionEvent event) throws IOException {
		Base.changeScene("view/Book.fxml");
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
		txt_publish.setValue(null);
		cbo_category.getSelectionModel().clearSelection();
		cbo_author.getSelectionModel().clearSelection();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		authorList = DatabaseHandler.findAllAuthor();
		
		List<String> authorNameList = authorList.stream()
												.map(obj -> obj.getName())
												.toList();
		cbo_author.setItems(FXCollections.observableArrayList(authorNameList));
		
		categoryList = DatabaseHandler.findAllBookCategory();
		
		List<String> categoryNameList = categoryList.stream()
													.map(obj -> obj.getName())
													.toList();
		cbo_category.setItems(FXCollections.observableArrayList(categoryNameList));
	}
}
