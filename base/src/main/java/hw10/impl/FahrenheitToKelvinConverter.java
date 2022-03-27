package hw10.impl;

import hw10.Convertable;
import hw10.TemperatureValue;

public class FahrenheitToKelvinConverter implements Convertable {
    @Override
    public double convert(TemperatureValue value) {
        return (value.getValue() - FahrenheitToCelsiusConverter.DELTA) / FahrenheitToCelsiusConverter.KOEFFICIENT + CelsiusToKelvinConverter.DELTA;
    }
}
