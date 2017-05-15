package be.ac.ulb.infof307.g07.views;

import java.io.IOException;

import be.ac.ulb.infof307.g07.controllers.PokeMarkerOptionsController;
import be.ac.ulb.infof307.g07.models.PokeMarker;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class PokeMarkerOptionsView {

	private static PokeMarkerOptionsView instance = null;
	private PokeMarker concernedPokeMarker = null;
	private String[] buttonMenuFile = {"views/Edit.fxml","views/Delete.fxml","views/Facebook.fxml","views/Google.fxml","views/Twitter.fxml"};
	private Button[] buttonMenuViews = new Button[buttonMenuFile.length];
	
	public static PokeMarkerOptionsView getInstance(){
		if( instance == null ){
			instance = new PokeMarkerOptionsView();
			instance.loadView();
		}
		return instance;
	}
	
	public Button[] getView(){
		
		return buttonMenuViews;
	}
	
	public void loadView(){
		try {
			PokeMarkerOptionsController controller = new PokeMarkerOptionsController();
			for( int i = 0; i <buttonMenuFile.length; ++i ){
				System.out.println("Loading :"+buttonMenuFile[i]);
				FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(buttonMenuFile[i]));
				loader.setController(controller);
				buttonMenuViews[i] = loader.load();
			}
			
		} catch (IOException except) {
			except.printStackTrace();
		}
	}
	
	public void setPokeMarker(PokeMarker pokeMarker){
		concernedPokeMarker = pokeMarker;
	}
	
	public void showView(){
		double[][] positions= MapView.getInstance().calcMenuPosition(buttonMenuViews.length);
		for(int i=0;i<buttonMenuViews.length;++i){
			buttonMenuViews[i].setLayoutX(positions[i][0]-buttonMenuViews[i].getWidth()/2);
			buttonMenuViews[i].setLayoutY(positions[i][1]-buttonMenuViews[i].getHeight()/2);
			buttonMenuViews[i].setVisible(true);
			System.out.println(positions[i][0]);
			System.out.println(positions[i][1]);
		}
	}
	
	public void closeView(){
		for(int i=0;i<buttonMenuViews.length;++i){
			buttonMenuViews[i].setVisible(false);
		}
	}
	
	
	public PokeMarker getConcernedPokeMarker(){
		return concernedPokeMarker;
	}
}
