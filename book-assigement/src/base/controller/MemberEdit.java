 package base.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import base.Base;
import base.model.DatabaseHandler;
import base.model.Member;
import base.model.MemberCategory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class MemberEdit implements Initializable{

	@FXML
	private TextField txt_acyear;

	@FXML
	private TextField txt_id;

	@FXML
	private TextField txt_name;

	@FXML
	private TextField txt_rno;

	@FXML
	private TextField txt_search_id;

	@FXML
    private ComboBox<String> cbo_year;
	
	private	List<MemberCategory> catMemberList;
	private Member member = new Member();

	@FXML
	void btn_back_click(ActionEvent event) throws IOException {
		Base.changeScene("view/Member.fxml");
	}

	@FXML
	void btn_save_click(ActionEvent event) {
		try {
			//get data from search box
			member.setName(txt_name.getText());
			member.setRno(Integer.parseInt(txt_rno.getText()));
			member.setAcyear(txt_acyear.getText());
			//get index of member combo box
			var select_membercat_index = cbo_year.getSelectionModel().getSelectedIndex();
			
			member.setYear(catMemberList.get(select_membercat_index));
			
			DatabaseHandler.updateMember(member);
			
			Base.showAlert(AlertType.INFORMATION, "Update Success");
			reset();
			
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
	void btn_reset_click(ActionEvent event) {
		reset();
	}

	private void reset() {
		txt_id.setText("");
		txt_name.setText("");
		txt_rno.setText("");
		cbo_year.getSelectionModel().clearSelection();
		txt_acyear.setText("");
		
	}

	@FXML
	void search_click(MouseEvent event) {
		var id = txt_search_id.getText();
		if(id.isEmpty()) {
			Base.showAlert(AlertType.ERROR, "Enter Member Id");
			return;
		}
		
		member = DatabaseHandler.findMemberById(Integer.parseInt(id));
		if(member == null) {
			Base.showAlert(AlertType.WARNING,"Member id: "+ id + " is not exist" );
		}
		else {
			txt_id.setText(String.valueOf(member.getId()));
			txt_name.setText(member.getName());
			txt_rno.setText(String.valueOf(member.getRno()));
			cbo_year.getSelectionModel().select(member.getMemberCat());;
			txt_acyear.setText(String.valueOf(member.getAcyear()));
		}
		
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		catMemberList = DatabaseHandler.findAllMemberCategory();
		
		List<String> categoryName = catMemberList.stream()
												.map(obj -> obj.getStdYear())
												.toList();
		cbo_year.setItems(FXCollections.observableArrayList(categoryName));
		
	}
}
