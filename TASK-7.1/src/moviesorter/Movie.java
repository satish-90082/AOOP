package moviesorter;  // Define the package

import java.util.*;

public class Movie implements Comparable<Movie> {
    private double rating;
    private String name;
    private int year;

    // Constructor
    public Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    // Getter methods
    public String getName() { return name; }
    public double getRating() { return rating; }
    public int getYear() { return year; }

    // Implement compareTo() to sort by year
    @Override
    public int compareTo(Movie m) {
        return this.year - m.year; // Ascending order (Oldest to Newest)
    }
}
