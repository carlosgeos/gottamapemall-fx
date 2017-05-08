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
        String query = "?";
        if (this.name != null) {
            query += "search=" + this.name + "&";
        }

        if (this.weight != -1) {
            query += "weight=" + Integer.toString(this.weight) + "&";
        }

        if (this.height != -1) {
            query += "height=" + Integer.toString(this.height) + "&";
        }

        if (this.base_experience != -1) {
            query += "base_experience=" + Integer.toString(this.base_experience);
        }

        return query; 
    }
}
