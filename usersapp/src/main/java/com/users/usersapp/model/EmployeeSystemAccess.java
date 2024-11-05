package com.users.usersapp.model;

public class EmployeeSystemAccess {
    private Integer employeeId;
    private Integer systemId;
    private boolean hasAccess;

    public EmployeeSystemAccess() {}

    public EmployeeSystemAccess(Integer employeeId, Integer systemId, boolean hasAccess) {
        this.employeeId = employeeId;
        this.systemId = systemId;
        this.hasAccess = hasAccess;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemid) {
        this.systemId = systemid;
    }

    public boolean isHasAccess() {
        return hasAccess;
    }

    public void setHasAccess(boolean hasAccess) {
        this.hasAccess = hasAccess;
    }
}
