package hw10.impl;

import hw10.Convertable;
import hw10.TemperatureValue;

import static hw10.impl.CelsiusToKelvinConverter.DELTA;

public class KelvinToCelsiusConverter implements Convertable {

    @Override
    public double convert(TemperatureValue value) {
        return value.getValue() - DELTA;
    }
}
