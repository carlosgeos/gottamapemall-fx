package be.ac.ulb.infof307.g07;

import be.ac.ulb.infof307.g07.libs.Database;
import be.ac.ulb.infof307.g07.libs.CustomGson;
import be.ac.ulb.infof307.g07.views.PokemonView;
import be.ac.ulb.infof307.g07.views.LocationView;

public class Main {
    public static void main(final String[] args) {
        Database.init();
        CustomGson.create();

        new PokemonView();
        new LocationView();
    }
}
