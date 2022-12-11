package com.mmit;
	
import java.io.IOException;
import java.util.Optional;

import com.mmit.model.User;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Start extends Application {
	
	private static Stage orignalStage;
	
	public static User loginUser = null;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			orignalStage = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
			
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Book Management System");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changeScene(String input_file) throws IOException {
		Parent root = FXMLLoader.load(Start.class.getResource(input_file));
		Scene scene = new Scene(root);
		
		orignalStage.hide();
		orignalStage.setScene(scene);
		orignalStage.show();
	}
	
	public static Optional<ButtonType> showAlert(AlertType type, String message){
		Alert alert = new Alert(type);
		alert.setContentText(message);
		alert.setHeaderText(null);
		alert.setTitle("Message");
		
		return alert.showAndWait();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
