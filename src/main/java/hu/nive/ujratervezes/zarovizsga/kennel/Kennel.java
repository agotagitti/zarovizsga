package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
        //egyediség vizsgálat
    }

    public void feedAll() {
        for (Dog actualDog : dogs) {
            actualDog.feed();
        }
    }

    public Dog findByName(String name) {
        for (Dog actualDog : dogs) {
            if (actualDog.getName().equalsIgnoreCase(name)) {
                return actualDog;
            }
        }
        throw new IllegalArgumentException("Cannot find " + name);
    }

    public void playWith(String name, int hours) {
        findByName(name).play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness) {
        List<String> dogNames = new ArrayList<>();
        for (Dog actualDog : dogs) {
            if (actualDog.getHappiness() > minHappiness) {
                dogNames.add(actualDog.getName());
            }
        }
        return dogNames;
    }

}
