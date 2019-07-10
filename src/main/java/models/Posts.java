package models;

import java.sql.Timestamp;
import java.util.Date;

public class Posts {
    private String mName;
    private String mPosts;
    private String mDepartment;
    private Timestamp date;

    public Posts (String mName, String mPosts, String mDepartment) {
        this.mName = mName;
        this.mPosts = mPosts;
        this.mDepartment = mDepartment;
        this.date = new Timestamp(new Date().getTime());
    }

    public String getmName () {
        return mName;
    }

    public String getmPosts () {
        return mPosts;
    }

    public String getmDepartment () {
        return mDepartment;
    }

    public Timestamp getDate () {
        return date;
    }

    public void setmName (String mName) {
        this.mName = mName;
    }

    public void setmPosts (String mPosts) {
        this.mPosts = mPosts;
    }

    public void setmDepartment (String mDepartment) {
        this.mDepartment = mDepartment;
    }

    public void setDate (Timestamp date) {
        this.date = date;
    }
}
