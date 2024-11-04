package com.users.usersapp.model;

public class Employee {
    private Integer id;
    private String fio;

    public Employee() {}

    public Employee(Integer id, String fio) {
        this.id = id;
        this.fio = fio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}
