package be.ac.ulb.infof307.g07.models;

//TODO: Pourquoi on utilise des réels (double lat, et double lon) dans onMapDblClickHandler au lieu de Coordinate? 
//Ne faudrait-il pas choisir l'un ou l'autre?

/**
 * <b>Coordinate est la classe représentant une coordonnée dans un plan (deux nombres réels).</b>
 * Elle est utilisée pour afficher une épingle à une position donnée sur la carte.
 * 
 * <p>
 * Un objet de cette classe est instancié par la classe OnMapRightClickHandler dans sa méthode handle(),   (attribut statique 'center'),   
 * PokeMarker dans sa méthode getOnMapPosition() et MapView (attribut statique position). 
 * <p>
 * 
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.OnMapRightClickHandler
 * @see be.ac.ulb.infof307.g07.models.GeoLocaLisation
 * @see be.ac.ulb.infof307.g07.models.PokeMarker
 * @see be.ac.ulb.infof307.g07.views.MapView
 * 
 * @author fan
 * @version 1.2
 */
public class Coordinate {
	
    /**
     * La position en abscisse (x) dans le plan, ou latitude sur une carte.
     */
    private double x;
    
    /**
     * La position en ordonnée (y) dans le plan, ou longitude sur une carte.
     */
    private double y;
    
    /**
     * Constructeur de Coordinate.
     * 
     * @param newX
     *            La position en abscisse (x) dans le plan, ou latitude.
     * @param newY
     *            La position en ordonnee (y) dans le plan, ou longitude.
     * 
     */
    public Coordinate(double newX, double newY) {
        x = newX;
        y = newY;
    }
    
    /**
     * Retourne la position en abscisse (x), ou latitude.
     * 
     * @return La coordonnée en abscisse, sous forme d'un nombre réel (double).
     */
    public double getX() {
        return x;
    }
    
    /**
     * Retourne la position en ordonnée (y), ou longitude.
     * 
     * @return La coordonnée en ordonnée, sous forme d'un nombre réel (double).
     */
    public double getY() {
        return y;
    }
}
