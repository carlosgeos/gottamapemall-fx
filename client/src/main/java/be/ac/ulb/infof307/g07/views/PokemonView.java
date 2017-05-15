package be.ac.ulb.infof307.g07.views;

import java.util.ArrayList;

import be.ac.ulb.infof307.g07.PokemonListener;
import be.ac.ulb.infof307.g07.PokemonViewListener;
import be.ac.ulb.infof307.g07.controllers.PokemonController;
import be.ac.ulb.infof307.g07.models.Pokemon;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class PokemonView implements PokemonListener{
	
	private GridPane mainPane;
	private Pane pokemonImagePane;
	private Label pokemonName;
	private Label pokemonId;
	private Label pokemonSignalisation;
	private Pokemon pokemon;
	private ArrayList<PokemonViewListener> listener = new ArrayList<PokemonViewListener>();
	private String holdGridStyle;
	
	public static PokemonView selectedPokemonView = null;
	public final static String defaultGridStyle = "-fx-border: 1px;-fx-border-color:#EBEBEB; -fx-border-style:solid;";
    public final static String hoverGridStyle = "-fx-border: 1px;-fx-border-color:#75B1FF; -fx-border-style:solid;";
    public final static String selectGridStyle = "-fx-border: 1px;-fx-border-color:#00ff00; -fx-border-style:solid;";
	
	public PokemonView( Pokemon newPokemon ){
		pokemon = newPokemon;	
	}
	
	public void loadView(){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/Pokemon.fxml"));
			PokemonController newPokemonController = new PokemonController(this);
			loader.setController(newPokemonController);
			mainPane = loader.load();
			onHoverStyle();
		} catch (Exception except) {
			except.printStackTrace();
		}
	}
	
	public void onClickStyle(MouseEvent event){
		if(PokemonView.selectedPokemonView != null){
			mainPane.setStyle(defaultGridStyle);
		}

		mainPane.setStyle(selectGridStyle);
		holdGridStyle = selectGridStyle;
		PokemonView.selectedPokemonView = this;
	}
	
	private void onHoverStyle(){
		mainPane.setOnMouseEntered(mouseEvent -> {
            holdGridStyle = mainPane.getStyle();
            mainPane.setStyle(hoverGridStyle); });
		mainPane.setOnMouseExited(mouseEvent -> { 
			mainPane.setStyle(holdGridStyle); 
		});
	}
	
	public void setFields( Pane imageContainer, Label nameLabel, Label idLabel, Label signalLabel){
		pokemonImagePane = imageContainer;
		pokemonName = nameLabel;
		pokemonId = idLabel;
		pokemonSignalisation = signalLabel;
	}
	
	public void setPokemonDataInView(){
		System.out.println("Setting pokemon data...");
		pokemonName.setText(pokemon.getName());
		Image pokemonImage = new Image(this.pokemon.getId() + ".gif", pokemonImagePane.getWidth(), pokemonImagePane.getHeight(), true, true);
	    ImageView pokemonImageView = new ImageView(pokemonImage);
	    pokemonImagePane.getChildren().add(pokemonImageView);
	    pokemonId.setText(Integer.toString(pokemon.getId()));
	    pokemonSignalisation.setText(Integer.toString(pokemon.getSignalisationCount()));
		System.out.println("Finish setting pokemon data...");
	}
	
	public GridPane getView(){
		return mainPane;
	}
	
	public Pokemon getPokemon(){
		return pokemon;
	}

	@Override
	public void onChangeSignalisation() {
		pokemonSignalisation.setText(Integer.toString(pokemon.getSignalisationCount()));
	}
	
	public void onSelected(){
		for(PokemonViewListener l:listener){
			l.onSelect(pokemon);
		}
	}
	
	public void addListener(PokemonViewListener newListener){
		listener.add(newListener);
	}
}
