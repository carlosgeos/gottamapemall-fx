package be.ac.ulb.infof307.g07.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.ac.ulb.infof307.g07.models.GeoLocaLisation;

public class TestMetersToDecimalsCoordinates {
    private int distanceMetre1;
    private int distanceMetre2;
    private int distanceMetre3;
    private double coordinate;
    private static final double DELTA = 1e-15;

    
    @Before
    public void setUp() throws Exception {
        distanceMetre1 = 500;  // 0,5Km
        distanceMetre2 = 1000; // 1Km
        distanceMetre3 = 5000; // 5Km
    }

    @Test
    public void test() {
        coordinate = GeoLocaLisation.metersToDecimalsCoordinates(distanceMetre1);
        assertEquals(coordinate, 0.0045, DELTA);
        coordinate = GeoLocaLisation.metersToDecimalsCoordinates(distanceMetre2);
        assertEquals(coordinate, 0.009, DELTA);
        coordinate = GeoLocaLisation.metersToDecimalsCoordinates(distanceMetre3);
        assertEquals(coordinate, 0.045, DELTA);
    }
}
