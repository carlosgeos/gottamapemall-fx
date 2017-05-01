package be.ac.ulb.infof307.g07.Views;

import be.ac.ulb.infof307.g07.Controllers.Handlers.GeoLocalisationSliderChangeHandler;
import javafx.scene.control.Slider;

public class GeoLocalisationView {

	
	public static Slider createView(double width, double height){
	
		double sliderwidth = width-15;
		double sliderheight = 45;
		
		Slider slider = new Slider();
		slider.setMin(0);
		slider.setMax(2000);
		slider.setValue(100);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(500);
		slider.setMinorTickCount(0);
		slider.setBlockIncrement(500);
		slider.setSnapToTicks(true);
		slider.setMaxSize(sliderwidth, sliderheight);
		slider.setPrefSize(sliderwidth, sliderheight);
		slider.setMinSize(sliderwidth, sliderheight);
		
		slider.valueProperty().addListener(new GeoLocalisationSliderChangeHandler());
	
		return slider;
	}
	
}
