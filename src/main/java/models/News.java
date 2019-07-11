package models;

import java.util.Objects;

public class News {
    private int id;
    private String name;
    private int departmentId;
    private String news;

    public News (String mName, int mDepartmentId, String mNews) {
        this.name = mName;
        this.departmentId = mDepartmentId;
        this.news = mNews;
    }

    public int getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public int getDepartmentId () {
        return departmentId;
    }

    public String getNews () {
        return news;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setDepartmentId (int departmentId) {
        this.departmentId = departmentId;
    }

    public void setNews (String mNews) {
        this.news = mNews;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(name, news.name) &&
                Objects.equals(departmentId, news.departmentId) &&
                Objects.equals(this.news, news.news);
    }

    @Override
    public int hashCode () {
        return Objects.hash(name, departmentId, news);
    }

    public void setId (int id) {
    }



    }

