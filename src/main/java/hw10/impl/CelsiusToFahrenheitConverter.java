package hw10.impl;

import hw10.Convertable;
import hw10.TemperatureValue;

import static hw10.impl.FahrenheitToCelsiusConverter.DELTA;
import static hw10.impl.FahrenheitToCelsiusConverter.KOEFFICIENT;

public class CelsiusToFahrenheitConverter implements Convertable {

    @Override
    public double convert(TemperatureValue value) {
        return value.getValue() * KOEFFICIENT + DELTA;
    }
}
