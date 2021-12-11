package hw10.impl;

import hw10.Convertable;
import hw10.TemperatureValue;

public class FahrenheitToCelsiusConverter implements Convertable {

    public static final int DELTA = 32;

    public static final double KOEFFICIENT = 1.8; // 9 / 5

    @Override
    public double convert(TemperatureValue value) {
        return (value.getValue() - DELTA) / KOEFFICIENT;
    }
}
