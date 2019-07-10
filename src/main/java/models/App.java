package models;

import Dao.Sql2oNewsDao;
import com.google.gson.Gson;
import Dao.Sql2oEmployeesDao;
import Dao.Sql2oDepartmentDao;
import models.Department;
import models.Employees;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.BitSet;
import java.util.List;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        Sql2oEmployeesDao EmployeesDao;
        Sql2oDepartmentDao DepartmentDao;
        Sql2oNewsDao NewsDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postresql://localhost:5432/organisationapi";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "1234");

        DepartmentDao = new Sql2oDepartmentDao(sql2o) {
            @Override
            public List<Employees> getAllEmployeesForDepartments (int id) {
                return null;
            }
        };
        EmployeesDao = new Sql2oEmployeesDao(sql2o) {
            @Override
            public List<Department> getAllDepartmentForEmployees (int id) {
                return null;
            }

            @Override
            public void addEmployeesToDepartments (models.Employees Employees, Department department) {

            }
        };
        NewsDao = new Sql2oNewsDao(sql2o) {
            @Override
            public void addNewsToDepartments (News news, Department department) {

            }

            @Override
            public BitSet getAll (int id) {
                return null;
            }
        };
        conn = sql2o.open();


        post("/Department/new", "application/json", (req, res) -> { //accept a request in format JSON from an app
            Department Department = gson.fromJson(req.body(), Department.class);//make java from JSON with GSON
            DepartmentDao.add(Department);//Do our thing with our DAO
            res.status(201);//A-OK! But why 201??
            res.type("application/json");
            return gson.toJson(Department);//send it back to be displayed
        });
    }
}

