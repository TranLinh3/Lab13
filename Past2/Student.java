package Past2;
import java.util.Scanner;

public class Student {
    public int id;
    public String name;
    public int age;
    public double mark;

    public Student(){
    }
    public Student(int id, String name, int age, double mark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    public void scanInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        this.id = scanner.nextInt();
        System.out.println("Enter name: ");
        this.name = scanner.nextLine();
        System.out.println("Enter age: ");
        this.age = scanner.nextInt();
        System.out.println("Enter mark: ");
        this.mark = scanner.nextDouble();
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getId() {
        return id;
    }
    public double getMark() {
        return mark;
    }
    public void printInfo(){
        System.out.printf("%3d|%10s|%3d|%5f\n", getId(), getName(), getAge(), getMark());
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
