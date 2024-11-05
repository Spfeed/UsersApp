package com.users.usersapp.dto;

import java.util.List;

public class EmployeeAccessDto {
    private Integer employeeId;
    private String employeeFio;
    private List<SystemAccess> systemAccesses;

    public EmployeeAccessDto(Integer employeeId, String employeeFio, List<SystemAccess> systemAccesses) {
        this.employeeId = employeeId;
        this.employeeFio = employeeFio;
        this.systemAccesses = systemAccesses;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFio() {
        return employeeFio;
    }

    public void setEmployeeFio(String employeeFio) {
        this.employeeFio = employeeFio;
    }

    public List<SystemAccess> getSystemAccesses() {
        return systemAccesses;
    }

    public void setSystemAccesses(List<SystemAccess> systemAccesses) {
        this.systemAccesses = systemAccesses;
    }

    public static class SystemAccess {
        private Integer systemId;
        private String systemName;
        private boolean hasAccess;

        public SystemAccess(Integer systemId, String systemName, boolean hasAccess) {
            this.systemId = systemId;
            this.systemName = systemName;
            this.hasAccess = hasAccess;
        }

        public Integer getSystemId() {
            return systemId;
        }

        public void setSystemId(Integer systemId) {
            this.systemId = systemId;
        }

        public String getSystemName() {
            return systemName;
        }

        public void setSystemName(String systemName) {
            this.systemName = systemName;
        }

        public boolean isHasAccess() {
            return hasAccess;
        }

        public void setHasAccess(boolean hasAccess) {
            this.hasAccess = hasAccess;
        }
    }
}
