package com.mmit.controller;

import java.io.IOException;

import com.mmit.Start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Book {

	@FXML
    void btn_add_click(ActionEvent event) throws IOException {
		Start.changeScene("view/BookAdd.fxml");
    }

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/Main.fxml");
    }

    @FXML
    void btn_delete_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/BookEdit.fxml");
    }

    @FXML
    void btn_edit_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/BookEdit.fxml");
    }

    @FXML
    void btn_list_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/BookList.fxml");
    }

    @FXML
    void btn_logout_click(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void btn_search_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/BookSearch.fxml");
    }

}
