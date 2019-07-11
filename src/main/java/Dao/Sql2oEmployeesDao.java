package Dao;

import DB.DB;
import models.Employees;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public  abstract class Sql2oEmployeesDao implements EmployeesDao {

    private final Sql2o sql2o;
    public Sql2oEmployeesDao(Sql2o sql2o){this.sql2o = sql2o;}
    @Override
    public void add(Employees employees) {
        String sql = "INSERT INTO employees  (name,department,role) VALUES (:name,:department, :role); ";
        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(sql, true)
                    .bind(employees)
                    .executeUpdate()
                    .getKey();
            employees.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Employees> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM employees")
                    .executeAndFetch(Employees.class);
        }
    }

    @Override
    public List<Employees> getAllEmployeesByDepartment(int departmentId) {
        String sql = "SELECT * FROM employees WHERE departmentId=:departmentId";
        try (Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("departmentId", departmentId)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Employees.class);
        }
    }

    @Override
    public Employees findById(int id) {
        String sql = "SELECT * FROM employees WHERE id=:id;";
        try(Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Employees.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM employees WHERE id=:id";
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
        String sql = "DELETE FROM employees";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}