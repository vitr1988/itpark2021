package lesson8;

public class Female extends Human {

    public Female(String fio, int age, String nationality) {
        super(fio, age, nationality);
    }

    public void cook() {
        System.out.println("Женщина умеет готовить");
    }

    @Override
    public void changeName(String newName) {
        super.changeName(newName);
        System.out.println("Женщина сменила себе имя");
    }

    public void changeName(Female female) {
//        this.changeName(female.getFio());
        female.changeName(getFio());
    }

}
