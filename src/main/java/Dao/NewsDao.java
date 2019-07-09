package Dao;

import models.News;

import java.util.List;

public interface NewsDao {
    void add(News news);

    List<News> getAll();
    List<News> getAllNewsByDepartment(int DepartmentId);

    void deleteById(int id);
    void clearAll();
}
