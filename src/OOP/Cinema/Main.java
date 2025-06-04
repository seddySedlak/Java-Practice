package OOP.Cinema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("No arguments!");
            System.exit(0);
        }

        Schedule programme = new Schedule(loadMovies(args[0]), loadRooms()); //args[0]
        programme.hub();
    }

    static ArrayList<Movie> loadMovies(String path) throws IOException {
        ArrayList<Movie> movies = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(path));
        Movie m;
        String[] attributes;
        for (String line : lines) {
            attributes = line.split(";");
            m = new Movie(attributes[0], Integer.parseInt(attributes[1]), Double.parseDouble(attributes[2]), Integer.parseInt(attributes[3]));
            movies.add(m);
        }
        return movies;
    }

    static ArrayList<BroadcastRoom> loadRooms() {
        ArrayList<BroadcastRoom> rooms = new ArrayList<>();
        rooms.add(new BroadcastRoom(80, 1, LocalTime.of(13, 0), LocalTime.of(23, 59)));
        rooms.add(new BroadcastRoom(100, 2, LocalTime.of(16, 0), LocalTime.of(23, 59)));
        return rooms;
    }
}
