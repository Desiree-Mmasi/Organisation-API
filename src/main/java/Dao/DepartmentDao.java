package Dao;

import models.Department;
import models.Employees;

import java.util.ArrayList;
import java.util.List;

public interface DepartmentDao {
    void add (Department department);
    void addDepartmentToEmployees(Department department, Employees employees);

    List<Department> getAll(int employeesId);
    List<Employees> getAllEmployeesForDepartments(int id);
    List<Department> Departments = new ArrayList();
    Department findById(int id);

    void update(String mName, int mEmployees, String mNews);

    void deleteById(int id);

    List<Employees> getAllEmployeesByDepartment (int DepartmentId);

    void clearAll();
}
