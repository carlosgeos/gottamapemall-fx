package be.ac.ulb.infof307.g07.Views;


import be.ac.ulb.infof307.g07.PokemonViewListener;
import be.ac.ulb.infof307.g07.Controllers.Handlers.ClosePokemonDetailWindowHandler;
import be.ac.ulb.infof307.g07.Controllers.Handlers.PokemonViewDblClickHandler;
import be.ac.ulb.infof307.g07.Models.Pokemon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Fan et Renato
 *
 */

public class PokedexView{
	
	// stock real pokemon
	private ObservableList<Pokemon> pokemonInPokedex;

	private double pokedexViewWidth = 0;
	

	private double pokemonIconWidth = 45;
	private double pokemonIconHeight = 45;


	private BorderPane pokedexBorderPane;
	private BorderPane pokemonDetailBorderPane;
	private StackPane pokedexStackPane;
	private ScrollPane pokedexScrollPane;


	// used for detail info window
	private TextField pokemonNameTextField;
	private ImageView pokemonImageView;
	private int pokemonImageWidth = 180;
	private int pokemonImageHeight = 140;


	public PokedexView( double pokedexViewWidth, double pokedexViewHeight ){

		this.pokedexViewWidth = pokedexViewWidth;
		

		pokedexBorderPane = new BorderPane();
		pokemonDetailBorderPane = new BorderPane();
		pokemonDetailBorderPane.setStyle("-fx-background-color: #FFFFFF");

		// Adding TextField on Detail Info Window
		GridPane newGrid = new GridPane();
		this.pokemonNameTextField = new TextField("Blank");
		newGrid.add(this.pokemonNameTextField, 0, 1);
		// any image only for the purpose of instanciation
		Image pokemonImage = new Image("http://www.solidbackgrounds.com/images/2560x1440/2560x1440-black-solid-color-background.jpg",this.pokemonImageWidth,this.pokemonImageHeight, true, true);
		this.pokemonImageView = new ImageView(pokemonImage);
		newGrid.add(this.pokemonImageView, 0,0);

		Button newButton = new Button("Return");
		newButton.setOnAction(new ClosePokemonDetailWindowHandler(this));
		newButton.setPrefWidth(this.pokedexViewWidth-16);

		this.pokemonDetailBorderPane.setTop(newButton);
		BorderPane.setAlignment(newButton, Pos.CENTER_LEFT);
		this.pokemonDetailBorderPane.setCenter(newGrid);
		BorderPane.setAlignment(newGrid, Pos.CENTER);
		this.pokemonDetailBorderPane.setStyle("-fx-background-color:#ffffff");

		this.pokedexStackPane = new StackPane();
		
		this.pokedexStackPane.setMaxSize(pokedexViewWidth, pokedexViewHeight-38);
		this.pokedexStackPane.setMinSize(pokedexViewWidth, pokedexViewHeight-38);

		pokedexStackPane.getChildren().addAll(pokemonDetailBorderPane, pokedexBorderPane);

		// instance the list for stocking pokemon
		pokemonInPokedex = FXCollections.observableArrayList();
		// used only for autofilling the pokedex
		fillPokedex();

		// Vbox will be stocked in ScrollPane
		pokedexScrollPane = new ScrollPane();
		
		pokedexBorderPane.setCenter(pokedexScrollPane);

		// it will add all pokemon in vbox
		updatePokedex();

	}

	public void updatePokedex(){

		pokedexScrollPane.setContent(getPokedexViewWithDefaultStyle());
		
	}
	
	public VBox getPokedexViewWithDefaultStyle(){
		
		PokemonViewDblClickHandler newHandler = new PokemonViewDblClickHandler();
		return getPokedexView( newHandler, this.pokedexViewWidth-15, 50, new Insets(5,5,5,5), this.pokemonIconWidth, this.pokemonIconHeight, 5, 10 );
		
	}
	
	public VBox getPokedexView(PokemonViewListener handler, double pokemonViewWidth, double pokemonViewHeight, Insets pokemonPadding, double iconWidth, double iconHeight, double VGap, double HGap){
		
		VBox newVBox = new VBox();
		
		for(int i = 0; i < this.pokemonInPokedex.size(); ++i){
			
			PokemonView newPokemonView = new PokemonView(this.pokemonInPokedex.get(i), this);
			newPokemonView.registerListener(handler);
			
			newVBox.getChildren().add(newPokemonView.createView( pokemonViewWidth, pokemonViewHeight, pokemonPadding, iconWidth, iconHeight, VGap, HGap ));
		}
		
		return newVBox;
	
	}

	public StackPane getView(){
		return pokedexStackPane;
	}

	private void fillPokedex(){

		/*
		String response = Requests.get("http://127.0.0.1:4567/pokemons").send().readToText();
		Gson gson = new Gson();
		Pokemon[] pokemons = gson.fromJson(response, Pokemon[].class);

		for (int i = 0; i < pokemons.length; ++i) {
			pokemonInPokedex.add(pokemons[i]);
		}
		*/
		
		// temporary hard coded
		
		pokemonInPokedex.add(new Pokemon(1,"Bulbasaur","http://www.pkparaiso.com/imagenes/xy/sprites/animados/bulbasaur.gif","Grass"));
		pokemonInPokedex.add(new Pokemon(2,"Ivysaur","http://www.pkparaiso.com/imagenes/xy/sprites/animados/ivysaur.gif","Grass"));
		pokemonInPokedex.add(new Pokemon(3,"Venusaur","http://www.pkparaiso.com/imagenes/xy/sprites/animados/venusaur.gif","Grass"));
		pokemonInPokedex.add(new Pokemon(4,"Charmander","http://www.pkparaiso.com/imagenes/xy/sprites/animados/charmander.gif","Fire"));
		pokemonInPokedex.add(new Pokemon(5,"Charmeleon","http://www.pkparaiso.com/imagenes/xy/sprites/animados/charmeleon.gif","Fire"));
		pokemonInPokedex.add(new Pokemon(6,"Charizard","http://www.pkparaiso.com/imagenes/xy/sprites/animados/charizard.gif","Fire"));
		pokemonInPokedex.add(new Pokemon(7,"Squirtle","http://www.pkparaiso.com/imagenes/xy/sprites/animados/squirtle.gif","Water"));
		pokemonInPokedex.add(new Pokemon(8,"Wartortle","http://www.pkparaiso.com/imagenes/xy/sprites/animados/wartortle.gif","Water"));
		pokemonInPokedex.add(new Pokemon(9,"Blastoise","http://www.pkparaiso.com/imagenes/xy/sprites/animados/blastoise.gif","Water"));
		pokemonInPokedex.add(new Pokemon(10,"Caterpie","http://www.pkparaiso.com/imagenes/xy/sprites/animados/caterpie.gif","Bug"));
		pokemonInPokedex.add(new Pokemon(11,"Metapod","http://www.pkparaiso.com/imagenes/xy/sprites/animados/metapod.gif","Bug"));
		pokemonInPokedex.add(new Pokemon(12,"Butterfree","http://www.pkparaiso.com/imagenes/xy/sprites/animados/butterfree.gif","Bug"));
		pokemonInPokedex.add(new Pokemon(13,"Weedle","http://www.pkparaiso.com/imagenes/xy/sprites/animados/weedle.gif","Bug"));
		pokemonInPokedex.add(new Pokemon(14,"Kakuna","http://www.pkparaiso.com/imagenes/xy/sprites/animados/kakuna.gif","Bug"));
		pokemonInPokedex.add(new Pokemon(15,"Beedrill","http://www.pkparaiso.com/imagenes/xy/sprites/animados/beedrill.gif","Bug"));
		pokemonInPokedex.add(new Pokemon(16,"Pidgey","http://www.pkparaiso.com/imagenes/xy/sprites/animados/pidgey.gif","Normal"));
		pokemonInPokedex.add(new Pokemon(17,"Pidgeotto","http://www.pkparaiso.com/imagenes/xy/sprites/animados/pidgeotto.gif","Normal"));
		pokemonInPokedex.add(new Pokemon(18,"Pidgeot","http://www.pkparaiso.com/imagenes/xy/sprites/animados/pidgeot.gif","Normal"));
		pokemonInPokedex.add(new Pokemon(19,"Rattata","http://www.pkparaiso.com/imagenes/xy/sprites/animados/rattata.gif","Normal"));
		pokemonInPokedex.add(new Pokemon(20,"Raticate","http://www.pkparaiso.com/imagenes/xy/sprites/animados/raticate.gif","Normal"));
		pokemonInPokedex.add(new Pokemon(21,"Spearow","http://www.pkparaiso.com/imagenes/xy/sprites/animados/spearow.gif","Normal"));
		pokemonInPokedex.add(new Pokemon(22,"Fearow","http://www.pkparaiso.com/imagenes/xy/sprites/animados/fearow.gif","Normal"));
		pokemonInPokedex.add(new Pokemon(23,"Ekans","http://www.pkparaiso.com/imagenes/xy/sprites/animados/ekans.gif","Poison"));
		pokemonInPokedex.add(new Pokemon(24,"Arbok","http://www.pkparaiso.com/imagenes/xy/sprites/animados/arbok.gif","Poison"));
		pokemonInPokedex.add(new Pokemon(25,"Pikachu","http://www.pkparaiso.com/imagenes/xy/sprites/animados/pikachu.gif","Electric"));
		pokemonInPokedex.add(new Pokemon(26,"Raichu","http://www.pkparaiso.com/imagenes/xy/sprites/animados/raichu.gif","Electric"));
		pokemonInPokedex.add(new Pokemon(27,"Sandshrew","http://www.pkparaiso.com/imagenes/xy/sprites/animados/sandshrew.gif","Ground"));
		pokemonInPokedex.add(new Pokemon(28,"Sandslash","http://www.pkparaiso.com/imagenes/xy/sprites/animados/sandslash.gif","Ground"));
		
	}

	public void showPokemonDetail( Pokemon pokemon )
	{
		// prepare all info of this pokemon
		this.pokemonNameTextField.setText(pokemon.getName());
		Image pokemonImage = new Image(pokemon.getImagePath(), 100, 130, true, true);
		this.pokemonImageView.setImage(pokemonImage);

		// send the window of detail info to the front
		// and others to the back
		this.pokemonDetailBorderPane.toFront();
		// set the visibility of them too
		this.pokemonDetailBorderPane.setOpacity(1);
		this.pokedexBorderPane.setOpacity(0);

	}

	public void closePokemonDetail(){

		// just do the opposite of showPokemonDetail
		this.pokedexBorderPane.toFront();
		this.pokedexBorderPane.setOpacity(1);
		this.pokemonDetailBorderPane.setOpacity(0);

	}


}
