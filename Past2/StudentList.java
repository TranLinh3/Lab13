package Past2;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    Scanner sc = new Scanner(System.in);
    public StudentList(){
        list = new ArrayList<Student>();
    }
    private ArrayList<Student> list;


    public Student findById(int id) {
        for (Student s:list) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
    public void add(Student s){
        list.add(s);
    }

    public void remove(int id){
        boolean found = false;
        for (Student s: list) {
            if (s.getId() == id) {
                int choice;
                System.out.println("Are you sure deleting this student? \n1.Yes\n2.No");
                choice = new Scanner(System.in).nextInt();
                if (choice == 1)
                    list.remove(s);
                System.out.println("Học sinh đã bị xoá");
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Cannot find student with id "+id);
        }
    }
    public void showList() {

        for (Student s: list) {
            s.printInfo();
        }

    }

    public void showList(ArrayList<Student> slist){
        list.forEach(student -> System.out.println(student));
        for (Student s: slist) {
            s.printInfo();
        }
    }
    public void update(){
        Scanner sc = new Scanner(System.in);
        String name;
        int age;
        double mark;
        System.out.println("1.Change name\n2.Change age\n3.Change mark");
        int choose = sc.nextInt();
        switch (choose){
            case 1:
                System.out.println("Enter Student with ID: ");
                int id = sc.nextInt();
                for (Student a : list) {
                    if (a.getId() == id) {
                        System.out.println("Student ID: " + id);
                        System.out.println("Name: " + a.getName());
                        System.out.println("Enter new name: ");
                        name = sc.next();
                        a.setName(name);
                    }
                }
                break;
            case 2:
                System.out.println("Enter Student with ID: ");
                int id1 = sc.nextInt();
                for (Student a : list) {
                    if (a.getId() == id1) {
                        System.out.println("Student ID: " + id1);
                        System.out.println("Age: " + a.getAge());
                        System.out.println("Enter new age: ");
                        age = sc.nextInt();
                        a.setAge(age);
                    }
                }
                break;
            case 3:
                System.out.println("Enter Student with ID: ");
                int id2 = sc.nextInt();
                for (Student a : list) {
                    if (a.getId() == id2) {
                        System.out.println("Student ID: " + id2);
                        System.out.println("Mark  " + a.getMark());
                        System.out.println("Enter new mark: ");
                        mark = sc.nextDouble();
                        a.setMark(mark);
                    }
                }
                break;
            default:
                System.out.println("Nothing happen??");
                break;
        }
    }

}
