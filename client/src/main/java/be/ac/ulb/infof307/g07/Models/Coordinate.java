package be.ac.ulb.infof307.g07.Models;

/**
 * <b>Coordinate est la classe représentant une coordonnée dans un plan (deux nombres réels).</b>
 * Elle hérite de la classe LatLong (Latitute et Longitude) et est utilisée pour afficher une épingle à une position donnée sur la carte.
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
     * @param x
     *            La position en abscisse (x) dans le plan, ou latitude.
     * @param y
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
