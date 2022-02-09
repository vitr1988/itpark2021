package lesson27.dao.impl;

import lesson24.dto.Employee;
import lesson27.dao.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
@Scope(value = "prototype", proxyMode = ScopedProxyMode.INTERFACES)
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Connection connection;

//    @Value("${jdbc.url}") - не заработает не при каких условиях
    private static String jdbc;

    @SneakyThrows
    public void save(Employee employee) {
        final boolean autoCommit = connection.getAutoCommit();
        System.out.println("Проверка свойства автокоммита: " + autoCommit);
        System.out.println("Значение из статичного поля: " + jdbc);
    }

    @Autowired
    public void setJdbc(@Value("${jdbc.url}") String value) {
        EmployeeRepositoryImpl.jdbc = value;
    }

}
