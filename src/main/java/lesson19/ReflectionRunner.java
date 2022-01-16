package lesson19;

import lesson10.inheritance.C;
import lesson19.dto.Car;
import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionRunner {

    @SuppressWarnings({"deprecation", "rawtypes"})
    public static void main(String[] args) throws Exception {
        Object car = new Car("Skoda", "Octavia", 1.6d);
        Class<?> aClass = car.getClass();
        Class<Car> carClass = Car.class;
        Class thirdClass = Class.forName("lesson19.dto.Car");
        Car castingCar = carClass.cast(car);
        Constructor<?>[] constructors = carClass.getConstructors();
        System.out.println("Конструкторы класса: " + carClass.getName() + Arrays.toString(constructors));
        System.out.println("Все методы класса: " + carClass.getName() + Arrays.toString(carClass.getDeclaredMethods()));
        System.out.println("Публичные методы класса: " + carClass.getName() + Arrays.toString(carClass.getMethods()));
        Field[] declaredFields = carClass.getDeclaredFields();
        System.out.println("Все поля класса: " + carClass.getName() + Arrays.toString(declaredFields));
        System.out.println("Публичные поля класса: " + carClass.getName() + Arrays.toString(carClass.getFields()));
        Car oldCar = carClass.newInstance();
        Constructor<Car> carConstructor = getConstructor(constructors);
        Car skodaFabia = carConstructor.newInstance("Skoda", "Fabia", 1.6d, 1d);
        System.out.println(skodaFabia);
        Field modelField = declaredFields[1];
        modelField.setAccessible(true);
        modelField.set(skodaFabia, "Rapid");
        System.out.println("Измененный авто: " + skodaFabia);
        Field declaredField = declaredFields[2];
        declaredField.setAccessible(true);
        System.out.println("Ширина авто: " + declaredField.getDouble(skodaFabia));
//        System.out.println("Ширина авто: " + carClass.getDeclaredField("width").getDouble(skodaFabia));

        Method getMarkAndModelMethod = carClass.getDeclaredMethod("getMarkAndModel", int.class);
        getMarkAndModelMethod.setAccessible(true);
        String markAndModel = (String) getMarkAndModelMethod.invoke(skodaFabia, 1);
        System.out.println(markAndModel);

        ClassLoader classLoader = carClass.getClassLoader();
        System.out.println(classLoader.getName());
    }

    private static Constructor<Car> getConstructor(Constructor<?>[] constructors) {
        Constructor<Car> carConstructor = null;
        for (Constructor constructor: constructors) {
            if (constructor.getParameterTypes().length != 0) {
                carConstructor = constructor;
                break;
            }
        }
        return carConstructor;
    }
}
