package be.ac.ulb.infof307.g07.controllers;

import com.lynden.gmapsfx.javascript.event.StateEventHandler;

public class CloseMarkerOptionHandler implements StateEventHandler{

	@Override
	public void handle() {
		
		try{
			PokeMarkerRightClickHandler.getInstance().close();
		}catch(NullPointerException except){
			System.out.println("PokeMarkerRightClickHandler no instance founded.");
		}
	}

}
