package Dao;

import models.Employees;

import java.util.List;

public interface EmployeesDao {

    //create
    void add(Employees user);

    //read
    List<Employees> getAll ();
    List<Employees> getAllEmployeesByDepartment(int departmentId);
    Employees findById(int id);


    //update
    // void update(int id, String name);

    //delete
    void deleteById(int id);
    void clearAll();

    List<Employees> getAllEmployeesByDepartment (String departmentId);
}