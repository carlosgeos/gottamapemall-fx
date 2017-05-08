package be.ac.ulb.infof307.g07.views;

import javax.swing.event.HyperlinkEvent.EventType;

import be.ac.ulb.infof307.g07.controllers.Handlers.FilterSaveHandler;
import be.ac.ulb.infof307.g07.controllers.Handlers.FilterSearchHandler;
import be.ac.ulb.infof307.g07.models.FilterModel;
import be.ac.ulb.infof307.g07.models.PokeMarker;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.util.List;
import java.util.ArrayList;

public class FilterView {
    private MapView view;
    private GridPane mainView;
    private TextField nameTextField;
    private TextField type1TextField;
    private TextField type2TextField;
    private TextField weightTextField;
    private TextField heightTextField;
    private TextField baseExpTextField;
    
    private Button saveButton;
    private Button searchButton;
    
    public FilterView(double width, double height, MapView view) {
        this.view = view;
        this.mainView = new GridPane();
        this.mainView.setMaxSize(width, height);
        this.mainView.setMinSize(width, height);
        this.mainView.setStyle("-fx-background-color:#ffffff");
        this.mainView.setOpacity(1);
        this.mainView.add(new Label("Name : "), 0, 0);
        this.nameTextField = new TextField();
        this.mainView.add(this.nameTextField, 1, 0);
        
        this.mainView.add(new Label("Type 1 : "), 0, 1);
        this.type1TextField = new TextField();
        this.mainView.add(this.type1TextField, 1, 1);
        
        this.mainView.add(new Label("Type 2 : "), 0, 2);
        this.type2TextField = new TextField();
        this.mainView.add(this.type2TextField, 1, 2);
        
        this.mainView.add(new Label("Weight : "), 0, 3);
        this.weightTextField = new TextField();
        this.mainView.add(this.weightTextField, 1, 3);
        
        this.mainView.add(new Label("Height : "), 0, 4);
        this.heightTextField = new TextField();
        this.mainView.add(this.heightTextField, 1, 4);
        
        this.mainView.add(new Label("Base experience : "), 0, 5);
        this.baseExpTextField = new TextField();
        this.mainView.add(this.baseExpTextField, 1, 5);
        
        this.saveButton = new Button("Save");
        this.mainView.add(this.saveButton, 0, 6);
        this.saveButton.setOnAction(new FilterSaveHandler(this));
        
        this.searchButton = new Button("Search");
        this.mainView.add(this.searchButton, 1, 6);
        this.searchButton.setOnAction(new FilterSearchHandler(this));
       
        this.mainView.setVgap(2);
        this.mainView.setHgap(2);
        this.mainView.setPadding(new Insets(2,2,2,2));
        
                
    }

    public FilterModel getFilter() {
        String name = this.nameTextField.textProperty().get();
        ArrayList<String> types = new ArrayList<String>();
        String type1 = this.type1TextField.textProperty().get();
        if (!type1.isEmpty()) {
            types.add(type1);
        }
        String type2 = this.type2TextField.textProperty().get();
        if (!type2.isEmpty()) {
            types.add(type2);
        }

        String heightText = this.heightTextField.textProperty().get();
        int height = -1;
        if (!heightText.isEmpty()) {
            height = Integer.parseInt(heightText);
        }

        String weightText = this.weightTextField.textProperty().get();
        int weight = -1;
        if (!weightText.isEmpty()) {
            weight = Integer.parseInt(weightText);
        }

        String baseText = this.baseExpTextField.textProperty().get();
        int base_experience = -1;
        if (!baseText.isEmpty()) {
            base_experience = Integer.parseInt(baseText);
        }

        String[] typesArray = new String[types.size()];
        typesArray = types.toArray(typesArray);

        return new FilterModel(name, typesArray, weight, height, base_experience);
    }

    public void filterOnMap(PokeMarker[] markers) {
        this.view.setMarkers(markers);
    }
    
    public GridPane getView() {
        return this.mainView;
    }
}
