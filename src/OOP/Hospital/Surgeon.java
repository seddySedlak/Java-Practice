package OOP.Hospital;

public class Surgeon extends Doctor{
    public Surgeon(int salary, String name) {
        super(salary, name);
    }
    //polymorfismus @Override


    @Override
    public void surgery() {
        salary += 80000;
    }
}
