package be.ac.ulb.infof307.g07; /**
 * Created by carlos on 3/11/17.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import static javafx.application.Application.launch;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.sun.prism.PhongMaterial.MapType;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import static javafx.application.Application.launch;


public class Main extends Application{

	private Map map;

	@Override
	public void start(Stage stage) throws Exception {

	    //Create the JavaFX component and set this as a listener so we know when 
	    //the map has been initialized, at which point we can then begin manipulating it.
	    map = new Map();
	    
	    
	    BorderPane mainPane = new BorderPane();
	    BorderPane controlPane = new BorderPane();
	    
	    Label labelLat = new Label("Latitude: ");
	    Label labelLong = new Label("Longtitude: ");
	    TextField fieldLat = new TextField();
	    TextField fieldLong = new TextField();
	    
	    Button btn = new Button();
	    btn.setText("Go");
	    
	    HBox hb1 = new HBox();
	    HBox hb2 = new HBox();
	    HBox hb3 = new HBox();
	    hb1.getChildren().addAll(labelLat, fieldLat);
	    hb2.getChildren().addAll(labelLong, fieldLong);
	    hb3.getChildren().addAll(btn);
	    btn.setOnAction(new EventHandler<ActionEvent>(){
	    	
	    	@Override
	    	
	    	public void handle(ActionEvent event){
	    		
	    		Double Longtitude = Double.valueOf(fieldLong.getText());
	    		Double Latitude = Double.valueOf(fieldLat.getText());
	    		LatLong position = new LatLong(Latitude ,Longtitude);
	    		map.onClickButton(position);
	    		
	    	}
	    	
	    });
	    
	    controlPane.setLeft(hb1);
	    controlPane.setCenter(hb2);
	    controlPane.setRight(hb3);
	    
	    mainPane.setLeft(map.getView());
	    mainPane.setRight(controlPane);
	    
	    
	    Scene scene = new Scene(mainPane);
	    
	    stage.setTitle("JavaFX and Google Maps");
	    stage.setScene(scene);
	    stage.show();
	   
	}

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}