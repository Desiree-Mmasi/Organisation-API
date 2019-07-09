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
}
