package hw10.starter;

import hw10.Convertable;
import hw10.TemperatureMeasurementSystem;

import java.util.Scanner;

public class TemperatureStarter {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в конвертер. Тут ты сможешь переводить температуру из одной системы в другую");
        System.out.println("Введи пожалуйста значение для конвертация:");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextDouble()) {
            String inputValue = scanner.next();
            System.out.printf("Вместо %s ожидали значение температуры как вещественного числа\n", inputValue);
        }
        double value = scanner.nextDouble();
        System.out.println("Введи пожалуйста исходную систему измерений (возможные варианты - C, K, F):");
        String temperatureSystem = scanner.next();
        System.out.println("Введи пожалуйста систему измерений, в которую будет переводено указанное ранее значение (возможные варианты - C, K, F):");
        String destinationTemperatureSystem = scanner.next();
        System.out.printf("Результат: %.2f\n", Convertable.convert(value,
                TemperatureMeasurementSystem.of(temperatureSystem),
                TemperatureMeasurementSystem.of(destinationTemperatureSystem)));
    }
}
