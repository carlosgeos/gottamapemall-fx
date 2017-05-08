package be.ac.ulb.infof307.g07.models;                             

public class FilterModel {
    private String name;
    private String[] types;
    private int weight;
    private int height;
    private int base_experience;
    private String fname;

    public FilterModel (String name, String[] types, int weight, int height, int base_experience) {
        this.name = name;
        this.types = types;
        this.weight = weight;
        this.height = height;
        this.base_experience = base_experience;
    }

    public String createQuery () {
        return ""; 
    }
}
