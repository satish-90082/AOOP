package moviesorter; 
import java.util.*;
public class MovieSorterMain {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();

       
        movies.add(new Movie("Interstellar", 8.6, 2014));
        movies.add(new Movie("Inception", 8.8, 2010));
        movies.add(new Movie("The Dark Knight", 9.0, 2008));
        movies.add(new Movie("Titanic", 7.8, 1997));
        movies.add(new Movie("Avengers: Endgame", 8.4, 2019));

        
        Collections.sort(movies);

        System.out.println("Movies sorted by release year:");
        for (Movie movie : movies) {
            System.out.println(movie.getYear() + " - " + movie.getName() + " (Rating: " + movie.getRating() + ")");
        }
    }
}