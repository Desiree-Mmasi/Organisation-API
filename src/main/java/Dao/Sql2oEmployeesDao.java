package Dao;

import models.Employees;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public abstract class Sql2oEmployeesDao implements EmployeesDao {
    private final Sql2o sql2o;
    public Sql2oEmployeesDao(Sql2o sql2o) { this.sql2o = sql2o;}


    @Override
    public void add(Employees employees) {
        String sql = "INSERT INTO Employees (name, department, role, departmentId) VALUES (:name, :department, :role :departmentId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(employees)
                    .executeUpdate()
                    .getKey();
            employees.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


    @Override
    public List<Employees> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM Employees")
                    .executeAndFetch(Employees.class);
        }
    }

//    @Override
//    public List<Employees> getAllEmployeesByDepartment(int departmentId) {
//        try (Connection con = sql2o.open()) {
//            return con.createQuery("SELECT * FROM Employees WHERE departmentId = :departmentId")
//                    .addParameter("departmentId", departmentId)
//                    .executeAndFetch(Employees.class);
//        }
//    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from Employees WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from Employees";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}

