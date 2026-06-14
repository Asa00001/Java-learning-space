# Student Management System

A simple Java console-based Student Management System developed as a learning project.

The system supports student record management, data persistence using JSON, sorting, filtering, statistics, and summary reporting.

## Features

* Add Student
* Remove Student
* Update Student
* Search Student
* List and Sort Students
* Filter Students
* Count Total Students
* Calculate Average GPA
* Display Top 5 Students
* Display Failing Students
* Generate Summary Report

## Technologies Used

* Java
* Maven
* Gson
* JSON File Storage

## Project Structure

* Student.java
* StudentSystem.java
* StudentStorage.java
* InputValidation.java
* App.java

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Load Maven dependencies.
4. Run App.java.

## Data Storage

Student information is stored in a local JSON file (students.json).

## Acknowledgements

* This project was inspired by the Student Management System practice project from the Java-Projects-Collections repository by kishanrajput23.

* Project requirements and sample datasets were used as learning references. The implementation was completed independently in Java.


## Sample Output

```
================ SUMMARY ================
Average GPA: 2.86
Total Students: 29

=============== TOP 5 STUDENTS ===============
UID        Name                 Age  GPA   Year      Department
----------------------------------------------------------------
20231149   Chloe Anderson       19   3.90  First      AI        
20231144   Mason Carter         20   3.80  Second     CS        
20231173   Aria Wallace         19   3.80  First      AI        
20231158   Caleb Morris         21   3.60  Third      IS        
20231182   Sophie Reynolds      22   3.60  Fourth     AI        

============= FAILING STUDENTS =============
UID        Name                 Age  GPA   Year      Department
----------------------------------------------------------------
20231163   Aiden Gray           20   1.80  Second     IS        
20231181   Jackson Hayes        21   1.90  Third      CS        
20231164   Ava Turner           21   1.50  Third      CS        
20231165   Connor Blake         22   1.90  Fourth     AI        
20231166   Luna Freeman         19   1.70  First      DS        
20231186   Brooklyn Reed        22   1.90  Fourth     CS        

```