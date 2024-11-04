CREATE TABLE employee_system_access (
    employee_id INT REFERENCES employees(id) ON DELETE CASCADE,
    system_id INT REFERENCES systems(id) ON DELETE CASCADE,
    has_access BOOLEAN NOT NULL,
    PRIMARY KEY (employee_id, system_id)
);