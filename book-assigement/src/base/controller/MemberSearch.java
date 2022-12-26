package base.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import base.Base;
import base.model.DatabaseHandler;
import base.model.Member;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MemberSearch implements Initializable{

	@FXML
	private TableColumn<Member, String> col_acyear;

	@FXML
	private TableColumn<Member, LocalDate> col_created_at;

	@FXML
	private TableColumn<Member, LocalDate> col_expired_date;

	@FXML
	private TableColumn<Member, Integer> col_id;

	@FXML
	private TableColumn<Member, String> col_name;

	@FXML
	private TableColumn<Member, Integer> col_rno;

	@FXML
	private TableColumn<Member, String> col_year;

	@FXML
	private TableView<Member> tbl_member;

	@FXML
	private TextField txt_id;

	@FXML
	private TextField txt_name;

	@FXML
	void btn_back_click(ActionEvent event) throws IOException {
		Base.changeScene("view/Member.fxml");
	}

	@FXML
	void btn_logout_click(ActionEvent event) {
		Optional<ButtonType> result = Base.showAlert(AlertType.CONFIRMATION, "Are you sure to exit?");
    	if(result.get() == ButtonType.OK) {
    		System.exit(0);
    	}
	}

	@FXML
	void search_click(MouseEvent event) {
		var id = txt_id.getText();
		var name = txt_name.getText();
		
		List<Member> list = DatabaseHandler.searchMember(id,name);
		
		tbl_member.setItems(FXCollections.observableArrayList(list));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_rno.setCellValueFactory(new PropertyValueFactory<>("rno"));
		col_year.setCellValueFactory(new PropertyValueFactory<>("memberCat"));
		col_acyear.setCellValueFactory(new PropertyValueFactory<>("acyear"));
		col_created_at.setCellValueFactory(new PropertyValueFactory<>("created_at"));
		col_expired_date.setCellValueFactory(new PropertyValueFactory<>("expdate"));
	}

}
