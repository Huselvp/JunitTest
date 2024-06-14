package org.example.service;

import org.example.dto.Employee;
import org.example.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.util.ReflectionTestUtils;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    @Before
    public void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        employeeService = new EmployeeService(employeeRepository);
        ReflectionTestUtils.setField(employeeService, "salary", "0001");
    }
    @Test
    public void testGetEmployee() {
        Employee employee = new Employee(1,"houda","Informatique");
        when(employeeRepository.findEmployeeById(1)).thenReturn(employee);
        Employee result = employeeService.getEmployee(1);
        assertEquals(employee, result);
        verify(employeeRepository).findEmployeeById(1);
    }
    @Test
    public void testAddFormerEmployeeByName_EmployeeExists() {
        String employeeName = "Houda";
        when(employeeRepository.employeeExistsByName(employeeName)).thenReturn(true);
        boolean result = employeeService.addFormerEmployeeByName(employeeName);
        assertTrue(result);
        verify(employeeRepository).employeeExistsByName(employeeName);
    }

    @Test
    public void testAddFormerEmployeeByName_EmployeeDoesNotExist() {
        String employeeName = "Houda";
        when(employeeRepository.employeeExistsByName(employeeName)).thenReturn(false);
        boolean result = employeeService.addFormerEmployeeByName(employeeName);
        assertFalse(result);
        verify(employeeRepository).employeeExistsByName(employeeName);
    }
    @Test
    public void testAddEmployee() {
        Employee employee = new Employee(1,"houda","Informatique");
        employeeService.addEmployee(employee);
        verify(employeeRepository).saveEmployee(employee);
    }
    @Test
    public void testRemoveEmployee() {
        int employeeId = 1;
        employeeService.removeEmployee(employeeId);
        verify(employeeRepository).deleteEmployee(employeeId);
    }







}