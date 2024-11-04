package com.users.usersapp.dao;

import com.users.usersapp.model.EmployeeSystemAccess;
import com.users.usersapp.rowmappers.EmployeeSystemAccessRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeSystemAccessDao {
    private final JdbcTemplate jdbcTemplate;

    public EmployeeSystemAccessDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //Вывод всех доступов
    public List<EmployeeSystemAccess> findAll() {
        String sql = "SELECT * FROM employee_system_access";
        return jdbcTemplate.query(sql, new EmployeeSystemAccessRowMapper());
    }
    //Создание нового отношения
    public void save(EmployeeSystemAccess employeeSystemAccess) {
        String sql = "INSERT INTO employee_system_access (employee_id, system_id, has_access) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employeeSystemAccess.getEmployeeId(), employeeSystemAccess.getSystemid(),
                employeeSystemAccess.isHasAccess());
    }
    //Редактирование доступа
    public void update(EmployeeSystemAccess employeeSystemAccess) {
        String sql = "UPDATE employee_system_access SET has_access WHERE employee_id = ? AND system_id = ?";
        jdbcTemplate.update(sql, employeeSystemAccess.isHasAccess(), employeeSystemAccess.getEmployeeId(),
                employeeSystemAccess.getSystemid());
    }
}
