package OOP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Computers {
    public void run() {
        ArrayList<Computer> computers = new ArrayList<>();
        Computer a = new Computer("HP", 16, 4.1);
        Computer b = new Computer("Dell", 32, 4.6);
        Computer c = new Computer("Asus", 8, 3.9);
        computers.add(a);
        computers.add(b);
        computers.add(c);
//        computers.sort();

        System.out.println(computers);
        Collections.sort(computers);
        System.out.println(computers);

        System.out.println("--------");

        Collections.sort(computers, Computer.BY_CPU);
        //nebo
        computers.sort(Computer.BY_CPU);
        System.out.println(computers);
    }
}

class Computer implements Comparable<Computer>{
    String name;
    int RAM;
    double CPUFreq;
    public static final Comparator<Computer> BY_CPU = new Comparator<Computer>() {
        @Override
        public int compare(Computer o1, Computer o2) {
            return Double.compare(o1.CPUFreq, o2.CPUFreq);
        }
    };
    public static final Comparator<Computer> BY_NAME = new Comparator<Computer>() {
        @Override
        public int compare(Computer o1, Computer o2) {
            return o1.name.compareTo(o2.name);
        }
    };

    public Computer(String name, int RAM, double CPUFreq) {
        this.name = name;
        this.RAM = RAM;
        this.CPUFreq = CPUFreq;
    }

    @Override
    public int compareTo(Computer o) {
        return Integer.compare(this.RAM, o.RAM);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", RAM=" + RAM +
                ", CPUFreq=" + CPUFreq +
                '}';
    }
}
