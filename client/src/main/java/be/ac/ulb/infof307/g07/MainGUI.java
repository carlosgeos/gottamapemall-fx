package be.ac.ulb.infof307.g07;

// import be.ac.ulb.infof307.g07.libs.CustomGson;
// import be.ac.ulb.infof307.g07.views.GeoLocalisationView;
// import be.ac.ulb.infof307.g07.views.MapView;
// import be.ac.ulb.infof307.g07.views.PokedexView;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import com.lynden.gmapsfx.MainApp;
import javafx.scene.image.Image;


// Music
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


/**
 * <b>MainGUI est la classe qui se charge de lancer l'interface graphique (afficher la carte dans la fenetre).</b>
 * Elle herite de la classe Application de javafx.
 *
 * @see be.ac.ulb.infof307.g07.views.MapView
 *
 * @see MapView
 * @author fan
 * @version 1.0
 */
public class MainGUI extends Application {

    @Override
    /**
     * La méthode qui lance l'interface graphique et l'affiche.
     *
     * @param primaryStage
     *                         le containeur parent.
     */
    public void start(Stage stage) throws Exception {
        // CustomGson.create();

	// ---- MUSIC ----

	// String path = getClass().getClassLoader().getResource("audio/gasolina.mp3").toString();
        // Media media = new Media(path);
        // MediaPlayer mp = new MediaPlayer(media);
        // mp.play();

	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/main.fxml"));

	stage.setTitle("PokeMap");
	stage.getIcons().add(new Image("https://pro-rankedboost.netdna-ssl.com/wp-content/uploads/2016/08/Togepi-Pokemon-Go.png")); // pass to local
        stage.setScene(new Scene(root, 1100, 650));
	stage.setResizable(true);
        stage.show();
    }

    /**
     * le point d entree du programme
     *
     * @param args input main args
     *
     */
    public static void main(String[] args) {
        Application.launch(MainGUI.class, args);
    }
}
