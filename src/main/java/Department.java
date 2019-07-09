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
}
