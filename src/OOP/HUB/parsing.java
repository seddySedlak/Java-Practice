package OOP.HUB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class parsing {
    public void run() {
        ArrayList<Countries> countriesArrayList = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("files/countries.txt"));
            Countries country;
            String[] attributes;
            for (String line : lines) {
                attributes = line.split(";");
                country = new Countries(attributes[0], attributes[1],
                        Integer.parseInt(attributes[2]), Double.parseDouble(attributes[3]));
                countriesArrayList.add(country);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Collections.sort(countriesArrayList, Countries.BY_NAME);
        System.out.println(countriesArrayList);
        Collections.sort(countriesArrayList, Countries.BY_YEAR.reversed());
        System.out.println(countriesArrayList);
        Collections.sort(countriesArrayList, Countries.BY_PEOPLE.reversed());
        for (int i = 0; i < 10; i++) {
            System.out.println(countriesArrayList.get(i));
        }
    }
}

class Countries {
    String name;
    String continent;
    int people;
    double year;

    public static final Comparator<Countries> BY_NAME = new Comparator<Countries>() {
        @Override
        public int compare(Countries o1, Countries o2) {
            return o1.name.compareTo(o2.name);
        }
    };

    public static final Comparator<Countries> BY_YEAR = new Comparator<Countries>() {
        @Override
        public int compare(Countries o1, Countries o2) {
            return Double.compare(o1.year, o2.year);
        }
    };
    public static final Comparator<Countries> BY_PEOPLE = new Comparator<Countries>() {
        @Override
        public int compare(Countries o1, Countries o2) {
            return Integer.compare(o1.people, o2.people);
        }
    };

    public Countries(String name, String continent, int people, double year) {
        this.name = name;
        this.continent = continent;
        this.people = people;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", people=" + people +
                ", year=" + year +
                '}';
    }
}
