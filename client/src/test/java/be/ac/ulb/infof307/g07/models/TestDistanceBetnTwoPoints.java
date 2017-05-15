package be.ac.ulb.infof307.g07.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.ac.ulb.infof307.g07.models.GeoLocaLisation;

public class TestDistanceBetnTwoPoints {
    private double lon1, lat1, lon2, lat2, res;
    private static final double DELTA = 1e-15;

    
    @Before
    public void setUp() throws Exception {
        lon1 = 0.0;
        lat1 = 0.0;
        lon2 = 0.0009;
        lat2 = 0.0;
    }

    @Test
    public void test() {
        res = GeoLocaLisation.distanceBetweenTwoPoints(lon1,lat1,lon2,lat2);
        assertEquals(res, 0.0009, DELTA);
    }

}
