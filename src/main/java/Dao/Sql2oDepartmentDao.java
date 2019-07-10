package Dao;

import models.Department;
import models.Employees;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {
    private final Sql2o sql2o;
    public Sql2oDepartmentDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add(Department department) {
        String sql = "INSERT INTO departments (name, number of employees, news, employeesId) VALUES (:name, :number of employees, :news, :employeesId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Department> getAll(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments")
                    .executeAndFetch(Department.class);
        }
    }


    public List<Department> getEmployees(int employeesId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments WHERE employeesId = :employeesId")
                    .addParameter("employeesId", employeesId)
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from departments WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Department findById (int id) {
        return null;
    }

    @Override
    public void update (String mName, int mEmployees, String mNews) {

    }

    @Override
    public void addDepartmentToEmployees(Department department, Employees Employees){

    }

    @Override
    public List<Employees> getAllEmployeesByDepartment(int DepartmentId){
        List<Employees> Employees = new ArrayList();
        return Employees;
    }
    @Override
    public void clearAll() {
        String sql = "DELETE from departments";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
