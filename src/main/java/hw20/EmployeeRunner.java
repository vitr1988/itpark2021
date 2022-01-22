package hw20;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw20.dto.Department;
import hw20.dto.Employee;
import hw20.dto.EmployeeWrapper;
import hw20.dto.Position;
import jakarta.xml.bind.JAXB;
import lombok.SneakyThrows;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EmployeeRunner {

    private static final List<Department> DEPARTMENTS = List.of(new Department("IT", "Samara"),
            new Department("Account", "Samara"),
            new Department("Maintenance", "Samara"));

    private static final List<Position> POSITIONS = List.of(new Position("Developer", new BigDecimal(1000)),
            new Position("Tester", new BigDecimal(800)),
            new Position("Senior Developer", new BigDecimal(1500)),
            new Position("Team Leader", new BigDecimal(2000)),
            new Position("IT Director", new BigDecimal(2500))
    );

    private static int COUNTER = 1;

    private static final TypeReference<EmployeeWrapper> TR = new TypeReference<>(){};

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("Запуск программы");
        EmployeeWrapper employees =
                new EmployeeWrapper(List.of(
                        getEmployee("Иванов Виталий Андреевич"),
                        getEmployee("Петров Виктор Леонидович"),
                        getEmployee("Сидорова Алевтина Ивановна"),
                        getEmployee("Михайлов Анатолий Инокентиевич")
                ));
        Path path = Paths.get("D:\\test\\employee.xml");
        Path parentPath = path.getParent();
        System.out.printf("Попытка создания родительской директории %s\n", parentPath);
        if (!parentPath.toFile().exists()) {
            parentPath.toFile().mkdirs();
        }
        System.out.printf("Маршалинг данных в файл %s\n", path.getFileName());
        JAXB.marshal(employees, path.toFile());
        Document document = getDocument(path.toFile());
        Integer averageSalary = getAverageSalary(document);
        System.out.printf("Производим поиск сотрудников со значением зарплаты выше средней %d\n", averageSalary);
        List<String> employeeList = searchEmployeesWithMoreAverageSalary(document, averageSalary);
        System.out.println(employeeList);
        String json = XML.toJSONObject(String.join("", Files.readAllLines(path))).toString();
        Path jsonPath = parentPath.resolve("employee.json");
        System.out.printf("Сохранение данных в файл %s\n", jsonPath.getFileName());
        Files.writeString(jsonPath, json, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        System.out.println("Вывод информации о сотрудниках на нечетных позициях");
        List<Employee> oddEmployees = getOddEmployees(jsonPath);
        System.out.println(oddEmployees);
    }

    @SneakyThrows
    private static List<Employee> getOddEmployees(Path jsonPath) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        EmployeeWrapper employeesFromJson = objectMapper.readValue(jsonPath.toFile(), TR);
        return employeesFromJson.getEmployees().stream().filter(employee -> employeesFromJson.getEmployees().indexOf(employee) % 2 == 1).collect(Collectors.toList());
    }

    private static Employee getEmployee(String fullName) {
        return new Employee().setLogin("user" + COUNTER++)
                .setFullName(fullName)
                .setTabNumber(new Random().nextInt(100_000) + "")
                .setDepartment(DEPARTMENTS.get(new Random().nextInt(DEPARTMENTS.size())))
                .setPosition(POSITIONS.get(new Random().nextInt(POSITIONS.size())));
    }

    @SneakyThrows
    private static List<String> searchEmployeesWithMoreAverageSalary(Document doc, int salary) {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        NodeList nodeList = (NodeList) xPathFactory.newXPath().compile("//employee/position[@salary > " + salary + "]/ancestor::employee/fullName/text()").evaluate(doc, XPathConstants.NODESET);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            result.add(nodeList.item(i).getNodeValue());
        }
        return result;
    }

    @SneakyThrows
    private static Integer getAverageSalary(Document doc) {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        Double result = (Double) xPathFactory.newXPath().compile("sum(//position/@salary) div count(//position)").evaluate(doc, XPathConstants.NUMBER);
        return result != null ? result.intValue() : 0;
    }

    @SneakyThrows
    private static Document getDocument(File file) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        return documentBuilder.parse(file);
    }
}
