package lesson20.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lesson20.dto.Account;
import lesson20.dto.Car;
import lesson20.dto.CarWrapper;
import lesson20.dto.Owner;

import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class JAXBRunner {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        car.setMark("Porsche");
        car.setModel("Tycan");
        car.setPrice(new BigDecimal("100000"));
        car.setOwner(new Owner("Крутой дядька"));

        Car anotherCar = new Car();
        anotherCar.setMark("Lada");
        anotherCar.setModel("Kalina");
        anotherCar.setPrice(new BigDecimal("10000"));
        anotherCar.setOwner(new Owner("Не самый крутой дядька"));

        CarWrapper carWrapper = new CarWrapper();
        carWrapper.setCars(Arrays.asList(car, anotherCar));

        writeToXML(carWrapper);
//        writeToXML(car);
//        Car unmarshallingCar = getCar("""
//                <auto m="Porsche" ml="Tycan" price="100000">
//                            <driver>
//                                <fullName>Крутой дядька</fullName>
//                            </driver>
//                        </auto>
//                """);
//        System.out.println(unmarshallingCar);

        System.out.println(getCars("""
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <cars>
                    <car ml="Tycan" price="100000" m="Porsche">
                        <driver>
                            <fullName>Крутой дядька</fullName>
                        </driver>
                    </car>
                    <car ml="Kalina" price="10000" m="Lada">
                        <driver>
                            <fullName>Не самый крутой дядька</fullName>
                        </driver>
                    </car>
                </cars>
                """));
    }

    private static void writeToXML(CarWrapper car) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CarWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(car, stringWriter);
        System.out.println("XML: " + stringWriter);
    }

    private static void writeToXML(Car car) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(car, stringWriter);
        System.out.println("XML: " + stringWriter);
    }

    public static Car getCar(String xmlContent) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Car.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Car) unmarshaller.unmarshal(new StringReader(xmlContent));
    }

    public static List<Car> getCars(String xmlContent) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CarWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        CarWrapper result = (CarWrapper) unmarshaller.unmarshal(new StringReader(xmlContent));
        return result == null ? null : result.getCars();
    }
}
