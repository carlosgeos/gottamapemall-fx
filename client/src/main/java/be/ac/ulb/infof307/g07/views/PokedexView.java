package be.ac.ulb.infof307.g07.views;

import be.ac.ulb.infof307.g07.controllers.PokemonViewListener;
import be.ac.ulb.infof307.g07.controllers.Handlers.ClosePokemonDetailWindowHandler;
import be.ac.ulb.infof307.g07.controllers.Handlers.PokedexSearchHandler;
import be.ac.ulb.infof307.g07.controllers.Handlers.PokemonViewDblClickHandler;
import be.ac.ulb.infof307.g07.models.Pokemon;
import be.ac.ulb.infof307.g07.models.Pokedex;
import be.ac.ulb.infof307.g07.controllers.Handlers.onPokemonGlobalCountChangeHandler;
import net.dongliu.requests.Requests;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Fan et Renato
 *
 */
public class PokedexView {
    // stock real pokemon
    private ObservableList<PokemonView> pokemonViewInPokedex;
    private Pokedex pokedex;

    private double pokedexViewWidth = 0;

    private double pokemonIconWidth = 45;
    private double pokemonIconHeight = 45;


    private BorderPane pokedexBorderPane;
    private BorderPane pokemonDetailBorderPane;
    private StackPane pokedexStackPane;
    private ScrollPane pokedexScrollPane;


    // used for detail info window
    private TextField pokemonNameTextField;
    private TextField pokemonTypeTextField;
    private TextField pokedexSearchTextField;
    
    private Label pokemonHeightField;
    private Label pokemonWeightField;
    private ImageView pokemonImageView;
    private int pokemonImageWidth = 180;
    private int pokemonImageHeight = 140;

    public static HashMap<Integer, Integer> markedPokemonCounting = new HashMap<Integer, Integer>();

    public PokedexView(double pokedexViewWidth, double pokedexViewHeight) {
        this.pokedex = new Pokedex();

        this.pokedexViewWidth = pokedexViewWidth;

        pokedexBorderPane = new BorderPane();
        pokemonDetailBorderPane = new BorderPane();
        pokemonDetailBorderPane.setStyle("-fx-background-color: #FFFFFF");

        // Adding TextField on Detail Info Window
        GridPane newGrid = new GridPane();
        this.pokemonNameTextField = new TextField("Blank");
        this.pokemonTypeTextField = new TextField("Blank");
        this.pokemonHeightField = new Label("Blank");
        this.pokemonWeightField = new Label("Blak");
        newGrid.add(new Label("Name: "), 0, 1);
        newGrid.add(new Label("Type: "), 0, 2);
        newGrid.add(new Label("Weight (kg): "), 0, 3);
        newGrid.add(new Label("Height (m): "), 0, 4);
        newGrid.add(this.pokemonNameTextField, 1, 1);
        newGrid.add(this.pokemonTypeTextField, 1, 2);
        newGrid.add(this.pokemonHeightField, 1, 3);
        newGrid.add(this.pokemonWeightField, 1, 4);
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

        this.pokemonViewInPokedex = FXCollections.observableArrayList();

        // Vbox will be stocked in ScrollPane
        pokedexScrollPane = new ScrollPane();

        pokedexBorderPane.setCenter(pokedexScrollPane);
        
        
        GridPane searchGridPane = new GridPane();
        searchGridPane.setMaxSize(pokedexViewWidth, 20);
        searchGridPane.setMinSize(pokedexViewWidth, 20);
        this.pokedexSearchTextField = new TextField();
        Button searchButton = new Button("Search");
        searchButton.setOnAction(null);
        searchGridPane.add( pokedexSearchTextField, 0, 0);
        searchGridPane.add(searchButton, 1, 0);
        pokedexBorderPane.setTop(searchGridPane);
        
        // it will add all pokemon in vbox
        updatePokedex();
    }

    public void refreshCounts() {
        for(int i = 0; i < this.pokemonViewInPokedex.size(); ++i) {
            this.pokemonViewInPokedex.get(i).refreshCount();
        }
    } 

    public void updatePokedex() {
        pokedexScrollPane.setContent(getPokedexViewWithDefaultStyle());
    }

    public VBox getPokedexViewWithDefaultStyle() {
        PokemonViewDblClickHandler newHandler = new PokemonViewDblClickHandler(this);
        return getPokedexView( newHandler, this.pokedexViewWidth-15, 50, new Insets(5,5,5,5), this.pokemonIconWidth, this.pokemonIconHeight, 5, 10 );
    }

    public VBox getPokedexView(PokemonViewListener handler, double pokemonViewWidth, double pokemonViewHeight, Insets pokemonPadding, double iconWidth, double iconHeight, double VGap, double HGap) {
        VBox newVBox = new VBox();

        for(int i = 0; i < this.pokedex.getSize(); ++i) {
            PokemonView newPokemonView = new PokemonView(this.pokedex.getPokemon(i), this);
            onPokemonGlobalCountChangeHandler tmphandler = new onPokemonGlobalCountChangeHandler(newPokemonView);
            this.pokedex.getPokemon(i).addListener(tmphandler);
            this.pokemonViewInPokedex.add(newPokemonView); 

            newPokemonView.registerListener(handler);

            newVBox.getChildren().add(newPokemonView.createView( pokemonViewWidth, pokemonViewHeight, pokemonPadding, iconWidth, iconHeight, VGap, HGap ));
        }

        return newVBox;
    }

    public StackPane getView() {
        return pokedexStackPane;
    }

    public void showPokemonDetail( Pokemon pokemon ) {
        // prepare all info of this pokemon
        this.pokemonNameTextField.setText(pokemon.getName());
        String typesText = "";

        if (pokemon.getTypes() != null) {
            String[] types = pokemon.getTypes();
            for (int i = 0; i < types.length; ++i) {
                typesText += types[i] + ", ";
            }
        }

        this.pokemonTypeTextField.setText(typesText);
        this.pokemonHeightField.setText(Double.toString(pokemon.getHeight()));
        this.pokemonWeightField.setText(Double.toString(pokemon.getWeight()));
        Image pokemonImage = new Image(pokemon.getImagePath(), 100, 130, true, true);
        this.pokemonImageView.setImage(pokemonImage);

        // send the window of detail info to the front
        // and others to the back
        this.pokemonDetailBorderPane.toFront();
        // set the visibility of them too
        this.pokemonDetailBorderPane.setOpacity(1);
        this.pokedexBorderPane.setOpacity(0);
    }

    public void closePokemonDetail() {
        // just do the opposite of showPokemonDetail
        this.pokedexBorderPane.toFront();
        this.pokedexBorderPane.setOpacity(1);
        this.pokemonDetailBorderPane.setOpacity(0);
    }

    public Pokemon getPokemonFromPokedex(int id) {
        return this.pokedex.getPokemonWithId(id);
    }

    public Pokedex getPokedex() {
        return this.pokedex;
    } 
}
