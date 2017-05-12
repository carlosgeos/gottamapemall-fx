package be.ac.ulb.infof307.g07.controllers;

import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.MouseEventHandler;

import be.ac.ulb.infof307.g07.views.PokemonSelectionView;


public class MapDblClickHandler implements MouseEventHandler{
	
	@Override
	public void handle(GMapMouseEvent mapMouseEvent) {
		
		System.out.println("Double clicked");
		PokemonSelectionView view = PokemonSelectionView.getInstance();
		view.setVisible(true);
	}

}
