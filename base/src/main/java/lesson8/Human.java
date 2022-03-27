package lesson8;

public class Human {

    private String fio;
    private int age;
    private String nationality;

    private Human(String fio) {
        this.fio = fio;
    }

    public Human(String fio, int age, String nationality) {
        this(fio);
        this.age = age;
        this.nationality = nationality;
    }

    public void changeName(String newName) {
        this.fio = newName;
    }

    public String getFio() {
        return fio;
    }

    public void beOlder() {
        this.age++;
    }

    public void changeNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private Integer getAge() {
        return this.age;
    }

    public String getSex() {
        return this instanceof Male ? "Мужчина" : "Женщина";
    }

    @Override
    public String toString() {
        return "Human{" +
                "fio='" + fio + '\'' +
                ", age=" + getAge() +
                ", nationality='" + nationality + '\'' +
                ", sex=" + getSex() +
                '}';
    }
}
