package hw8.animal.starter;

import hw8.animal.Animal;
import hw8.animal.Cat;
import hw8.animal.Cow;
import hw8.animal.Dog;

public class AnimalRunner {

    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Cow cow = new Cow();

        Animal[] animals = new Animal[]{cat, dog, cow};
        for (Animal animal : animals) {
            animal.voice();
        }
    }
}
