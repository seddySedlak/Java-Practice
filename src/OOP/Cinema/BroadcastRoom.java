package OOP.Cinema;

import java.time.LocalTime;

public class BroadcastRoom {
    int seats;
    int numberOfRoom;
    LocalTime opening;
    LocalTime closing;

    public BroadcastRoom(int seats, int numberOfRoom, LocalTime opening, LocalTime closing) {
        this.seats = seats;
        this.numberOfRoom = numberOfRoom;
        this.opening = opening;
        this.closing = closing;
    }

    @Override
    public String toString() {
        return "" + numberOfRoom;
    }
}
