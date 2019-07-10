package Dao;

import models.Department;

import java.util.List;

public interface DepartmentDao {
    void add (Department department);
//    void addDepartmentToEmployees(Department department, Employees employees)

    List<Department> getAll(int employeesId);
    Department findById(int id);

    void update(String mName, int mEmployees, String mNews);

    void deleteById(int id);
    void clearAll();
}
