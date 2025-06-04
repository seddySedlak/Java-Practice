package OOP.Cinema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Schedule {
    ArrayList<Broadcast> broadcasts;
    ArrayList<Movie> moviePool;
    ArrayList<BroadcastRoom> roomPool;

    public Schedule(ArrayList<Movie> moviePool, ArrayList<BroadcastRoom> roomPool) {
        this.broadcasts = new ArrayList<>();
        this.moviePool = moviePool;
        this.roomPool = roomPool;
    }

    boolean insertBroadcast(Movie movie, BroadcastRoom room, LocalDateTime time) {
        Broadcast toCheck = new Broadcast(movie, room, time);
        if (!(toCheck.time.toLocalTime().isAfter(toCheck.room.opening) || toCheck.getEndOfBroadcast().toLocalTime().isBefore(toCheck.room.opening))) {
            System.out.println("room is not open yet");
            return false;
        }
        for (Broadcast broadcast : broadcasts) {
            if (broadcast.room.numberOfRoom == toCheck.room.numberOfRoom) {
                if (broadcast.time.getDayOfYear() == toCheck.time.getDayOfYear()) {
                    if (!(toCheck.time.isAfter(broadcast.getEndOfBroadcast()) || toCheck.getEndOfBroadcast().isBefore(broadcast.time))) {
                        System.out.println("broadcasts must not overlap");
                        return false;
                    }
                }
            }
        }
        System.out.println("movie was added to schedule");
        broadcasts.add(toCheck);
        return true;
    }

    // metoda pro výběr akce (hub)
    public void hub() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome, here you will add and review movies in the cinema. ");
        System.out.println("There are only 2 rules: ");
        System.out.println("1. Read!");
        System.out.println("2. Don't be an asshole and write it according to what is written in the instructions!\n");
        do {
            System.out.println("choose:");
            System.out.println("0 : exit");
            System.out.println("1 : add new movie");
            System.out.println("2 : view schedule");
            String choose = sc.nextLine();
            switch (choose) {
                case "0":
                    System.out.println("You are leaving from hub.");
                    sc.close();
                    return;
                case "1":
                    System.out.println("You are going to add movie.");
                    addMovie(sc);
                    break;
                case "2":
                    System.out.println("You are going to look at the schedule.");
                    getSchedule(sc);
                    break;
                default:
                    System.out.println("The specified option does not exist. Try it again!\n");
                    hub();
                    break;
            }
        } while (true);
    }

    private void addMovie(Scanner sc) {
        Movie movie = null;
        BroadcastRoom room = null;
        LocalDateTime time = null;
        String input;
        boolean check = false;

        for (Movie mv : moviePool) {
            System.out.println(mv);
        }
        do {
            System.out.println("\nchoose movie:");
            input = sc.nextLine();
            for (Movie mv : moviePool) {
                if (input.equals(mv.name)) {
                    movie = mv;
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println("movie not found");
            }
        } while (!check);
        check = false;

        for (BroadcastRoom br : roomPool) {
            System.out.println(br);
        }
        do {
            System.out.println("\nchoose room:");
            input = sc.nextLine();
            for (BroadcastRoom br : roomPool) {
                if (input.equals(String.valueOf(br.numberOfRoom))) {
                    room = br;
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println("room not found");
            }
        } while (!check);
        check = false;

        do {
            try {
                time = joinDateTime(sc);
                check = true;
            } catch (DateTimeParseException e) {
                System.out.println("incorrect format");
            }
        } while (!check);
        insertBroadcast(movie, room, time);
    }

    private LocalDateTime joinDateTime(Scanner sc) {
        LocalDate date = null;
        LocalTime time = null;
        String input;

        System.out.println("\nbroadcasting date: (year-month-day)");
        input = sc.nextLine();
        date = LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-M-d"));

        System.out.println("\nbroadcasting time: (hour:minute)");
        input = sc.nextLine();
        time = LocalTime.parse(input, DateTimeFormatter.ofPattern("H:mm"));
        return LocalDateTime.of(date, time);
    }

    private void getSchedule(Scanner sc) {
        Collections.sort(broadcasts, Broadcast.BY_TIME);
        if (broadcasts.isEmpty()) {
            System.out.println("Nothing here");
        } else {
            for (Broadcast br : broadcasts) {
                System.out.println(br.toString());
            }
        }
        System.out.println();
    }
}

