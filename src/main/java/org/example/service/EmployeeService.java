package org.example.service;


import org.example.dto.Employee;
import org.example.repository.EmployeeRepository;

public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private String salary="0000";
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployee(int id) {
        return employeeRepository.findEmployeeById(id);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.saveEmployee(employee);
    }

    public void removeEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }

    public boolean addFormerEmployeeByName(String name) {
        if (employeeRepository.employeeExistsByName(name))
            return true;
        else
            return false;
    }

}
