import java.util.ArrayList;

public class Demo7 {
    public static void main(String[] args) {

    }
}

class Employee{
    int id;
    String firstName;
    String lastName;
    ArrayList<String> contactList;
    String spouseName;
    static String branch;

    Employee(int id, String firstName, String lastName, ArrayList<String> contactList){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactList = contactList;
    }

    Employee(int id, String firstName, String lastName, 
                        ArrayList<String> contactList, String spouseName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactList = contactList;
        this.spouseName = spouseName;
    }    
}
