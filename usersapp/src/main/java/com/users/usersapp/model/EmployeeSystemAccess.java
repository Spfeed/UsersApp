package com.users.usersapp.model;

public class EmployeeSystemAccess {
    private Integer employeeId;
    private Integer systemid;
    private boolean hasAccess;

    public EmployeeSystemAccess() {}

    public EmployeeSystemAccess(Integer employeeId, Integer systemid, boolean hasAccess) {
        this.employeeId = employeeId;
        this.systemid = systemid;
        this.hasAccess = hasAccess;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getSystemid() {
        return systemid;
    }

    public void setSystemid(Integer systemid) {
        this.systemid = systemid;
    }

    public boolean isHasAccess() {
        return hasAccess;
    }

    public void setHasAccess(boolean hasAccess) {
        this.hasAccess = hasAccess;
    }
}
