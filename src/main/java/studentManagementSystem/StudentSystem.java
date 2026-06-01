package studentManagementSystem;

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
}
