package hw10.impl;

import hw10.Convertable;
import hw10.TemperatureValue;

public class CelsiusToKelvinConverter implements Convertable {

    public static final double DELTA = 273.15;

    @Override
    public double convert(TemperatureValue value) {
        return value.getValue() + DELTA;
    }
}
