package com.users.usersapp.service;

import com.users.usersapp.dao.EmployeeDao;
import com.users.usersapp.dao.EmployeeSystemAccessDao;
import com.users.usersapp.dao.SystemDao;
import com.users.usersapp.dto.EmployeeAccessDto;
import com.users.usersapp.model.Employee;
import com.users.usersapp.model.EmployeeSystemAccess;
import com.users.usersapp.model.System;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeSystemAccessService {
    private final EmployeeSystemAccessDao employeeSystemAccessDao;
    private final EmployeeDao employeeDao;
    private final SystemDao systemDao;


    public EmployeeSystemAccessService(EmployeeSystemAccessDao employeeSystemAccessDao,
                                       EmployeeDao employeeDao, SystemDao systemDao) {
        this.employeeSystemAccessDao = employeeSystemAccessDao;
        this.employeeDao = employeeDao;
        this.systemDao = systemDao;
    }

    //Вывод данных о доступе каждого сотрудника к каждой системе
    public List<EmployeeAccessDto> getEmployeeAccessTable() {
        List<Employee> employees = employeeDao.findAll();
        List<System> systems = systemDao.findAll();
        List<EmployeeSystemAccess> accessList = employeeSystemAccessDao.findAll();

        List<EmployeeAccessDto> accessTable = new ArrayList<>();

        for (Employee employee : employees) {
            List<EmployeeAccessDto.SystemAccess> systemAccessList = new ArrayList<>();

            for (System system : systems) {
                boolean hasAccess = accessList.stream()
                        .anyMatch(access -> access.getEmployeeId().equals(employee.getId()) &&
                                access.getSystemId().equals(system.getId()) &&
                                access.isHasAccess());
                systemAccessList.add(new EmployeeAccessDto.SystemAccess(system.getId(), system.getName(), hasAccess));
            }

            accessTable.add(new EmployeeAccessDto(employee.getId(), employee.getFio(), systemAccessList));
        }
        return accessTable;
    }
    //Редактирование доступа сотрудника к системе
    public void updateEmployeeAccess(EmployeeSystemAccess employeeSystemAccess) {
        employeeSystemAccessDao.update(employeeSystemAccess);
    }
}
