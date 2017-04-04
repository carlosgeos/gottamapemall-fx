

package be.ac.ulb.infof307.g07.Controllers.Handlers;

import be.ac.ulb.infof307.g07.MyClass;
import be.ac.ulb.infof307.g07.Views.PokedexView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * 
 * @author Fan && Renato
 * 
 */

public class SearchFieldOnKeyReleasedHandler implements EventHandler<KeyEvent>{

	private TextField criteriaInput;
	private PokedexView pokedexView;
	
	public SearchFieldOnKeyReleasedHandler(PokedexView pkView,TextField txtField){
		
		criteriaInput = txtField;
		pokedexView = pkView;
		
	}
	
	@Override
	public void handle(KeyEvent arg0) {
		// TODO Auto-generated method stub
		ObservableList<MyClass> pkmList = FXCollections.observableArrayList(pokedexView.getPokemonList());
		ObservableList<MyClass> newPkmList;
		newPkmList = FXCollections.observableArrayList();
		
		System.out.println("pkmlist: "+pkmList.size());
		
		if(!criteriaInput.getText().isEmpty()){
			for (int i = 0 ; i<pkmList.size() ; i++){
				if (matchCriteria(pkmList.get(i),criteriaInput.getText())){
					newPkmList.add(pkmList.get(i));
				}
			}
		}else{
			newPkmList = pkmList;
		}
		pokedexView.setNewPokemonList(newPkmList);
		pokedexView.updatePokedex();
		
		System.out.print(criteriaInput.getText());

	}
	
	private boolean matchCriteria(MyClass pkmEntry, String fieldInput){
		if (pkmEntry.name.equals(fieldInput)){
			return true;			
		}else{
			return false;
		}
		
	}

}
