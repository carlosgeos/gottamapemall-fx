package be.ac.ulb.infof307.g07.Models;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Cette classe represente le modele dans la structure MVC cad la classe contenant les donnees relatives a la carte.
 * Par exemple les epingles (markers) et les informations les concernant.
 * 
 * <p>
 * C est aussi ici qu on cree les objets PokeMarker et Coordinate.
 * Un objet de cette classe est cree par les classes suivantes: MapMouseDblClickHandler et MapController dans leurs constructeurs respectifs.
 * <p>
 * 
 * @version 1.2
 * @see be.ac.ulb.infof307.g07.Models.PokeMarker
 * @see be.ac.ulb.infof307.g07.Models.Coordinate
 *
 */
public class Map {

	/**
	 * Une table de hachage contenant les PokeMarkers et leurs identifiants (nombre entier servant de clef) 
	 * 
	 */
	private HashMap<Integer, PokeMarker> pokeMarkers = new HashMap<Integer, PokeMarker>();


	private ArrayList<Integer> pokeMarkersNotOnMapView = new ArrayList<Integer>();
	
	/**
	 * Constructeur de Map
	 */
	public Map(){
		//...
	}
	
	/**
	 * 
	 * Cette methode cree un objet Coordinate grace aux coordonnees passees en parametre et fait ensuite appel a
	 * addPokeMarker(Coordinate position) pour renvoyer l epingle pokemon finale.
	 * 
	 * <p>
	 * TBD...
	 * <p>
	 * 
	 * @param x
	 * 			La position en abscisse (x) dans le plan, ou latitude sur une carte.
	 * @param y
	 * 			La position en ordonnee (y) dans le plan, ou longitude sur une carte.
	 * @param pokemon
	 * 				  le pokemon a indiquer sur la carte comme epingle (image et caracteristiques).
	 * @param date
	 * 				la date a laquelle le pokemon a ete vu.
	 * @param time
	 * 				l heure a laquelle le pokemon a ete vu.
	 * 
	 * @return 
	 * 			Le resultat de la methode addPokeMarker sur l objet Coordinate cree.
	 * 
	 * @see Map#addPokeMarker(Coordinate, Pokemon, String, String)
	 * @see be.ac.ulb.infof307.g07.Models.Coordinate
	 */
	public PokeMarker addPokeMarker( double x, double y, Pokemon pokemon, String date, String time ){
		
		Coordinate position = new Coordinate(x,y);
		
		return addPokeMarker(position, pokemon, date, time);
		
	}

	/**
	 * Cette methode cree un objet PokeMarker grace a l objet Coordinate renvoye (passe en parametre) par la methode addPokeMarker(double x, double y, Pokemon pokemon, String date, String time).
	 * et aux autres parametres de cette meme methode.
	 * 
	 * <p>
	 * La methode cree un objet PokeMarker et fait appel a la methode addPokeMarker(PokeMarker newPMarker) qui ajoute 
	 * le pokemarker dans la table de hachage (pokeMarkers.put(newPMarker.getId(), newPMarker) avec son id unique.
	 * <p>
	 * 
	 * @param newPosition
	 * 					La position de l epingle pokemon sur la carte.
	 * @param pokemon
	 * 				  le pokemon a indiquer sur la carte comme epingle (image et caracteristiques).
	 * @param date
	 * 				la date a laquelle le pokemon a ete vu.
	 * @param time
	 * 				l heure a laquelle le pokemon a ete vu.
	 * @return
	 * 			une nouvelle epingle pokemon (avec un identifiant unique) sous la forme d un objet PokeMarker, contenant sa position sur la carte.
	 *
	 * @see Map#addPokeMarker(PokeMarker)
	 * @see be.ac.ulb.infof307.g07.Models.PokeMarker
	 * @see Map#pokeMarkers
	 * 
	 */
	public PokeMarker addPokeMarker(Coordinate newPosition, Pokemon pokemon, String date, String time){
		
		PokeMarker newPMarker = new PokeMarker( newPosition, pokemon, date, time);
		addPokeMarker(newPMarker);
		return newPMarker;
	}

	/**
	 * Cette methode ajoute l'objet PokeMarker cree par la methode addPokeMarker(Coordinate position) dans la table de hachage pokeMarkers grace a sa methode put().
	 * 
	 * @param newPMarker
	 * 					L epingle pokemon (pokemarker) creee par la methode addPokeMarker(Coordinate position, Pokemon pokemon, String date, String time).
	 * 
	 * @see Map#addPokeMarker(Coordinate, Pokemon, String, String)
	 * @see be.ac.ulb.infof307.g07.Models.PokeMarker
	 * @see be.ac.ulb.infof307.g07.Models.PokeMarker#getId() 
	 * @see Map#pokeMarkersNotOnMapView
	 */
	public void addPokeMarker(PokeMarker newPMarker){

		pokeMarkers.put(newPMarker.getId(), newPMarker);
		
		this.pokeMarkersNotOnMapView.add(newPMarker.getId());

	}
	
	public Integer getIdOfPokeMarkerNotOnMap(){
		
		Integer res = -1;
		int size = this.pokeMarkersNotOnMapView.size();
		if( size != 0 ){
			
			res = this.pokeMarkersNotOnMapView.get(size-1);
			
		}
		
		return res;
		
	}
	
	public final PokeMarker getPokeMarker(int idOfPokeMarker){
		
		return this.pokeMarkers.get(idOfPokeMarker);
		
	}
	
	public void removePokeMarkerJustAddedOnMapView(Integer idOfAddedPokeMarker){
		
		this.pokeMarkersNotOnMapView.remove(idOfAddedPokeMarker);
		
	}
	
	/**
	 * Retourne le nombre d epingle contenues dans la table de hachage (et donc le nombre d epingles presentes sur la carte) grace a sa methode size().
	 * 
	 * @return
	 * 			la taille de pokeMarkers (table de hachage des epingles), sous forme d un entier.
	 * 
	 * @see Map#pokeMarkers
	 * 
	 */
	public int getNumberOfMarker(){
		
		return pokeMarkers.size();
	}
	
	public void removePokeMarker(PokeMarker pokeMarker){
		
		pokeMarkers.remove(pokeMarker.getId());
		
	}

}
