package base.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import base.Base;
import base.model.Book;
import base.model.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;

public class BookList implements Initializable{

	@FXML
	private TableColumn<Book, Integer> col_code;

	@FXML
	private TableColumn<Book, String> col_author;

	@FXML
	private TableColumn<Book, String> col_category;

	@FXML
    private TableColumn<Book, LocalDate> col_publish;

	@FXML
	private TableColumn<Book, String> col_title;

	@FXML
	private TableView<Book> tbl_book;

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		col_code.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
		col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
		col_publish.setCellValueFactory(new PropertyValueFactory<>("publish"));
		
		List<Book> list = DatabaseHandler.findAllBook();
		
		tbl_book.setItems(FXCollections.observableArrayList(list));
	}
}
