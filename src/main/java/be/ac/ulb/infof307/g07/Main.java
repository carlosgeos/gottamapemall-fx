package be.ac.ulb.infof307.g07; /**
 * Created by carlos on 3/11/17.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import static javafx.application.Application.launch;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application{

	private Map map;

	@Override
	public void start(Stage stage) throws Exception {

	    //Create the JavaFX component and set this as a listener so we know when 
	    //the map has been initialized, at which point we can then begin manipulating it.
	    map = new Map();
	    
	    BorderPane mainPane = new BorderPane();
		mainPane.setLeft(map.getView());

	    Scene scene = new Scene(mainPane);
	    
	    stage.setTitle("Gotta Map'Em All");
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