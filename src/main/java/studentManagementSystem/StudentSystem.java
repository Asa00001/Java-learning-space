package studentManagementSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentSystem {
    private List<Student> students;

    public StudentSystem() {
        this.students = StudentStorage.loadStudents();
    }

    private Student findStudentByUid(String uid) {
        for (Student student : students) {
            if (student.getUid().equals(uid)) {
                return student;
            }
        }
        return null;
    }

    public boolean addStudent(Student student) {
        if (findStudentByUid(student.getUid()) != null) {
            return false;
        }

        students.add(student);

        StudentStorage.saveStudents(students);
        return true;
    }

    public boolean removeStudent(String uid) {
        Student student = findStudentByUid(uid);

        if (student != null) {
            students.remove(student);

            StudentStorage.saveStudents(students);
            return true;
        }
        return false;
    }

    public boolean updateStudent(String uid, String field, String newValue) {
        Student student = findStudentByUid(uid);

        if(student == null) {
            return false;
        }

        switch (field.trim().toLowerCase()) {
            case "name":
                student.setName(newValue);
                break;
            case "age":
                student.setAge(Integer.parseInt(newValue));
                break;
            case "gpa":
                student.setGpa(Double.parseDouble(newValue));
                break;
            case "year":
                student.setYear(newValue);
                break;
            case "department":
                student.setDepartment(newValue);
                break;
            default:
                return false;
        }

        StudentStorage.saveStudents(students);
        return true;
    }

    public Student getStudent(String uid) {
        return findStudentByUid(uid);
    }

    public int countTotalStudents() {
        return students.size();
    }

    public double calculateAverageGPA() {
        if (students.isEmpty()) {
            return 0;
        }

        double totalGPA = 0;
        for (Student student : students) {
            totalGPA += student.getGpa();
        }
        return totalGPA / students.size();
    }

    public List<Student> getFailingStudents() {
        List<Student> failingStudents = new ArrayList<>();

        for (Student student : students) {
            if(student.getGpa() < 2) {
                failingStudents.add(student);
            }
        }
        return failingStudents;
    }

    public List<Student> filterByAge(int age) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if(student.getAge() == age) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    public List<Student> filterByGPA(double gpa) {
        List<Student> filteredStudents = new ArrayList<>();

        for (Student student : students) {
            if(student.getGpa() >= gpa) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    public List<Student> filterByYear(String year) {
        List<Student> filteredStudents = new ArrayList<>();

        for (Student student : students) {
            if(student.getYear().equalsIgnoreCase(year)) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    public List<Student> filterByDepartment(String department) {
        List<Student> filteredStudents = new ArrayList<>();

        for (Student student : students) {
            if(student.getDepartment().equalsIgnoreCase(department)) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    public List<Student> displayTop5() {
        List<Student> sortedStudents = new ArrayList<>(students);

        sortedStudents.sort(
                Comparator.comparingDouble(Student::getGpa).reversed()
        );

        List<Student> topStudents = new ArrayList<>();

        int limit = Math.min(5, sortedStudents.size());

        for (int i = 0; i < limit; i++) {
            topStudents.add(sortedStudents.get(i));
        }
        return topStudents;
    }

    public List<Student> listAndSortAllStudents(String field) {
        List<Student> sortedStudents = new ArrayList<>(students);

        switch(field.trim().toLowerCase()) {
            case "gpa":
                sortedStudents.sort(
                        Comparator.comparingDouble(Student::getGpa).reversed()
                );
                break;

            case "uid":
                sortedStudents.sort(
                        Comparator.comparingInt(student ->
                                Integer.parseInt(student.getUid()))
                );
                break;

            case "name":
                sortedStudents.sort(
                        Comparator.comparing(Student::getName)
                );
                break;

            case "year":
                sortedStudents.sort(
                        Comparator.comparing(Student::getYear)
                );
                break;

            case "department":
                sortedStudents.sort(
                        Comparator.comparing(Student::getDepartment)
                );
                break;

            default:
                return sortedStudents;
        }
        return sortedStudents;
    }

    public String generateSummary() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Average GPA: ")
                .append(String.format("%.2f", calculateAverageGPA()))
                .append("\n");

        stringBuilder.append("Total Students: ")
                .append(countTotalStudents()).append("\n");

        stringBuilder.append("Top 5 students: \n\n");
        List<Student> top5 = displayTop5();
        for (Student student : top5) {
            stringBuilder.append(student).append("\n\n");
        }

        stringBuilder.append("Failing students: \n\n");
        List<Student> failingStudents = getFailingStudents();
        for (Student student : failingStudents) {
            stringBuilder.append(student).append("\n\n");
        }

        return stringBuilder.toString();
    }
}
