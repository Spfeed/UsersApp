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
public class EmployeeService {
    private final EmployeeDao employeeDao;
    private final EmployeeSystemAccessDao accessDao;
    private final SystemDao systemDao;

    public EmployeeService(EmployeeDao employeeDao, EmployeeSystemAccessDao accessDao, SystemDao systemDao) {
        this.employeeDao = employeeDao;
        this.accessDao = accessDao;
        this.systemDao = systemDao;
    }

    //CRUD
    //Добавление сотрудника
    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
        List<System> systems = systemDao.findAll();
        if (!systems.isEmpty()) {
            for (System system : systems) {
                EmployeeSystemAccess access = new EmployeeSystemAccess(
                        employee.getId(),
                        system.getId(),
                        false
                );
                accessDao.save(access);
            }
        }
    }

    //Редактирование сотрудника
    public void updateEmployee(Employee employee) {
        employeeDao.update(employee);
    }

    //Удаление сотрудника
    public void deleteEmployee(Integer employeeId) {
        employeeDao.delete(employeeId);
    }
    //Вывод всех сотрудников
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }
}
