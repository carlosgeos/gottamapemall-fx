package be.ac.ulb.infof307.g07.Views;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import be.ac.ulb.infof307.g07.Controllers.ChoosePokemonViewListener;
import be.ac.ulb.infof307.g07.Controllers.PokemonViewListener;
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

public class ChoosePokemonView implements PokemonViewListener, EventHandler<ActionEvent> {
    private ArrayList<ChoosePokemonViewListener> listeners= new ArrayList<ChoosePokemonViewListener>();
    
    public final static int defaultWindowWidth = 300;
    public final static int defaultWindowHeight = 350;
    public static boolean isCreated = false;
    
    private final int windowWidth;
    private final int windowHeight;
    
    private Stage mainStage = new Stage();

    private Pokemon selectedPokemon = null;
    private Button submitButton;
    private TextField date;
    private TextField time;


    public ChoosePokemonView( int windowWith, int windowHeight) {
        this.windowWidth = windowWith;
        this.windowHeight = windowHeight;
        
        create();
    }
    
    public ChoosePokemonView() {
        this( ChoosePokemonView.defaultWindowWidth, ChoosePokemonView.defaultWindowWidth );
    }
    
    public void close() {
        this.mainStage.close();
        ChoosePokemonView.isCreated = false;
    }

    public void create() {
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
        this.submitButton.setOnAction(this);
    
        mainGridPane.add(this.submitButton, 1, 3);
        this.submitButton.setPrefWidth(200);
        mainGridPane.setVgap(5);
        mainGridPane.setHgap(5);
        mainGridPane.setPadding(new Insets(10,10,10,10));
    
        Scene mainScene = new Scene(mainGridPane, windowWidth, windowHeight);
        this.mainStage.setScene(mainScene);
        this.mainStage.setResizable(false);;
        this.mainStage.setTitle("Choose the pokemon");
        this.mainStage.setOnCloseRequest((event)->{ ChoosePokemonView.isCreated = false; });
        show();
    }
    
    public void show(){
        this.mainStage.show();
        ChoosePokemonView.isCreated = true;
    }

    public void addListener(ChoosePokemonViewListener newListener ){
        this.listeners.add(newListener);
    }
    
    private void callListener(){
        for(ChoosePokemonViewListener listener : this.listeners){
            listener.onConfirm(this.selectedPokemon, this.date.getText(), this.time.getText());
        }
    }

    @Override
    public void onDoubleClick(Pokemon pokemon) {
        // Customized PokemonViewListener
        this.selectedPokemon = pokemon;
    }

    @Override
    public void handle(ActionEvent event) {
        // button onclick action
        
        this.callListener();
        ChoosePokemonView.isCreated = false;
        this.mainStage.close();
    }
}
