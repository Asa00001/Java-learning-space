package studentManagementSystem;

public class Student {
    private String uid;
    private String name;
    private int age;
    private double gpa;
    private String year;
    private String department;

    public Student(String uid, String name, int age, double gpa, String year, String department) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.year = year;
        this.department = department;
    }
    public Student() {}

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format(
                "%-10s %-20s %-4d %-5.2f %-10s %-10s",
                uid,
                name,
                age,
                gpa,
                year,
                department
        );
    }
}
