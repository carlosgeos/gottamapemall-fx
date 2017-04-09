package be.ac.ulb.infof307.g07.Views;

import be.ac.ulb.infof307.g07.MyClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class SideView {
	private Pane sideViewBorderPane;

	public SideView(MyClass item, Pane newpane){
		sideViewBorderPane = new Pane();
		sideViewBorderPane.setMaxSize(800/3, 600);
		sideViewBorderPane.setMinSize(800/3, 600);
		ObservableList<MyClass> sideViewContent = FXCollections.observableArrayList();
		sideViewContent.add(item);
		
		ListView<MyClass> contentListView = new ListView<MyClass>();
		contentListView.setItems(sideViewContent);
		
		contentListView.setCellFactory(new Callback<ListView<MyClass>, ListCell<MyClass>>() {  
			@Override
			public ListCell<MyClass> call(ListView<MyClass> pokelv) {
				return new PokemonInformationSideView(newpane);
			}
			});
		
		//sideViewBorderPane.setCenter(contentListView);
		
		
		
	}

	public Pane getSideView(){
		return sideViewBorderPane;
	}
	
	
}
