package studentManagementSystem;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        printMenu();

        while (true) {
            System.out.println("Please enter your choice:");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": {
                    String uid;
                    while (true) {
                        System.out.println("Please enter student unique id: ");
                        uid = scanner.nextLine();

                        if (!InputValidation.isValidUid(uid)) {
                            System.out.println("Invalid student uid!");
                            continue;
                        }

                        if (studentSystem.getStudent(uid) != null) {
                            System.out.println("Student uid already exists!");
                            continue;
                        }

                        break;
                    }

                    String name;
                    while (true) {
                        System.out.println("Please enter student name: ");
                        name = scanner.nextLine();

                        if(InputValidation.isValidName(name)) break;

                        System.out.println("Invalid student name!");
                    }

                    int age;
                    while (true) {
                        System.out.println("Please enter student age: ");
                        try {
                            age = Integer.parseInt(scanner.nextLine());

                            if(InputValidation.isValidAge(age)) break;
                            System.out.println("Invalid student age!");
                        }  catch(NumberFormatException e) {
                            System.out.println("Invalid student age!");
                        }
                    }

                    double gpa;
                    while (true) {
                        System.out.println("Please enter student gpa: ");
                        try {
                            gpa = Double.parseDouble(scanner.nextLine());

                            if(InputValidation.isValidGPA(gpa)) break;
                            System.out.println("Invalid student gpa!");
                        }   catch(NumberFormatException e) {
                            System.out.println("Invalid student gpa!");
                        }
                    }

                    String year;
                    while (true) {
                        System.out.println("Please enter student year: ");
                        year = scanner.nextLine();

                        if(InputValidation.isValidYear(year)) break;
                        System.out.println("Invalid student year!");
                    }

                    String department;
                    while (true) {
                        System.out.println("Please enter student department: ");
                        department = scanner.nextLine();

                        if(InputValidation.isValidDepartment(department)) break;
                        System.out.println("Invalid student department!");
                    }

                    Student student = new Student(uid, name, age, gpa, year, department);

                    boolean success = studentSystem.addStudent(student);
                    if (success) {
                        System.out.println("Student successfully added!");
                    }  else {
                        System.out.println("Student uid repeated!");
                    }
                    break;
                }
                case "2": {
                    System.out.println("Please enter student unique id:");
                    String uid = scanner.nextLine();

                    boolean success = studentSystem.removeStudent(uid);
                    if (success) {
                        System.out.println("Student successfully removed!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                }
                case "3": {
                    System.out.println("Please enter student unique id:");
                    String uid = scanner.nextLine();

                    if(studentSystem.getStudent(uid) == null) {
                        System.out.println("Student not found!");
                        break;
                    }

                    System.out.println("Please enter field to update: (name/age/gpa/year/department)");
                    String field = scanner.nextLine().trim().toLowerCase();

                    String newValue = null;

                    switch (field) {
                        case "name": {
                            while (true) {
                                System.out.println("Please enter student name: ");
                                newValue = scanner.nextLine();

                                if(InputValidation.isValidName(newValue)) break;
                                System.out.println("Invalid student name!");
                            }
                            break;
                        }
                        case "age": {
                            while (true) {
                                System.out.println("Please enter student age: ");
                                newValue = scanner.nextLine();

                                try{
                                    int age = Integer.parseInt(newValue);
                                    if(InputValidation.isValidAge(age)) break;
                                    System.out.println("Invalid student age!");
                                } catch(NumberFormatException e) {
                                    System.out.println("Invalid student age!");
                                }
                            }
                            break;
                        }
                        case "gpa": {
                            while (true) {
                                System.out.println("Please enter student gpa: ");
                                newValue = scanner.nextLine();

                                try{
                                    double gpa = Double.parseDouble(newValue);
                                    if(InputValidation.isValidGPA(gpa)) break;
                                    System.out.println("Invalid student gpa!");
                                } catch(NumberFormatException e) {
                                    System.out.println("Invalid student gpa!");
                                }
                            }
                            break;
                        }
                        case "year": {
                            while (true) {
                                System.out.println("Please enter student year: ");
                                newValue = scanner.nextLine();

                                if(InputValidation.isValidYear(newValue)) break;
                                System.out.println("Invalid student year!");
                            }
                            break;
                        }
                        case "department": {
                            while (true) {
                                System.out.println("Please enter student department: ");
                                newValue = scanner.nextLine();

                                if(InputValidation.isValidDepartment(newValue)) break;
                                System.out.println("Invalid student department!");
                            }
                            break;
                        }
                        default:
                            System.out.println("Invalid field!");
                    }

                    if(!field.equals("name") && !field.equals("age") && !field.equals("gpa")
                            && !field.equals("year") && !field.equals("department")) {
                        break;
                    }

                    boolean success = studentSystem.updateStudent(uid, field, newValue);
                    if (success) {
                        System.out.println("Student successfully updated!");
                    }  else {
                        System.out.println("Failed to update student!");
                    }
                    break;
                }
                case "4": {
                    System.out.println("Please enter student unique id:");
                    String uid = scanner.nextLine();
                    Student student = studentSystem.getStudent(uid);

                    if (student != null) {
                        printHeader();
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                }
                case "5": {
                    System.out.println("Please enter sort field:\n" +
                            "(uid/name/gpa/year/department)");
                    String field = scanner.nextLine();

                    List<Student> sortedStudents = studentSystem.listAndSortAllStudents(field);

                    System.out.println("\nSorted Student List\n");
                    printHeader();
                    printStudentList(sortedStudents);
                    break;
                }
                case "6": {
                    System.out.println("Please enter filter field:\n" +
                            "(age/gpa/year/department)");
                    String field = scanner.nextLine();

                    switch(field.trim().toLowerCase()) {
                        case "age": {
                            System.out.println("Please enter filter age:");
                            try {
                                int age = Integer.parseInt(scanner.nextLine());
                                printHeader();
                                printStudentList(studentSystem.filterByAge(age));
                            } catch(NumberFormatException e) {
                                System.out.println("Invalid filter age!");
                            }
                            break;
                        }
                        case "gpa": {
                            System.out.println("Please enter filter gpa:");
                            try{
                                double gpa = Double.parseDouble(scanner.nextLine());
                                printHeader();
                                printStudentList(studentSystem.filterByGPA(gpa));
                            } catch(NumberFormatException e) {
                                System.out.println("Invalid filter gpa!");
                            }
                            break;
                        }
                        case "year": {
                            System.out.println("Please enter filter year:");
                            String year = scanner.nextLine();
                            printHeader();
                            printStudentList(studentSystem.filterByYear(year));
                            break;
                        }
                        case "department": {
                            System.out.println("Please enter filter department:");
                            String department = scanner.nextLine();
                            printHeader();
                            printStudentList(studentSystem.filterByDepartment(department));
                            break;
                        }
                        default:
                            System.out.println("Invalid input!");
                    }
                    break;
                }
                case "7":
                    System.out.println("Total Students: " + studentSystem.countTotalStudents());
                    break;
                case "8":
                    System.out.println("Average GPA: " +
                            String.format("%.2f",  studentSystem.calculateAverageGPA()));
                    break;
                case "9":
                    System.out.println("\n=============== TOP 5 STUDENTS ===============\n");

                    printHeader();
                    printStudentList(studentSystem.displayTop5());
                    break;
                case "10":
                    System.out.println("\n============= FAILING STUDENTS =============\n");

                    printHeader();
                    printStudentList(studentSystem.getFailingStudents());
                    break;
                case "11":
                    System.out.println(studentSystem.generateSummary());
                    break;
                case "0":
                    System.out.println("Thanks for Using!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("""
            ===================================
            Student Management System
            ===================================

            1. Add Student
            2. Remove Student
            3. Update Student
            4. Search Student
            5. List and Sort Students
            6. Filter Students
            7. Count Total Students
            8. Calculate Average GPA
            9. Display Top 5 Students
            10. Display Failing Students
            11. Generate Summary
            0. Exit

            ===================================
            """);
    }

    private static void printStudentList(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void printHeader() {
        System.out.println("UID        Name                 Age  GPA   Year      Department");
        System.out.println("----------------------------------------------------------------");
    }
}
