package hw8.animal;

public class Dog extends Animal {

    private static final String DOG_CATEGORY = "Собака";

    public Dog() {
        super(DOG_CATEGORY);
    }

    @Override
    public void voice() {
        System.out.println(this.name + " умеет гавкать");
    }
}
