package models;

import java.util.Objects;

public class Department {
    private String mName;
    private int mEmployees;
    private String mDescription;

    public Department (String mName, int mEmployees, String mDescription) {
        this.mName = mName;
        this.mEmployees = mEmployees;
        this.mDescription = mDescription;
    }

    public String getmName () {
        return mName;
    }

    public int getmEmployees () {
        return mEmployees;
    }

    public String getmDescription () {
        return mDescription;
    }

    public void setmName (String mName) {
        this.mName = mName;
    }

    public void setmEmployees (int mEmployees) {
        this.mEmployees = mEmployees;
    }

    public void setmDescription (String mDescription) {
        this.mDescription = mDescription;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return mEmployees == that.mEmployees &&
                Objects.equals(mName, that.mName) &&
                Objects.equals(mDescription, that.mDescription);
    }

    @Override
    public int hashCode () {
        return Objects.hash(mName, mEmployees, mDescription);
    }
}
