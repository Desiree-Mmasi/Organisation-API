package Dao;

import models.Department;
import models.Employees;

import java.util.ArrayList;
import java.util.List;

public interface EmployeesDao {
    void add(Employees employees);

    List<Employees> getAllEmployeesByDepartment (int departmentId);

    void addEmployeesToDepartment(Employees employees, Department department);

    List<Employees> getAll();
    List<Department> getAllDepartmentForEmployees(int id);
    List<Employees> Employees = new ArrayList();

    List<Department> getAllDepartmentsForAEmployees (int EmployeesId);

    void deleteById(int id);
    void clearAll();
}
