package com.users.usersapp.rowmappers;

import com.users.usersapp.model.System;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SystemRowMapper implements RowMapper<System> {
    @Override
    public System mapRow(ResultSet rs, int rowNum) throws SQLException {
        System system = new System();
        system.setId(rs.getInt("id"));
        system.setName(rs.getString("name"));
        return system;
    }
}
