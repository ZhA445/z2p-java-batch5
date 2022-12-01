package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	
	private static Stage orignalStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			//1. create layout(convert fxml to java obj)
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			//2. create sense
			Scene scene = new Scene(root);
			//3. add sense  obj to stage
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Login Form");
			
			orignalStage = primaryStage;
			//4. show stage
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changeScene(String input_file,String title) throws IOException {
		Parent root = FXMLLoader.load(Main.class.getResource(input_file));
		Scene new_scene  = new Scene(root);
		
		orignalStage.hide();
		orignalStage.setScene(new_scene);
		orignalStage.setTitle(title);
		orignalStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
