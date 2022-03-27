package lesson3;

public class StandardPrimitives {

    public static void main(String[] args) {
        byte argument = 123; //-128...-10123...127    - 2 ^ 7  .. 2 ^ 7 - 1
        byte errorDigit = (byte) 130;
        byte digit = (byte) (28 + 100);
        System.out.println(errorDigit);

        short anotherDigit = 768; // - 2 ^ 15.. 2 ^ 15 - 1
        int arg = Integer.MAX_VALUE; // -2 ^ 31...2 ^ 31 -1
        System.out.println(arg);
        long bigValue = 2147483648L; // - 2 ^ 63 .. 2 ^ 63 - 1

        char symbol = 'Я'; // 1071 .. 16битный 0..2 ^ 16 - 1
        System.out.println(symbol + 1);

        double digitWithPoint = 3.14; // 64 битный
        float floatValue = 100.25F; // 32 битный

        boolean flag = true; // истина
        boolean lie = false; // ложь
        boolean value = 100 != 1_000_000;
        boolean notValue = !value;
        boolean trueValue = true != false; // не рекомендуется используется
        boolean complexAnd = (100 == 100) && (125 == 125); // true = true & true
        boolean complexOr = (100 == 100) || (125 == 125); // true = true | true

        if (value) {
            System.out.println("Переменная value истинна");
        } else {
            System.out.println("Переменная value ложна");
        }

        double floatingPointValue = 1.5;
        if (2.5 == floatingPointValue) {
            System.out.println("2.5 равно " + floatingPointValue);
        } else if (1 == 1) {
            System.out.println("2.5 не равно " + floatingPointValue + ", но 1 = 1");
        } else {
            System.out.println("2.5 не равно " + floatingPointValue);
        }

        boolean bool1 = floatingPointValue != 0 && (100 / floatingPointValue == 10);

        if (bool1 != true) { // так делать не стоит, лучше пользоваться !

        } else {

        }
    }
}
