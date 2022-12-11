package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.Book;
import com.mmit.model.DatabaseHandler;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookList implements Initializable {

	@FXML
    private TableColumn<Book, String> col_author;

    @FXML
    private TableColumn<Book, String> col_category;

    @FXML
    private TableColumn<Book,String> col_created_by;

    @FXML
    private TableColumn<Book, Integer> col_id;

    @FXML
    private TableColumn<Book, Float> col_price;

    @FXML
    private TableColumn<Book,String > col_title;

    @FXML
    private TableView<Book> tbl_book;

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/Books.fxml");
    }

    @FXML
    void btn_logout_click(ActionEvent event) {
    	System.exit(0);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		col_id.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		col_created_by.setCellValueFactory(new PropertyValueFactory<>("entryBy"));
		col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
		col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
		
		List<Book> list = DatabaseHandler.findAllBooks();
		
		tbl_book.setItems(FXCollections.observableArrayList(list));
	}
}
