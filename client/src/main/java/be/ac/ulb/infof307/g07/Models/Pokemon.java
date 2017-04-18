package be.ac.ulb.infof307.g07.Models;

public class Pokemon {

    private final int id;
    private final String name;
    private final String imagePath;
    private final String type;
    private double height;
    private double weight;


    public Pokemon(int id, String name, String imagePath, String type){
	this.id = id;
	this.name = name;
	this.imagePath = imagePath;
	this.type = type;
    }

    public Pokemon(int id, String name, String imagePath, String type, double height, double weight) {
	this.id = id;
	this.name = name;
	this.imagePath = imagePath;
	this.type = type;
	this.height = height;
	this.weight = weight;
    }

    public String toString(){

	String res = "";

	res += this.id +" : "+ this.name;

	return res;

    }

    public final int getId(){

	return this.id;

    }

    public final String getName(){

	return this.name;

    }

    public final String getImagePath(){

	return this.imagePath;
    }

    public final String getType(){
	return this.type;

    }
    public final double getHeight(){
	return this.height;

    }
    public final double getWeight(){
	return this.weight;

    }
}
