package be.ac.ulb.infof307.g07;

import java.io.IOException;

import com.lynden.gmapsfx.MapComponentInitializedListener;

import be.ac.ulb.infof307.g07.controllers.PokedexController;
import be.ac.ulb.infof307.g07.models.Map;
import be.ac.ulb.infof307.g07.views.MapView;
import be.ac.ulb.infof307.g07.views.PokedexView;
import be.ac.ulb.infof307.g07.views.PokemonSelectionView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application implements MapComponentInitializedListener{
	
	private Stage mainStage;
	private StackPane mainPane;
	private MapView mapView;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try{
			mainStage = primaryStage;
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/Main.fxml"));
			loader.setController(new MainController());
			mainPane = loader.load();
			Scene mainScene = new Scene(mainPane);
			primaryStage.setScene(mainScene);
			mapView = new MapView(this);
			mainPane.getChildren().add(0, mapView.getView());
		}catch (Exception error){
			
			
		}
	}
	
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void mapInitialized() {
		
		Map.getInstance(mapView.createMap());
		PokedexView pV = PokedexView.getInstance();
		pV.loadView();
		mainStage.heightProperty().addListener((obs, oldVal, newVal)->{
			System.out.println("Resizing window");
			pV.setHeight(newVal.doubleValue());
		});
		
		mainPane.getChildren().add(pV.getView());
		
		StackPane.setAlignment(pV.getView(), Pos.TOP_RIGHT);
		pV.init();
		System.out.println("Finish loading PokedexView");
		PokemonSelectionView pSView = PokemonSelectionView.getInstance();
		pSView.loadView();
		System.out.println("Finish loading Selection");
		mainPane.getChildren().add(pSView.getView());
		System.out.println("Finish all");
		mainStage.show();
	}
	
}
