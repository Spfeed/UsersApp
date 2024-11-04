package com.users.usersapp.dao;

import com.users.usersapp.model.Employee;
import com.users.usersapp.rowmappers.EmployeeRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {
    private final JdbcTemplate jdbcTemplate;

    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //Вывод всех сотрудников
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }
    //Поиск сотрудника по его id
    public Employee findById (Integer id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
    }
    //Добавление нового сотрудника
    public void save(Employee employee) {
        String sql = "INSERT INTO employees (id, fio) VALUES (?, ?)";
        jdbcTemplate.update(sql, employee.getId(), employee.getFio());
    }
    //Редактирование сотрудника
    public void update (Employee employee) {
        String sql = "UPDATE employees SET fio = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getFio(), employee.getId());
    }
    //Удаление сотрудника
    public void delete(Integer id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
