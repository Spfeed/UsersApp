package com.users.usersapp.controller;

import com.users.usersapp.model.System;
import com.users.usersapp.service.SystemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/systems")
public class SystemController {
    private final SystemService systemService;

    public SystemController(SystemService systemService) {
        this.systemService = systemService;
    }

    @GetMapping
    public ResponseEntity<List<System>> getAllSystems() {
        List<System> systems = systemService.getAllSystems();
        return new ResponseEntity<>(systems, HttpStatus.OK);
    }

    @PostMapping("/addSystem")
    public ResponseEntity<Void> addSystem(@RequestBody System system) {
        systemService.saveSystem(system);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateSystem(@RequestBody System system) {
        systemService.updateSystem(system);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSystem(@PathVariable Integer systemId) {
        systemService.deleteSystem(systemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
