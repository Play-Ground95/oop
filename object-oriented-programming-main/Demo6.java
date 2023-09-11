public class Demo6 {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Kasun");   // new Student + Student(1, "Kasun")
        Student s2 = new Student(2, "Nuwan");
        s2.name = s1.name;
        Student s3 = s1;
        s3.id = s2.id;
        System.out.printf("s1: id=%s, name=%s \n", s1.id, s1.name);
        System.out.printf("s2: id=%s, name=%s \n", s2.id, s2.name);
    }
}

class Student {
    int id;
    String name;

    public Student(int id, String name){
        super();
        // Invisible Line
        this.id = id;
        this.name = name;    
    }
}