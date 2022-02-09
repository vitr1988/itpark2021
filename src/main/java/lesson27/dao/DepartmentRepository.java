package lesson27.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
@RequiredArgsConstructor
public class DepartmentRepository {

    private final Connection connection;

    public Connection getConnection() {
        return connection;
    }
}
