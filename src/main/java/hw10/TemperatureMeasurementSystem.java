package hw10;

public enum TemperatureMeasurementSystem {
    CELSIUS("C"), KELVIN("K"), FAHRENHEIT("F");

    private final String shortName;

    TemperatureMeasurementSystem(String shortName) {
        this.shortName = shortName;
    }

    public static TemperatureMeasurementSystem of(String input) {
        for (TemperatureMeasurementSystem measurementSystem : values()) {
//            if (Objects.equals(measurementSystem.shortName, input)) {
            if (measurementSystem.shortName.equalsIgnoreCase(input)) {
                return measurementSystem;
            }
        }
        return CELSIUS;
    }
}
