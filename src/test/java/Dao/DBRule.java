package Dao;
import DB.DB;
import org.sql2o.*;
import org.junit.rules.ExternalResource;

public class DBRule extends ExternalResource {
    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/organisationapi_test","moringa", "1234");
    }

    @Override
    protected void after() {
        try (Connection con = DB.sql2o.open()) {
            String deleteDepartment = "DELETE FROM department *;";
            String deleteEmployees = "DELETE FROM employees *;";
            String deleteAnimal = "DELETE FROM news *;";
            con.createQuery(deleteAnimal).executeUpdate();
            con.createQuery(deleteDepartment).executeUpdate();
            con.createQuery(deleteEmployees).executeUpdate();
        }
    }
}