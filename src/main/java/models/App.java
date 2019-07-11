package models;

import DB.DB;
import Dao.*;
import com.google.gson.Gson;
import models.Department;
import models.Employees;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static spark.Spark.*;

import com.google.gson.Gson;
import Dao.Sql2oEmployeesDao;
import Dao.Sql2oDepartmentDao;
import models.Department;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        Sql2oEmployeesDao employeesDao;
        Sql2oDepartmentDao departmentDao;
        Sql2oNewsDao newsDao;
        Connection conn;
        Gson gson = new Gson();


        Sql2o sql2o = DB.sql2o;

        departmentDao = new Sql2oDepartmentDao(sql2o);
        employeesDao = new Sql2oEmployeesDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();


        post("/departments/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.status(201);
            res.type("application/json");
            return gson.toJson(department);
        });

        get("/departments","application/json", (request, response) -> {
            response.type("application/json");
            return gson.toJson(departmentDao.getAll());
        });

        post("/employees/new", "application/json", (req, res) -> {
            Employees employees = gson.fromJson(req.body(), Employees.class);
            employeesDao.add(employees);
            res.status(201);
            res.type("application/json");
            return gson.toJson(employees);
        });

        get("/employees","application/json", (request, response) -> {
            response.type("application/json");
            return gson.toJson(employeesDao.getAll());
        });

        post("/news/new", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            res.status(201);
            res.type("application/json");
            return gson.toJson(news);
        });

        get("/news","application/json", (request, response) -> {
            response.type("application/json");
            return gson.toJson(employeesDao.getAll());
        });
    }
}

