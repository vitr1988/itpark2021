package lesson10.inheritance;

public class A {

    private String str = "";
    private static String GLOBAL_STR = "Пример";

//    {
//        str = "Test";
//    }
    static {
        GLOBAL_STR = "";
    }

    public A() {
        System.out.println("Вызван конструктор класса A");
    }

    void print1() {

    }
}
