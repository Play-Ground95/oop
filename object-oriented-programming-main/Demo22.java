public class Demo22 {
    public static void main(String[] args) {
        new MyChildClass(10);
    }
}

class MyParentClass {

}

class MyChildClass extends MyParentClass {
    {
        System.out.println("I am being initialized");
    }
    public MyChildClass(){
        this(10);
        System.out.println("MyChildClass()");
    }

    public MyChildClass(int id){
        //super();
        this(id, "Kasun");
        System.out.println("MyChildClass(int)");
    }
    
    public MyChildClass(int id, String name){
        super();
        System.out.println("i am id and name constructor");
    }
}
