package OOP.Hospital;

public class CardiacSurgeon extends Surgeon {
    public CardiacSurgeon(int salary, String name) {
        super(salary, name);
    }

    @Override
    public void cardiacSurgery() {
        salary += 150000;
    }
}
