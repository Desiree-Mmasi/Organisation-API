import Dao.Sql2oDepartmentDao;
import Dao.Sql2oEmployeesDao;
import models.Department;
import models.Employees;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.Assert.*;

public class Sql2oEmployeesDaoTest {
    private static Connection conn;
    private static Sql2oEmployeesDao EmployeesDao;
    private static Sql2oDepartmentDao departmentDao;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postresql://localhost:5432/organisationapi";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "1234");
        EmployeesDao = new Sql2oEmployeesDao(sql2o)
        {
            @Override
            public void addEmployeesToDepartments (Employees Employees, Department department) {

            }
        };
        departmentDao = new Sql2oDepartmentDao(sql2o) {
            @Override
            public List<Employees> getAllEmployeesForDepartments (int id) {
                return null;
            }
        };
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        EmployeesDao.clearAll();
        departmentDao.clearAll();
    }
    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
    }

    @Test
    public void addingEmployeesSetsId() throws Exception {
        Employees testEmployees = setupEmployees();
        assertEquals(1, testEmployees.getId());
    }

    @Test
    public void getAll() throws Exception {
        Employees Employees1 = setupEmployees();
        Employees Employees2 = setupEmployees();
        assertEquals(2, EmployeesDao.getAll().size());
    }

    @Test
    public void getAllEmployeessByDepartment() throws Exception {
        Department testDepartment = setupDepartment();
        Department otherDepartment = setupDepartment();
        Employees Employees1 = setupEmployeesForDepartment(testDepartment);
        Employees Employees2 = setupEmployeesForDepartment(testDepartment);
        Employees EmployeesForOtherDepartment = setupEmployeesForDepartment(otherDepartment);
        assertEquals(2, EmployeesDao.getAll(testDepartment.getId()).size());
    }

    @Test
    public void deleteById() throws Exception {
        Employees testEmployees = setupEmployees();
        Employees otherEmployees = setupEmployees();
        assertEquals(2, EmployeesDao.getAll().size());
        EmployeesDao.deleteById(testEmployees.getId());
        assertEquals(1, EmployeesDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Employees testEmployees = setupEmployees();
        Employees otherEmployees = setupEmployees();
        EmployeesDao.clearAll();
        assertEquals(0, EmployeesDao.getAll().size());
    }

    //helpers

    public Employees setupEmployees() {
        Employees Employees = new Employees("Kim", "Finance", "Accounts Manager");
        EmployeesDao.add(Employees);
        return Employees;
    }

    public Employees setupEmployeesForDepartment(Department department) {
        Employees Employees = new Employees("Kim", "Human Resource", "Secretary");
        EmployeesDao.add(Employees);
        return Employees;
    }

    public Department setupDepartment() {
        Department department = new Department("Human Resource", 13, "Everyone is expected to be in the boardroom");
        departmentDao.add(department);
        return department;
    }
}
