package lesson8;

public class CatRunner {

    public static void main(String[] args) {
        Cat barsik = new Cat();
        barsik.name = "Барсик";
        barsik.age = 1;
        barsik.poroda = "Персидский";
        barsik.boss = new Boss("Виталий");

        Cat persik = new Cat();
        persik.name = "Барсик";
        persik.age = 1;
        persik.poroda = "Персидский";
        persik.boss = new Boss("Виталий");

        Cat bobik = new Cat();
        Cat malysh = new Cat();
        System.out.println(barsik == persik);
        System.out.println(barsik == bobik);
        System.out.println(barsik == malysh);
        System.out.println("--------------");
        System.out.println(barsik.equals(persik));
    }
}
