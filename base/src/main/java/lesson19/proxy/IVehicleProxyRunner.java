package lesson19.proxy;

import lesson19.DefaultValue;
import lesson19.dto.Car;
import lesson19.dto.IVehicle;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;

public class IVehicleProxyRunner {

    public static void main(String[] args) {
        Car car = new Car("Lada", "Granta", 1.1);
        IVehicle vehicle = (IVehicle) Proxy.newProxyInstance(IVehicleProxyRunner.class.getClassLoader(),
                new Class[]{IVehicle.class},
                new ProxyHandler(car));

        System.out.println("Пример использования аннотации в качестве параметра метода: " + vehicle.getHeigth());
        System.out.println("Пример использования аннотации над методом: " + vehicle.getMarkAndModel(null));

        Car golf = new Car("VW", "Golf", 1.8);
        golf.setHeigth(1.2);
        IVehicle proxyGolf = (IVehicle) Proxy.newProxyInstance(IVehicleProxyRunner.class.getClassLoader(),
                new Class[]{IVehicle.class},
                new ProxyHandler(golf));

        System.out.println("Пример использования аннотации в качестве параметра метода: " + proxyGolf.getHeigth());
        System.out.println("Пример использования аннотации над методом: " + proxyGolf.getMarkAndModel(125));
    }

    @RequiredArgsConstructor
    private static class ProxyHandler implements InvocationHandler {

        private final IVehicle origin;

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Method declaredMethod = origin.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
            Parameter[] parameters = declaredMethod.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                DefaultValue de = parameter.getAnnotation(DefaultValue.class);
                if (args[i] == null) {
                    args[i] = Integer.decode(de.value());
                }
            }
            DefaultValue annotation = declaredMethod.getAnnotation(DefaultValue.class);
            Object result = declaredMethod.invoke(origin, args);
            if (result == null && annotation != null) {
                return Double.valueOf(annotation.value());
            }
            return result;
        }
    }
}
