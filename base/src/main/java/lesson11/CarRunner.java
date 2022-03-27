package lesson11;

public class CarRunner {
    public static void main(String[] args) {
        Car car = new Car();
        car.setDistance(100_000);
        car.setMark("Skoda");
        car.setModel("Rapid");
        car.setEngine(car.new Engine(1.4));
//        car.setEngine(new Car.Engine(1.4));

        car.new Engine(1.6);
//        new Car.Engine(1.6);
        try {
            Object carClone = car.clone();
            System.out.println(car);
            System.out.println(carClone);
        } catch (CloneNotSupportedException e) {
            System.out.println("Клонирования для объекта класса Car не поддерживается");
        }
    }
}
