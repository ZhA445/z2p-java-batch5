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

public class MemberRegister implements Initializable {

	@FXML
	private TextField txt_acyear;

	@FXML
	private TextField txt_name;

	@FXML
	private TextField txt_rno;

	@FXML
	private ComboBox<String> cbo_year;

	List<MemberCategory> MemberList;

	@FXML
	void btn_back_click(ActionEvent event) throws IOException {
		Base.changeScene("view/Member.fxml");
	}

	@FXML
	void btn_logout_click(ActionEvent event) {
		Optional<ButtonType> result = Base.showAlert(AlertType.CONFIRMATION, "Are you sure to exit?");

		if (result.get() == ButtonType.OK) {
			System.exit(0);
		}

	}

	@FXML
	void btn_register_click(ActionEvent event) {
		try {
			var name = txt_name.getText();
			var rno = txt_rno.getText();
			var acyear = txt_acyear.getText();
			int categoryYear_select_index = cbo_year.getSelectionModel().getSelectedIndex();
			MemberCategory select_category = MemberList.get(categoryYear_select_index);
			
			var member = new Member();
			member.setName(name);;
			member.setRno(Integer.parseInt(rno));
			member.setAcyear(acyear);
			member.setYear(select_category);
			
			//save to data
			DatabaseHandler.MemberRegister(member);
			
			//show alert success
			Base.showAlert(AlertType.INFORMATION, "Success");
			
			//reset data
			reset();
		} catch (Exception e) {
			Base.showAlert(AlertType.ERROR, e.getMessage());
		}
	}

	private void reset() {
		txt_name.setText("");
		txt_rno.setText("");
		txt_acyear.setText("");
		cbo_year.getSelectionModel().clearSelection();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// member category list
		MemberList = DatabaseHandler.findAllMemberCategory();

		List<String> memCategoryList = MemberList.stream()
												.map(obj -> obj.getStdYear())
												.toList();

		cbo_year.setItems(FXCollections.observableArrayList(memCategoryList));
	}
}
