package Dao;
import models.Employees;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Sql2oEmployeesDaoTest {

    private static Connection conn;
    private static Sql2oEmployeesDao EmployeesDao;

    @BeforeClass
    public static void setup() throws Exception{
        String connectionString = "jdbc:postgresql://localhost:5432/organisationapi";
        Sql2o sql2o = new Sql2o(connectionString,"moringa","1234" );
        EmployeesDao = new Sql2oEmployeesDao(sql2o);
        conn = sql2o.open();
    }
    @After
    public void clear() {
        EmployeesDao.clearAll();
    }
    @AfterClass
    public static void tearDown() throws Exception{
        conn.close();
    }

    @Test
    public void add() {
        Employees employees = setUpNewEmployees();
        assertEquals(employees.getId(), employees.getId());
    }

    @Test
    public void getAll() {
        Employees employees = setUpNewEmployees();
        assertEquals(true, EmployeesDao.getAll().contains(employees));
    }

    @Test
    public void getAllEmployeesByDepartment() {
        Employees employees = setUpNewEmployees();
        List<Employees> allEmployeesByDepartment = EmployeesDao.getAllEmployeesByDepartment(employees.getDepartmentId());
        assertEquals(employees.getDepartmentId(),allEmployeesByDepartment.get(0).getDepartmentId());
    }

    @Test
    public void findById() {
        Employees employees = setUpNewEmployees();
        assertEquals(employees, EmployeesDao.findById(employees.getId()));
    }

    @Test
    public void deleteById() {
        Employees employees = setUpNewEmployees();
        EmployeesDao.deleteById(employees.getId());
        assertEquals(0, EmployeesDao.getAll().size());
    }

    @Test
    public void clearAll() {
        Employees employees = setUpNewEmployees();
        EmployeesDao.clearAll();
        assertEquals(0, EmployeesDao.getAll().size());

    }

    //helpers
    public Employees setUpNewEmployees(){
        Employees employees = new Employees("Kim","Finance","Manager" );
                EmployeesDao.add(employees);
        return employees;
    }
}