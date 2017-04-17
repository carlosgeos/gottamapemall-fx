package be.ac.ulb.infof307.g07.Views;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.MouseEventHandler;

import be.ac.ulb.infof307.g07.PokemonViewListener;
import be.ac.ulb.infof307.g07.Models.Coordinate;
import be.ac.ulb.infof307.g07.Models.Map;
import be.ac.ulb.infof307.g07.Models.Pokemon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChoosePokemonView implements MouseEventHandler, PokemonViewListener, EventHandler<ActionEvent>{

	
	private Stage mainStage = new Stage();
	private double mainWidth = 300;
	private double mainHeight = 350;
	private Pokemon selectedPokemon = null;
	private MapView pokeMapView;
	private Map pokeMap;
	
	private Button submitButton;
	private TextField date;
	private TextField time;
	private Coordinate newPosition;
	
	private boolean isShown = false;
	
	public ChoosePokemonView( MapView newPokeMapView, Map newPokeMap ){
		
		this.pokeMapView = newPokeMapView;
		this.pokeMap = newPokeMap;
		
		createWindow();
		
	}
	
	public void close(){
		
		this.mainStage.close();
		this.isShown = false;
	}
	
	public void createWindow(){
		
		GridPane mainGridPane = new GridPane();
		
		mainGridPane.add(new Label("Date : "), 0, 0);
		mainGridPane.add(new Label("Time : "), 0, 1);
		mainGridPane.add(new Text("Pokemon\n(dbl click to select): "), 0, 2);
		
		
		this.date = new TextField();
		mainGridPane.add( this.date, 1, 0);
		DateFormat dateFormat = new  SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		this.date.setText(dateFormat.format(date));
		
		this.time = new TextField();
		mainGridPane.add( this.time, 1, 1);
		DateFormat timeFormat = new  SimpleDateFormat("HH:mm:ss");
		this.time.setText(timeFormat.format(date));
		
		PokedexView pokedex = new PokedexView(0, 0);
		ScrollPane newScrollPane = new ScrollPane();
		newScrollPane.setPrefWidth(200);
		newScrollPane.setPrefHeight(300);
		newScrollPane.setContent(pokedex.getPokedexView(this, 165, 30, new Insets(3,3,3,3), 25, 25, 3, 3));
		mainGridPane.add( newScrollPane, 1, 2);
		
		this.submitButton = new Button();
		this.submitButton.setText("OK");
		
		mainGridPane.add(this.submitButton, 1, 3);
		this.submitButton.setPrefWidth(200);
		mainGridPane.setVgap(5);
		mainGridPane.setHgap(5);
		mainGridPane.setPadding(new Insets(10,10,10,10));
		
		Scene mainScene = new Scene(mainGridPane, mainWidth, mainHeight);
		this.mainStage.setScene(mainScene);
		this.mainStage.setResizable(false);;
		this.mainStage.setTitle("Choose the pokemon");
		this.mainStage.setOnCloseRequest((event)->{ this.isShown = false; });
	}
	
	
	@Override
	public void handle(GMapMouseEvent event) {
		
		this.pokeMapView.refreshMap();
		if( !this.isShown ){
			
			
			this.mainStage.show();
			this.newPosition = new Coordinate(event.getLatLong().getLatitude(), event.getLatLong().getLongitude());
			this.submitButton.setOnAction(this);
			this.isShown = true;
		}
		
	}

	
	@Override
	public void handle(Pokemon pokemon, PokedexView pokedexView) {
		// Customized PokemonViewListener
		this.selectedPokemon = pokemon;
		
	}

	@Override
	public void handle(ActionEvent event) {
		
		this.pokeMap.addPokeMarker(this.newPosition, this.selectedPokemon, this.date.getText(), this.time.getText());
		// then add it in the view map
		pokeMapView.updateMarkers();
		
		this.mainStage.close();
		this.isShown = false;
	}

	
	
	
}
