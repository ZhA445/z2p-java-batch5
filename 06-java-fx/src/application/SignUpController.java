package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class SignUpController implements Initializable{

	 @FXML
	    private ComboBox<String> cbo_city;

	    @FXML
	    private CheckBox chk_java;

	    @FXML
	    private CheckBox chk_nodejs;

	    @FXML
	    private CheckBox chk_php;

	    @FXML
	    private ToggleGroup gender_group;

	    @FXML
	    private DatePicker txt_birthday;

	    @FXML
	    private TextField txt_email;

	    @FXML
	    private PasswordField txt_password;

	    @FXML
	    private PasswordField txt_repassword;

	    @FXML
	    private TextField txt_salary;

	    @FXML
	    private TextArea txtarea_address;

	    @FXML
	    void btn_reset_click(ActionEvent event) {

	    }

	    @FXML
	    void btn_signup_click(ActionEvent event) {

	    	String email = txt_email.getText();
	    	String pass = txt_password.getText();
	    	
	    	String city = cbo_city.getSelectionModel().getSelectedItem();
	    	int city_index = cbo_city.getSelectionModel().getSelectedIndex();
	    	 
	    	RadioButton gender =  (RadioButton) gender_group.getSelectedToggle();
	    	String gender_val = gender.getText();
	    	
	    	LocalDate birthday = txt_birthday.getValue();
	    	String address = txtarea_address.getText();
	    	int salary = Integer.parseInt(txt_salary.getText());
	    	
	    	String skillsets = "";
	    	if(chk_java.isSelected())
	    		skillsets = chk_java.getText() + ",";
	    	if(chk_php.isSelected())
	    		skillsets += chk_php.getText() + ",";
	    	if(chk_nodejs.isSelected())
	    		skillsets += chk_nodejs.getText() + ",";
	    	
	    	String output= "";
	    	output += "Email - " + email + "\n";
	    	output += "Password - " + pass + "\n";
	    	output += "City - " + city + "(index: " + city_index +")\n";
	    	output += "Gender - " + gender_val + "\n";
	    	output += "Birthday - " + birthday + "\n";
	    	output += "Salary  - " + salary + "\n";
	    	output += "Skillsets - " + skillsets.substring(0,skillsets.lastIndexOf(",")) + "\n";
	    	output += "Address - " + address + "\n";
	    	
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setHeaderText(null);
	    	alert.setTitle("Message");
	    	alert.setContentText(output);
	    	alert.showAndWait();
	    	
	    }

	    @FXML
	    void lbl_login_click(MouseEvent event) throws IOException {
	    	Main.changeScene("Login.fxml", "Login");
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			List<String> cities = List.of("Yangon" , "Mandalay" , "Myitkyina","Sagaing");
			
			cbo_city.setItems(FXCollections.observableArrayList(cities));
			
		}
}
