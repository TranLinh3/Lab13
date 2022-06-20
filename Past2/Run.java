package Past2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Run {
    private static Scanner input = new Scanner(System.in);
    private static StudentList list;
    public static void menu(){
        System.out.println("1. Add student");
        System.out.println("2. Update a Student");
        System.out.println("3. Delete a Student");
        System.out.println("4. Search Students");
        System.out.println("5. Display All Student");
        System.out.println("6. Save to File");
        System.out.println("7. Load from File");
        System.out.println("8. Exit");
        System.out.println("Your choice :");
    }
    public static void main(String[] args) throws IOException{
        Run entryList = new Run();
        list = new StudentList();
        Scanner sc = new Scanner(System.in);
        entryList.menu();
        while(true) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    menu();
                    break;
                case 2:
                    updateStudents();
                    menu();
                    break;
                case 3:
                    deleteStudent();
                    menu();
                    break;
                case 4:
                    searchById();
                    menu();
                    break;
                case 5:
                    displayStudents();
                    menu();
                    break;
                case 6:
                    saveToFile();
                    menu();
                    break;
                case 7:
                    showFile();
                    menu();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nothing Happen!!");
                    break;
            }
        }
    }
    public static void addStudent(){
        int id = 0;
        String n;
        int age;
        double mark;
        System.out.println("Enter student ID: ");
        id = input.nextInt();
        System.out.println("Enter name: ");
        n = input.next();
        System.out.println("Enter age: ");
        age = input.nextInt();
        System.out.println("Enter mark: ");
        mark = input.nextDouble();
        Student s = new Student(id, n, age, mark);
        list.add(s);
    }
    public static void deleteStudent() {
        int id;
        System.out.println("Enter student id: ");
        id = input.nextInt();
        list.remove(id);
    }

    public static void searchById() {
        int id;
        System.out.println("Enter an ID: ");
        id = input.nextInt();
        Student s = list.findById(id);
        if (s==null) {
            System.out.println("Not found");
        } else {
            s.printInfo();
        }
    }
    public static void displayStudents(){
        list.showList();
    }
    public static void updateStudents(){
        list.update();
    }
    public static void saveToFile() throws IOException{

        Gson gson = new Gson();
        FileWriter writer = new FileWriter("student.json");
        gson.toJson(list,writer);
        writer.close();

    }
    public static void showFile() throws IOException{

        Gson gson = new Gson();
        FileReader reader = new FileReader("student.json");
        list = gson.fromJson(reader,new TypeToken<List<Student>>(){}.getType());
        reader.close();

    }
}