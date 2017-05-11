package be.ac.ulb.infof307.g07.controllers.Handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FilterSearchHandler implements EventHandler<ActionEvent>{

	
	private String critName;
	private String critType1;
	private String critType2;
	private int critHeight;
	private int critWeight;
	private int critBaseExp;
	
	public FilterSearchHandler( String name, String type1, String type2, int height, int weight, int exp){
		
		this.critName = name;
		this.critType1 = type1;
		this.critType2 = type2;
		this.critHeight = height;
		this.critWeight = weight;
		this.critBaseExp = exp;
		
	}
	
	@Override
	public void handle(ActionEvent event) {
		
		// send to server and update the mapview
		
	}

}
