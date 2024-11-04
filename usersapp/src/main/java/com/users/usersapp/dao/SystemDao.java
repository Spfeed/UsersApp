package com.users.usersapp.dao;

import com.users.usersapp.model.System;
import com.users.usersapp.rowmappers.SystemRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SystemDao {
    private final JdbcTemplate jdbcTemplate;

    public SystemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //Вывод всех систем
    public List<System> findAll() {
        String sql = "SELECT * FROM systems";
        return jdbcTemplate.query(sql, new SystemRowMapper());
    }
    //Поиск системы по ее id
    public System findById(Integer id) {
        String sql = "SELECT * FROM systems WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new SystemRowMapper(), id);
    }
    //Добавление новой системы
    public void save(System system) {
        String sql = "INSERT INTO systems (id, name) VALUES (?, ?)";
        jdbcTemplate.update(sql, system.getId(), system.getName());
    }
    //Редактирование системы
    public void update(System system) {
        String sql = "UPDATE systems SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, system.getName(), system.getId());
    }
    //Удаление системы
    public void delete(Integer id) {
        String sql = "DELETE FROM systems WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
