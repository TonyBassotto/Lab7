package it.polito.tdp.dizionario.controller;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loadX=new FXMLLoader(getClass().getResource("Dizionario.fxml"));
			BorderPane root=(BorderPane)loadX.load();
			//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Dizionario.fxml"));
			Scene scene = new Scene(root,primaryStage.getHeight(),primaryStage.getWidth());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			primaryStage.setTitle("Dizionario con Grafo");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
