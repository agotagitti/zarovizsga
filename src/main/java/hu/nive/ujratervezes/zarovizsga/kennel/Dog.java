package hu.nive.ujratervezes.zarovizsga.kennel;

public abstract class Dog {

    private String name;
    int happiness;

    public Dog(String name) {
        this.name = name;
        this.happiness = 0;
    }

    abstract void feed();

    abstract void play(int hours);

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }
}
