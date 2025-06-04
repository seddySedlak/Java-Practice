package OOP.Hospital;

public class Doctor {
    int salary;
    String name;

    public Doctor(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }
    public void diagnosis(){
        salary += 35000;
    }
    public void surgery(){
        System.out.println("Can't do that");
    }
    public void cardiacSurgery(){
        System.out.println("Can't do that");
    }

}
