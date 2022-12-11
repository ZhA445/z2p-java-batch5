package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.Author;
import com.mmit.model.Book;
import com.mmit.model.Category;
import com.mmit.model.DatabaseHandler;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BookEdit implements Initializable{

	 @FXML
	    private ComboBox<String> cbo_author;

	    @FXML
	    private ComboBox<String> cbo_category;

	    @FXML
	    private TextField txt_code;

	    @FXML
	    private TextField txt_price;

	    @FXML
	    private DatePicker txt_publish_date;

	    @FXML
	    private TextField txt_search_code;

	    @FXML
	    private TextField txt_title;

	    private List<Category> categoryList;
	    private List<Author> authorList;
	    private Book book = new Book();
	    @FXML
	    void btn_back_click(ActionEvent event) throws IOException {
	    	Start.changeScene("view/Books.fxml");
	    }

	    @FXML
	    void btn_delete_click(ActionEvent event) {
	    	try {
	    		var code = txt_code.getText();
		    	Optional<ButtonType> result = Start.showAlert(AlertType.CONFIRMATION, "Are you sure to delete?");
		    	if(result.get() == ButtonType.OK) {
		    		DatabaseHandler.deleteBookById(Integer.parseInt(code));
		    		Start.showAlert(AlertType.INFORMATION, "Delete Success");
		    		txt_code.setText("");
		    		txt_title.setText("");
		    		txt_price.setText("");
		    		txt_publish_date.setValue(null);
		    		cbo_author.getSelectionModel().clearSelection();
		    		cbo_category.getSelectionModel().clearSelection();
		    		
		    	}
			} catch (Exception e) {
				Start.showAlert(AlertType.ERROR, e.getMessage());
			}
	    }

	    @FXML
	    void btn_edit_click(ActionEvent event) throws Exception {
	    	try {
	    		book.setPrice(Float.parseFloat(txt_price.getText()));
		    	book.setTitle(txt_title.getText());
		    	book.setPublish_date(txt_publish_date.getValue());
		    	
		    	var selected_author_index = cbo_author.getSelectionModel().getSelectedIndex();
		    	var selected_category_index= cbo_category.getSelectionModel().getSelectedIndex();
		    	
		    	book.setAuthor(authorList.get(selected_author_index));
		    	book.setCategory(categoryList.get(selected_category_index));
		    	
		    	DatabaseHandler.updateBook(book);
		    	
		    	Start.showAlert(AlertType.INFORMATION, "Update Success");
			} catch (Exception e) {
				Start.showAlert(AlertType.ERROR, e.getMessage());
			}
	    }

	    @FXML
	    void btn_logout_click(ActionEvent event) {
	    	System.exit(0);
	    }

	    @FXML
	    void btn_reset_click(ActionEvent event) {

	    }

	    @FXML
	    void search_click(MouseEvent event) {
	    	var code = txt_search_code.getText();
	    	if(code.isEmpty()) {
	    		Start.showAlert(AlertType.ERROR, "Enter book code");
	    		return;
	    	}
	    	
	    	book = DatabaseHandler.findBookById(Integer.parseInt(code));
	    	if(book == null) {
	    		Start.showAlert(AlertType.WARNING, "No Book with Code: " + code);
	    	}
	    	else {
	    		txt_price.setText(String.valueOf(book.getPrice()));
	    		txt_publish_date.setValue(book.getPublish_date());
	    		txt_title.setText(book.getTitle());
	    		txt_code.setText(String.valueOf(book.getCode()));
	    		cbo_author.getSelectionModel().select(book.getAuthorName());
	    		cbo_category.getSelectionModel().select(book.getCategoryName());
	    	}
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			categoryList = DatabaseHandler.findAllCategory();
			authorList = DatabaseHandler.findAllAuthors();
			
			List<String> categoryName = categoryList.stream()
													.map(obj -> obj.getName())
													.toList();
			List<String> authorName = authorList.stream()
												.map(obj -> obj.getName())
												.toList();
			
			cbo_author.setItems(FXCollections.observableArrayList(authorName));
			cbo_category.setItems(FXCollections.observableArrayList(categoryName));
			
		}
}
