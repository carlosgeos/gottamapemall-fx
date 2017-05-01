package be.ac.ulb.infof307.g07.views;

import javax.swing.event.HyperlinkEvent.EventType;

import be.ac.ulb.infof307.g07.controllers.Handlers.FilterSaveHandler;
import be.ac.ulb.infof307.g07.controllers.Handlers.FilterSearchHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FilterView {
    private GridPane mainView;
    private TextField nameTextField;
    private TextField type1TextField;
    private TextField type2TextField;
    private TextField weightTextField;
    private TextField heightTextField;
    private TextField baseExpTextField;
    private TextField filterNameTextField;
    
    private Button saveButton;
    private Button searchButton;
    
    public FilterView( double width, double height) {
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
        
        this.mainView.add(new Label("Filtername : "), 0, 6);
        this.filterNameTextField = new TextField();
        this.mainView.add(this.filterNameTextField, 1, 6);
        
        this.saveButton = new Button("Save");
        this.mainView.add( this.saveButton, 0, 7);
        this.searchButton = new Button("Search");
        this.mainView.add(this.searchButton, 1, 7);
        this.saveButton.setOnAction(new FilterSaveHandler( this.nameTextField.textProperty().get(), 
                this.type1TextField.textProperty().get(), this.type2TextField.textProperty().get(), 
                Integer.parseInt(this.weightTextField.textProperty().get()),
                Integer.parseInt(this.heightTextField.textProperty().get()), Integer.parseInt(this.baseExpTextField.textProperty().get()),
                this.filterNameTextField.textProperty().get()));
        
        this.searchButton.setOnAction(new FilterSearchHandler(this.nameTextField.textProperty().get(), 
                this.type1TextField.textProperty().get(), this.type2TextField.textProperty().get(), 
                Integer.parseInt(this.weightTextField.textProperty().get()),
                Integer.parseInt(this.heightTextField.textProperty().get()), Integer.parseInt(this.baseExpTextField.textProperty().get())));
        this.mainView.setVgap(2);
        this.mainView.setHgap(2);
        this.mainView.setPadding(new Insets(2,2,2,2));
    }
    
    public GridPane getView() {
        return this.mainView;
    }
}
