package be.ac.ulb.infof307.g07;

import com.lynden.gmapsfx.MapComponentInitializedListener;
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
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/Main.fxml"));
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
		
		mapView.initMap();
		PokedexView pV = PokedexView.getInstance();
		pV.loadView();
		mainPane.getChildren().add(pV.getView());
		StackPane.setAlignment(pV.getView(), Pos.TOP_RIGHT);
		pV.init();
		PokemonSelectionView pSView = PokemonSelectionView.getInstance();
		pSView.loadView();
		mainPane.getChildren().add(pSView.getView());
		mainStage.show();
	}
	
}
