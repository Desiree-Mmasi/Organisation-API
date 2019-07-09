public class Employee {
    private String mName;
    private String mDepartment;
    private String mRole;

    public Employee (String mName, String mDepartment, String mRole) {
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
}
