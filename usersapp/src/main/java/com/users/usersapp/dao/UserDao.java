package com.users.usersapp.dao;

import com.users.usersapp.model.User;
import com.users.usersapp.rowmappers.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //Вывод всех пользователей
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE LOWER (username) = LOWER (?)";
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), username);
    }
}
