package hw10.impl;

import hw10.Convertable;
import hw10.TemperatureValue;

public class KelvinToFahrenheitConverter implements Convertable {

    @Override
    public double convert(TemperatureValue value) {
        return (value.getValue() - CelsiusToKelvinConverter.DELTA) * FahrenheitToCelsiusConverter.KOEFFICIENT
                + FahrenheitToCelsiusConverter.DELTA;
    }
}
