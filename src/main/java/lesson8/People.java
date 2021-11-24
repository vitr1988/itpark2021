package lesson8;

public class People {

    public static void main(String[] args) {
        Human me = new Male("Иванов Виталий Андреевич", 33, "русский");
        Human nataliaIvanovna = new Female("Петрова Наталья Ивановна", 25, "русская");
        me.beOlder();
        nataliaIvanovna.changeNationality("немка");
        me.changeName("Иванов Виталий");
        nataliaIvanovna.changeName("Меркель Ангела");
        nataliaIvanovna.setAge(67);
        System.out.println(me);
        System.out.println(nataliaIvanovna);
        Human[] people = new Human[]{me, nataliaIvanovna};
        for (Human human : people) {
            human.setAge(40);
        }
        System.out.println("------------");
        System.out.println(me);
        System.out.println(nataliaIvanovna);
        System.out.println("------------");
        ((Male) me).drive();
        ((Female) nataliaIvanovna).cook();

        Female ninaPetrovna = new Female("Сидорова Нина Петровна", 25, "русская");
        ((Female) nataliaIvanovna).changeName(ninaPetrovna);
        System.out.println(ninaPetrovna);

    }
}
