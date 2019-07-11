package models;

import java.util.Objects;

public class Employees {
    private int id;
    private String name;
    private String departmentId;
    private String role;

    public Employees (String name, String departmentId, String role) {
        this.name = name;
        this.departmentId = departmentId;
        this.role = role;
    }

    public static int getId () {
//        return id;
    }

    public void setId (int id) {
    }

    public String getName () {
        return name;
    }

    public String getDepartmentId () {
        return departmentId;
    }

    public String getRole () {
        return role;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return Objects.equals(name, employees.name) &&
                Objects.equals(departmentId, employees.departmentId) &&
                Objects.equals(role, employees.role);
    }

    @Override
    public int hashCode () {
        return Objects.hash(name, departmentId, role);
    }


}
