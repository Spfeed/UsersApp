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
    //Поиск по id сотрудника и id системы
    public EmployeeSystemAccess findById(Integer employeeId, Integer systemId) {
        String sql = "SELECT * FROM employee_system_access WHERE employee_id = ? AND system_id = ?";
        return jdbcTemplate.queryForObject(sql, new EmployeeSystemAccessRowMapper(), employeeId, systemId);
    }
    //Поиск доступов по id сотрудника
    public List<EmployeeSystemAccess> findByEmployeeId(Integer employeeId) {
        String sql = "SELECT * FROM employee_system_access WHERE employee_id = ?";
        return jdbcTemplate.query(sql, new EmployeeSystemAccessRowMapper(), employeeId);
    }
    //Поиск доступов по id системы
    public List<EmployeeSystemAccess> findBySystemId(Integer systemId) {
        String sql = "SELECT * FROM employee_system_access WHERE system_id = ?";
        return jdbcTemplate.query(sql, new EmployeeSystemAccessRowMapper(), systemId);
    }
    //Создание нового отношения
    public void save(EmployeeSystemAccess employeeSystemAccess) {
        String sql = "INSERT INTO employee_system_access (employee_id, system_id, has_access) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employeeSystemAccess.getEmployeeId(), employeeSystemAccess.getSystemId(),
                employeeSystemAccess.isHasAccess());
    }
    //Редактирование доступа
    public void update(EmployeeSystemAccess employeeSystemAccess) {
        String sql = "UPDATE employee_system_access SET has_access = ? WHERE employee_id = ? AND system_id = ?";
        jdbcTemplate.update(sql, employeeSystemAccess.isHasAccess(), employeeSystemAccess.getEmployeeId(),
                employeeSystemAccess.getSystemId());
    }
}
