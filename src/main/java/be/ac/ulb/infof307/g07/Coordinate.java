package be.ac.ulb.infof307.g07;

import com.lynden.gmapsfx.javascript.object.LatLong;


/**
 * <b>Coordinate est la classe représentant une coordonnée dans un plan (deux nombres réels).</b>
 * Elle hérite de la classe LatLong (Latitute et Longitude) et est utilisée pour afficher une épingle à une position donnée sur la carte.
 * 
 * @see Map
 * 
 * @author fan
 * @version 1.0
 */
public class Coordinate extends LatLong{

	 /**
     * Constructeur de Coordinate.
     * 
     * @param x
     *            La position en abscisse (x) dans le plan, ou latitude.
     * @param y
     *            La position en ordonnée (y) dans le plan, ou longitude.
     * 
     */
	public Coordinate(double x, double y) {
		super(x, y);
		
	}
}
