package models;

import java.util.Objects;

public class Department {
    private int id;
    private String mName;
    private int mEmployees;
    private String mNews;

    public Department (String mName, int mEmployees, String mNews) {
        this.mName = mName;
        this.mEmployees = mEmployees;
        this.mNews = mNews;
    }

    public int getId () {
        return id;
    }

    public String getmName () {
        return mName;
    }

    public int getmEmployees () {
        return mEmployees;
    }

    public String getmNews () {
        return mNews;
    }
    public void setId (int id) {
    }
    public void setmName (String mName) {
        this.mName = mName;
    }

    public void setmEmployees (int mEmployees) {
        this.mEmployees = mEmployees;
    }

    public void setmNews (String mNews) {
        this.mNews = mNews;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return mEmployees == that.mEmployees &&
                Objects.equals(mName, that.mName) &&
                Objects.equals(mNews, that.mNews);
    }

    @Override
    public int hashCode () {
        return Objects.hash(mName, mEmployees, mNews);
    }


}
