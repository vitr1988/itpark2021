package lesson29.dao.impl;

import lesson29.dao.DepartmentDao;
import lesson29.model.Department;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Validated
@Repository
@RequiredArgsConstructor
public class DepartmentDaoJdbc implements DepartmentDao {

    private final NamedParameterJdbcOperations jdbcOperations;
    private final RowMapper<Department> departmentRowMapper =
            (rs, row) -> new Department(rs.getInt("id"), rs.getString("name"));

    @Override
    public List<Department> findAll() {
        //language=SQL
        final String sql = "SELECT d.id, d.name FROM department d";
        return jdbcOperations.query(sql, departmentRowMapper);
    }

    @Override
    public Optional<Department> getById(int departmentId) {
        //language=SQL
        val sql = "SELECT d.id, d.name FROM department d " +
                "where d.id = :departmentId";
        try {
            return Optional.of(jdbcOperations.queryForObject(sql, Map.of("departmentId", departmentId), departmentRowMapper));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public int create(Department department) {
        //language=SQL
        final String sqlQuery = "insert into department (id, name) values (:id, :name)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        final Integer id = department.getId();
        namedParameters.addValue("id", id, Types.INTEGER);
        namedParameters.addValue("name", department.getName(), Types.VARCHAR);
        jdbcOperations.update(sqlQuery, namedParameters);
        return id;
    }

    @Override
    public void update(Department department) {
        //language=SQL
        final String sqlQuery = "update department set name = :name " +
                "where id = :departmentId";
        jdbcOperations.update(sqlQuery, Map.of(
                "departmentId", department.getId(),
                "name", department.getName()));
    }

    @Override
    public void deleteById(int departmentId) {
        //language=SQL
        val sqlQuery = "delete from department d where d.id = :departmentId";
        jdbcOperations.update(sqlQuery, Map.of("departmentId", departmentId));
    }
}
