package models;

import java.util.Objects;

public class Department {
    private int id;
    private String name;
    private int employees;
    private String news;

    public Department (String name, int employees, String news) {
        this.name = name;
        this.employees = employees;
        this.news = news;
    }

    public int getId () {
        return id;
    }

    public String getname () {
        return name;
    }

    public int getemployees () {
        return employees;
    }

    public String getnews () {
        return news;
    }
    public void setId (int id) {
    }
    public void setname (String name) {
        this.name =name;
    }

    public void setemployees (int employees) {
        this.employees =employees;
    }

    public void setnews (String news) {
        this.news = news;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return employees == that.employees &&
                Objects.equals(name, that.name) &&
                Objects.equals(news, that.news);
    }

    @Override
    public int hashCode () {
        return Objects.hash(name,employees, news);
    }


}
