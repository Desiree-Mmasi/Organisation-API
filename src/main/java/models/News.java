package models;

import java.util.Objects;

public class News {
    private String mName;
    private String mDepartment;
    private String mNews;

    public News (String mName, String mDepartment, String mNews) {
        this.mName = mName;
        this.mDepartment = mDepartment;
        this.mNews = mNews;
    }

    public String getmName () {
        return mName;
    }

    public String getmDepartment () {
        return mDepartment;
    }

    public String getmNews () {
        return mNews;
    }

    public void setmName (String mName) {
        this.mName = mName;
    }

    public void setmDepartment (String mDepartment) {
        this.mDepartment = mDepartment;
    }

    public void setmNews (String mNews) {
        this.mNews = mNews;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(mName, news.mName) &&
                Objects.equals(mDepartment, news.mDepartment) &&
                Objects.equals(mNews, news.mNews);
    }

    @Override
    public int hashCode () {
        return Objects.hash(mName, mDepartment, mNews);
    }

    public void setId (int id) {
    }
}
