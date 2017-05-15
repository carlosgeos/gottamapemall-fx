package be.ac.ulb.infof307.g07.views;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Filter {

	private static Filter instance = null;
	private Pane mainPane;
	
	public Filter getInstance(){
		
		if(instance == null){
			instance = new Filter();
		}
		
		return instance;
	}
	
	public void loadView(){
		
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/Filt.fxml"));
		try {
			mainPane = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Pane getView(){
		return mainPane;
	}
	
}
