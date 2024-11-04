package com.users.usersapp.rowmappers;

import com.users.usersapp.model.EmployeeSystemAccess;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeSystemAccessRowMapper implements RowMapper<EmployeeSystemAccess> {
    @Override
    public EmployeeSystemAccess mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeSystemAccess employeeSystemAccess = new EmployeeSystemAccess();
        employeeSystemAccess.setEmployeeId(rs.getInt("employee_id"));
        employeeSystemAccess.setSystemid(rs.getInt("system_id"));
        employeeSystemAccess.setHasAccess(rs.getBoolean("has_access"));
        return employeeSystemAccess;
    }
}
