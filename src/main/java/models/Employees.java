package models;

import java.util.Objects;

public class Employees {
    private String mName;
    private String mDepartment;
    private String mRole;

    public Employees (String mName, String mDepartment, String mRole) {
        this.mName = mName;
        this.mDepartment = mDepartment;
        this.mRole = mRole;
    }

    public String getmName () {
        return mName;
    }

    public String getmDepartment () {
        return mDepartment;
    }

    public String getmRole () {
        return mRole;
    }

    public void setmName (String mName) {
        this.mName = mName;
    }

    public void setmDepartment (String mDepartment) {
        this.mDepartment = mDepartment;
    }

    public void setmRole (String mRole) {
        this.mRole = mRole;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return Objects.equals(mName, employees.mName) &&
                Objects.equals(mDepartment, employees.mDepartment) &&
                Objects.equals(mRole, employees.mRole);
    }

    @Override
    public int hashCode () {
        return Objects.hash(mName, mDepartment, mRole);
    }
}
