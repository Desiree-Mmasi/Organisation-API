package Dao;

import models.Department;
import models.News;

import java.util.List;

public interface NewsDao {
    void add(News news);
    void addNewsToDepartments(News news, Department department);
    List<News> getAll();
    List<News> getAllNewsByDepartment(int DepartmentId);

    void deleteById(int id);
    void clearAll();


}
