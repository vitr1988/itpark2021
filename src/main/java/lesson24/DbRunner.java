package lesson24;

import lesson24.dto.Employee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class DbRunner {
    private static final Properties DB_SETTINGS = new Properties();

    static {
        try {
            DB_SETTINGS.load(DbRunner.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException, IOException {
        System.out.println(getEmployeeById(1));
    }

    private static List<Employee> getEmployeeById(Integer id) throws SQLException {
        try (final Connection connection = DriverManager.getConnection(
                DB_SETTINGS.getProperty("jdbc.url"),
                DB_SETTINGS.getProperty("db.login"),
                DB_SETTINGS.getProperty("db.password"));
             final Statement st = connection.createStatement();
             final PreparedStatement statement = connection.prepareStatement(
                     """
                             select e.emp_id, e.emp_name, e.salary, d.name department_name 
                             from employee e 
                             left join department d 
                             on e.department_id = d.id 
                             where e.emp_id = ?
                             """) // -1 or (d)
        ) {
            connection.setAutoCommit(false);
            Savepoint beforeCreate = connection.setSavepoint("beforeCreate");

            st.execute("insert into department (id, name) values (156, 'New')");

            Savepoint beforeUpdate = connection.setSavepoint("beforeUpdate");

            st.execute("update department set name = 'New2' where id = 156");

            statement.setInt(1, id);
            List<Employee> employees = new ArrayList<>();
            try (final ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Employee employee = new Employee(resultSet.getInt("emp_id"), resultSet.getString("emp_name"),
                            resultSet.getBigDecimal("salary"), resultSet.getString("department_name"));
                    employees.add(employee);
                    if (new Random().nextBoolean()) {
                        connection.rollback(beforeUpdate);
                    }
                }
            }
            connection.commit();
            return employees;
        }
    }
}
