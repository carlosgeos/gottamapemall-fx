package be.ac.ulb.infof307.g07;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
