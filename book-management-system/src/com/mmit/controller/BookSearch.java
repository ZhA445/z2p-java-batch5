package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class BookSearch implements Initializable {

	@FXML
    private TableColumn<Book, String> col_author;

    @FXML
    private TableColumn<Book, String> col_category;

    @FXML
    private TableColumn<Book, Integer> col_id;

    @FXML
    private TableColumn<Book, Float> col_price;

    @FXML
    private TableColumn<Book, LocalDate> col_publish_date;

    @FXML
    private TableColumn<Book, String> col_title;

    @FXML
    private TableView<Book> tbl_book;

    @FXML
    private TextField txt_author;

    @FXML
    private TextField txt_category;

    @FXML
    private TextField txt_title;

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/Books.fxml");
    }

    @FXML
    void btn_logout_click(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void search_click(MouseEvent event) {
    	var category = txt_category.getText();
    	var author = txt_author.getText();
    	var title = txt_title.getText();
    	
    	List<Book> list = DatabaseHandler.searchBook(category, author, title);
    	
    	tbl_book.setItems(FXCollections.observableArrayList(list));
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		col_id.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		col_publish_date.setCellValueFactory(new PropertyValueFactory<>("publish_date"));
		col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
		col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
		
	}

}
