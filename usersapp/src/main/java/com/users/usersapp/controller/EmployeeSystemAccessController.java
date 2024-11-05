package com.users.usersapp.controller;

import com.users.usersapp.dto.EmployeeAccessDto;
import com.users.usersapp.model.EmployeeSystemAccess;
import com.users.usersapp.service.EmployeeSystemAccessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accessTable")
public class EmployeeSystemAccessController {
    private final EmployeeSystemAccessService accessService;

    public EmployeeSystemAccessController(EmployeeSystemAccessService accessService) {
        this.accessService = accessService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeAccessDto>> getAccessTable() {
        List<EmployeeAccessDto> accessDtoList = accessService.getEmployeeAccessTable();
        return new ResponseEntity<>(accessDtoList, HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<Void> updateAccess(@RequestBody EmployeeSystemAccess employeeSystemAccess) {
        accessService.updateEmployeeAccess(employeeSystemAccess);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
