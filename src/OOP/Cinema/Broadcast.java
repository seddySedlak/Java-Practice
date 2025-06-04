package OOP.Cinema;

import java.time.LocalDateTime;
import java.util.Comparator;

public class Broadcast {
    Movie movie;
    BroadcastRoom room;
    LocalDateTime time;

    public Broadcast(Movie movie, BroadcastRoom room, LocalDateTime time) {
        this.movie = movie;
        this.room = room;
        this.time = time;
    }

    LocalDateTime getEndOfBroadcast() {
        return time.plusSeconds(movie.duration);
    }

    public static final Comparator<Broadcast> BY_TIME = new Comparator<Broadcast>() {
        @Override
        public int compare(Broadcast o1, Broadcast o2) {
            return o1.time.compareTo(o2.time);
        }
    };

    @Override
    public String toString() {
        return time.toLocalDate() + " - " + movie.name + " (" + movie.year + ") will be broadcast in the room " + room.numberOfRoom + " from " + time.getHour() + ":" + time.getMinute() + " to " + getEndOfBroadcast().toLocalTime();
    }
}
