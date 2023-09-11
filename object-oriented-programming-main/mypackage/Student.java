package mypackage;

public class Student {
    private int id;
    private String name;
    private String address;

    public String getId(){
        return "C" + id;
    }

    public int fetchId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void updateId(int id){
        this.id = id;
    }
}
