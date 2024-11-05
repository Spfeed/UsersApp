package com.users.usersapp.service;

import com.users.usersapp.dao.EmployeeDao;
import com.users.usersapp.dao.EmployeeSystemAccessDao;
import com.users.usersapp.dao.SystemDao;
import com.users.usersapp.model.Employee;
import com.users.usersapp.model.EmployeeSystemAccess;
import com.users.usersapp.model.System;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemService {
    private final SystemDao systemDao;
    private final EmployeeSystemAccessDao accessDao;
    private final EmployeeDao employeeDao;

    public SystemService(SystemDao systemDao, EmployeeSystemAccessDao accessDao, EmployeeDao employeeDao) {
        this.systemDao = systemDao;
        this.accessDao = accessDao;
        this.employeeDao = employeeDao;
    }

    //CRUD
    //Добавление новой системы
    public void saveSystem(System system) {
        systemDao.save(system);
        List<Employee> employeeList = employeeDao.findAll();
        if (!employeeList.isEmpty()) {
            for (Employee employee : employeeList) {
                EmployeeSystemAccess access = new EmployeeSystemAccess(
                        employee.getId(),
                        system.getId(),
                        false
                );
                accessDao.save(access);
            }
        }
    }

    //Редактирование системы
    public void updateSystem(System system) {
        systemDao.update(system);
    }

    //Удаление системы
    public void deleteSystem(Integer systemId) {
        systemDao.delete(systemId);
    }

    public List<System> getAllSystems() {
        return systemDao.findAll();
    }
}
