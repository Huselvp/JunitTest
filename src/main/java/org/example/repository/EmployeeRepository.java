package org.example.repository;
import org.example.dto.Employee;

public interface EmployeeRepository {
    Employee findEmployeeById(int id);
    void saveEmployee(Employee employee);
    void deleteEmployee(int id);
    boolean employeeExistsByName(String name);
}
