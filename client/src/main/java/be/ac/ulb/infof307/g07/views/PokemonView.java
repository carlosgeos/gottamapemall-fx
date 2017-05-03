package be.ac.ulb.infof307.g07.views;

import java.util.ArrayList;

import be.ac.ulb.infof307.g07.controllers.PokemonViewListener;
import be.ac.ulb.infof307.g07.models.Pokemon;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * 
 * Cette classe représente la vue sur un pokemon, cad l'affichage des pokemons dans le pokedex
 * 
 * @version 1.0
 *
 * @see be.ac.ulb.infof307.g07.models.Pokemon
 */
public class PokemonView implements EventHandler<MouseEvent> {
	
    private Pokemon pokemon;
    private PokedexView pokedexView;
    private GridPane pokemonGridPane;
    
    /**
     * un libellé (texte) pour indiquer le nombre de fois que ce pokemon a été signalé sur la carte
     */
    private Label globalCountLabel;
    private String holdGridStyle;
    private String defaultGridStyle;
    private String hoverGridStyle;
    private String selectGridStyle;
    private String dblClickGridStyle;

    private ArrayList<PokemonViewListener> listeners= new ArrayList<PokemonViewListener>();

    public static PokemonView selectedPokemonView = null;
    public static PokemonView dblClickPokemonView = null;

    public PokemonView(Pokemon pokemon, PokedexView pokedexView) {
        this.pokemon = pokemon;
        this.pokedexView = pokedexView;

        this.defaultGridStyle = "-fx-border: 1px;-fx-border-color:#EBEBEB; -fx-border-style:solid;";
        this.hoverGridStyle = "-fx-border: 1px;-fx-border-color:#75B1FF; -fx-border-style:solid;";
        this.selectGridStyle = "-fx-border: 1px;-fx-border-color:#FFC05C; -fx-border-style:solid;";
        this.dblClickGridStyle = "-fx-border: 1px;-fx-border-color:#00ff00; -fx-border-style:solid;";
    }

    public GridPane createView(double pokemonViewWidth, double pokemonViewHeight, Insets pokemonPadding, double iconWidth, double iconHeight, double VGap, double HGap) {
        this.pokemonGridPane = new GridPane();
        this.pokemonGridPane.setPrefWidth(pokemonViewWidth);
        this.pokemonGridPane.setPrefHeight(pokemonViewHeight);
        this.pokemonGridPane.setStyle(this.defaultGridStyle);

        this.pokemonGridPane.setHgap(HGap);
        this.pokemonGridPane.setVgap(VGap);
        this.pokemonGridPane.setPadding(pokemonPadding);


        Image pokemonImage = new Image(this.pokemon.getImagePath(), iconWidth, iconHeight, true, true);
        ImageView pokemonImageView = new ImageView(pokemonImage);

        this.pokemonGridPane.add(pokemonImageView, 0, 0);
        this.pokemonGridPane.add(new Label(Integer.toString(this.pokemon.getId())), 1, 0);
        this.pokemonGridPane.add(new Label(this.pokemon.getName()), 2, 0);

        this.globalCountLabel = new Label(Integer.toString(this.pokemon.getGlobalCounting()));
        this.pokemonGridPane.add(this.globalCountLabel, 3, 0);

        this.pokemonGridPane.setOnMouseClicked(this);
        this.pokemonGridPane.setOnMouseEntered(mouseEvent -> {
            this.holdGridStyle = this.pokemonGridPane.getStyle();
            this.pokemonGridPane.setStyle(this.hoverGridStyle); });
        this.pokemonGridPane.setOnMouseExited(mouseEvent -> { this.pokemonGridPane.setStyle(this.holdGridStyle); });

        return this.pokemonGridPane;
    }

    public GridPane getView() {
        return this.pokemonGridPane;
    }

    public void registerListener(PokemonViewListener newListener) {
        this.listeners.add(newListener);
    }

    public void resetStyle() {
        this.pokemonGridPane.setStyle(this.defaultGridStyle);
    }

    public void setSelectStyle() {
        if(PokemonView.selectedPokemonView != null){
            PokemonView.selectedPokemonView.resetStyle();
        }

        this.pokemonGridPane.setStyle(this.selectGridStyle);
        this.holdGridStyle = this.selectGridStyle;
        PokemonView.selectedPokemonView = this;
    }

    public void setDblClickStyle() {
        if( PokemonView.dblClickPokemonView!=null) {
            PokemonView.dblClickPokemonView.resetStyle();
        }

        this.pokemonGridPane.setStyle(this.dblClickGridStyle);
        this.holdGridStyle = this.dblClickGridStyle;
        PokemonView.dblClickPokemonView = this;
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getClickCount() == 2) {
            setDblClickStyle();

            for(PokemonViewListener pkListener : this.listeners) {
                pkListener.onDoubleClick(this.pokemon);

            }
        } else if(event.getClickCount() == 1) {
            setSelectStyle();
        }
    }

    /**
     * cette méthode actualise le libellé globalCountLabel (via getGlobalCounting de Pokemon) avec le nombre de fois que le pokemon a été ajouté sur la carte (Pokemon.globalCounting) 
     * 
     * @see be.ac.ulb.infof307.g07.models.Pokemon
     * @see be.ac.ulb.infof307.g07.models.Pokemon#getGlobalCounting()
     */
    public void refreshCount() {
        this.globalCountLabel.setText(Integer.toString(this.pokemon.getGlobalCounting()));
    } 
}
