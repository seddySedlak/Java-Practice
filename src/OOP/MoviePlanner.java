package OOP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MoviePlanner {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("DatedMovies.txt"));
        Movie movie;
        String[] attributes;
        ArrayList<Movie> Movie = new ArrayList<>();
        for (String line : lines) {

            attributes = line.split(";");
            movie = new Movie(attributes[0], Integer.parseInt(attributes[1]), Integer.parseInt(attributes[3]), Double.parseDouble(attributes[2]), LocalDate.parse(attributes[4]));
            Movie.add(movie);
            movie.availableBroadcasts(LocalDate.of(2023, 5, 21));
        }
    }

}
class Movie {
    String name;
    int yearOfRelease, duration;
    double rating;
    LocalDate date;

    public Movie(String name, int yearOfRelease, int duration, double rating, LocalDate date) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.duration = duration;
        this.rating = rating;
        this.date = date;
    }

    void availableBroadcasts(LocalDate someDate) {
        if (date.isAfter(someDate.minusDays(1)) && date.isAfter(someDate.plusDays(7))) {
            System.out.println(name + " " + date.toString());
        }
        else {
            System.out.println("nope");
        }
    }
}
