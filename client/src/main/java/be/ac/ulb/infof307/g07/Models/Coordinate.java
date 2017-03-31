package be.ac.ulb.infof307.g07.Models;

/**
 * <b>Coordinate est la classe représentant une coordonnée dans un plan (deux nombres réels).</b>
 * Elle hérite de la classe LatLong (Latitute et Longitude) et est utilisée pour afficher une épingle à une position donnée sur la carte.
 * 
 * @see Map
 * 
 * @author fan
 * @version 1.0
 */
public class Coordinate{

	 /**
     * Constructeur de Coordinate.
     * 
     * @param x
     *            La position en abscisse (x) dans le plan, ou latitude.
     * @param y
     *            La position en ordonnée (y) dans le plan, ou longitude.
     * 
     */
	
	private double x;
	private double y;
	
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
