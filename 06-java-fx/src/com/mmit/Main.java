package com.mmit;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//1. create layout
			Parent root = FXMLLoader.load(getClass().getResource("FirstUI.fxml"));
			//2. create sense
			Scene scene = new Scene(root,400,400);
			//3. add sense obj to stage 
			primaryStage.setScene(scene);
			//4. show stage
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
