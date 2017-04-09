package be.ac.ulb.infof307.g07.Models;

/**
 * <b>Coordinate est la classe representant une coordonnee dans un plan (deux nombres reels).</b>
 * Elle est utilisee pour afficher une epingle a une position donnee sur la carte.
 * 
 * <p>
 * Un objet de cette classe est instancie par la classe MapMouseDblClickHandler, dans sa methode handle(), ainsi que
 * par la classe Map, dans sa methode addPokeMarker(double, double).
 * <p>
 * 
 * @see be.ac.ulb.infof307.g07.Models.Map
 * 
 * @author fan
 * @version 1.2
 */
public class Coordinate{

	/**
	 * La position en abscisse (x) dans le plan, ou latitude sur une carte.
	 */
	private double x;
	
	/**
	 * La position en ordonnee (y) dans le plan, ou longitude sur une carte.
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
     * @return La coordonnee en abscisse, sous forme d'un nombre reel (double).
     */
	public double getX(){
		
		return x;
		
	}
	
	/**
     * Retourne la position en ordonnee (y), ou longitude.
     * 
     * @return La coordonnee en ordonnee, sous forme d'un nombre reel (double).
     */
	public double getY(){
		
		return y;
		
	}
}
