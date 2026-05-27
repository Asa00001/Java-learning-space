package studentManagementSystem;

import java.util.Arrays;
import java.util.List;

public class InputValidation {
    private static final List<String> VALID_YEARS = Arrays.asList("first", "second", "third", "fourth");
    private static final List<String> VALID_DEPARTMENTS = Arrays.asList("cs", "is", "ai", "it", "ds");

    public static boolean isValidName(String name) {
        name = name.trim();

        return name.matches("^[A-Za-z ]+$");
    }

    public static boolean isValidUid(String uid) {
        uid = uid.trim();

        return uid.matches("^[0-9]+$");
    }

    public static boolean isValidAge(int age) {
        return age >= 0 && age <= 100;
    }

    public static boolean isValidGPA(double gpa) {
        return gpa >= 0.0 && gpa <= 4.0;
    }

    public static boolean isValidYear(String year) {
        year = year.trim().toLowerCase();

        return VALID_YEARS.contains(year);
    }

    public static boolean isValidDepartment(String department) {
        department = department.trim().toLowerCase();

        return VALID_DEPARTMENTS.contains(department);
    }
}
