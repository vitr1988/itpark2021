package lesson25;

import lesson25.entity.Department;
import lesson25.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class JpaRunner {

    private static final Configuration CONFIG;

    static {
        // SessionFactory in Hibernate 5 example
        CONFIG = new Configuration();
        CONFIG.configure();
    }

    public static void main(String[] args) {
        runInsideSession(session -> {
            Department department = new Department();
            department.setId(12);
            department.setName("Development department");
            session.save(department);
            System.out.println(department);

            Employee employee = new Employee();
            employee.setEmpName("Ivanov Vitalii");
            employee.setDepartment(department);
            employee.setSalary(new BigDecimal("1000000"));
            session.save(employee);
        });

        runInsideSession(session -> {
            final Department firstDepartment = session.find(Department.class, 188);
            System.out.println(firstDepartment.getEmployees());


            Query<Employee> searchQuery = session.createQuery("from Employee where empName like :name", Employee.class);
            searchQuery.setParameter("name", "Iva%");
            searchQuery.getResultList().forEach(System.out::println);

        });
    }

    public static void runInsideSession(Consumer<Session> consumer) {
        try (final Session session = getCurrentSessionFromConfig()) {
            Transaction transaction = session.beginTransaction();
            consumer.accept(session);
            transaction.commit();
        }
    }

    public static Session getCurrentSessionFromConfig() {
        // local SessionFactory bean created
        SessionFactory sessionFactory = CONFIG.buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }
}
