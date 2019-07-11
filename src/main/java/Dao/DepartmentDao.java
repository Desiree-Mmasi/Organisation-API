package Dao;

import models.Department;
import models.Employees;

import java.util.List;

public interface DepartmentDao {
    //create
    void add(Department department);

    //read
    List<Department> getAll();
    // List<Department>
    Department findById(int id);


    //update
    // void update(int id, String name);

    //delete
    void deleteById(int id);
    void clearAll();
}