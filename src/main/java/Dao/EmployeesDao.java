package Dao;

import models.Department;
import models.Employees;

import java.util.List;

public interface EmployeesDao {
    void add(Employees employees);
    void addEmployeesToDepartment(Employees employees,Department department);

    List<Employees> getAll();
    List<Department> getAllDepartmentForEmployees(int id);

    void deleteById(int id);
    void clearAll();
}
