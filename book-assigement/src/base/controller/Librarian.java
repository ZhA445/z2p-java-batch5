package base.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import base.Base;
import base.model.DatabaseHandler;
import base.model.librarian;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;

public class Librarian implements Initializable {

	@FXML
    private TableColumn<librarian, String> col_email;

    @FXML
    private TableColumn<librarian, Integer> col_id;

    @FXML
    private TableColumn<librarian, String> col_nrc;

    @FXML
    private TableColumn<librarian, String> col_phone;
    
    @FXML
    private TableColumn<librarian, LocalDate> col_created_at;

    @FXML
    private TableView<librarian> tbl_librarians;

    librarian selected = new librarian();
    @FXML
    void btn_delete_click(ActionEvent event) {
    	try {
    		Optional<ButtonType> result = Base.showAlert(AlertType.CONFIRMATION, "Are you sure to delete?");
        	if(result.get() == ButtonType.OK) {
        		selected = tbl_librarians.getSelectionModel().getSelectedItem();
        		DatabaseHandler.deleteLibrarianById(selected.getId());
        		loadlibrarian();
        	}
		} catch (Exception e) {
			Base.showAlert(AlertType.ERROR, e.getMessage());
		}
    }

    @FXML
    void btn_logout_click(ActionEvent event) {
    	Optional<ButtonType> result = Base.showAlert(AlertType.CONFIRMATION, "Are you sure to exit?");
    	
    	if(result.get() == ButtonType.OK) {
    		System.exit(0);
    	}
    }
    
    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	Base.changeScene("view/Main.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));//getid
		col_email.setCellValueFactory(new PropertyValueFactory<>("email"));//getemail
		col_nrc.setCellValueFactory(new PropertyValueFactory<>("nrc"));
		col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		col_created_at.setCellValueFactory(new PropertyValueFactory<>("created_at"));
		
		loadlibrarian();
	}

	private void loadlibrarian() {
		List<librarian> list = DatabaseHandler.findAllLibrarian();
		//set data to table
		tbl_librarians.setItems(FXCollections.observableArrayList(list));
		
	}

}
