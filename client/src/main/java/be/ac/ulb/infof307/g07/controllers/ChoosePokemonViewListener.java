package be.ac.ulb.infof307.g07.controllers;

import be.ac.ulb.infof307.g07.models.Pokemon;

public interface ChoosePokemonViewListener {
    public void onConfirm(Pokemon pokemon, String date, String time);
}
