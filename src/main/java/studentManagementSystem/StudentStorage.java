package studentManagementSystem;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class StudentStorage {
    private static final String FILE_PATH ="students.json";

    public static List<Student> loadStudents(){
        Gson gson = new Gson();
        Type type = new TypeToken<List<Student>>(){}.getType();

        try(FileReader fileReader = new FileReader(FILE_PATH)){
            List<Student> students = gson.fromJson(fileReader, type);

            if(students == null){
                return new ArrayList<>();
            }

            return students;
        } catch (Exception e) {
            System.out.println("Failed to load students.");
            return new ArrayList<>();
        }
    }

    public static void saveStudents(List<Student> students){
        Gson gson = new Gson();

        try(FileWriter fileWriter = new FileWriter(FILE_PATH)){
           gson.toJson(students, fileWriter);
        } catch (Exception e) {
            System.out.println("Failed to save students.");
        }
    }
}
