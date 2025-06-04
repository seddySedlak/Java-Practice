package OOP.Cinema;

public class Movie {
    String name;
    int year, duration;
    double rating;

    public Movie(String name, int year, double rating, int duration) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return name;
    }


}
