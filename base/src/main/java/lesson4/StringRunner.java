package lesson4;

public class StringRunner {
    public static void main(String[] args) {
        String text = "Война и мир. Начало и конец";
        text += ". Новая фраза\n\t\r"; // text = text + ". Новая фраза"
        String str = "Hello, World \\";
        System.out.println(str);
        short value = 120;
        value += 545656;
        System.out.println("Значение переменной value = " + value);
    }
}
