package be.ac.ulb.infof307.g07.Models;

/**
 * <b>Coordinate est la classe representant une coordonnee dans un plan (deux nombres reels).</b>
 * Elle herite de la classe LatLong (Latitute et Longitude) et est utilisee pour afficher une epingle à une position donnee sur la carte.
 * 
 * @see Map
 * 
 * @author fan
 * @version 1.1
 */
public class Coordinate{


	private double x;
	private double y;
	
	 /**
     * Constructeur de Coordinate.
     * 
     * @param newX
     *            La position en abscisse (x) dans le plan, ou latitude.
     * @param newY
     *            La position en ordonnée (y) dans le plan, ou longitude.
     * 
     */
	public Coordinate(double newX, double newY) {
		
		x = newX;
		y = newY;
	}
	
	public double getX(){
		
		return x;
		
	}
	
	public double getY(){
		
		return y;
		
	}
}
