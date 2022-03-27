package lesson11;

public class Car implements Cloneable {

    private Engine engine;
    private double distance;
    private String mark;
    private String model;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Car clone = (Car) super.clone();
        clone.setEngine(this.engine.clone());
        return clone;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", distance=" + distance +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public /*static*/ class Engine implements Cloneable {

        private double volume;

        public Engine(double volume) {
            this.volume = volume;
        }

        @Override
        protected Engine clone() throws CloneNotSupportedException {
            return (Engine) super.clone();
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "volume=" + volume +
                    '}';
        }
    }

}
