public class Demo13 {
   public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.a);
        child.myMethod();
        System.out.println(child.x);
        System.out.println(child.y);
        child.myStaticMethod();
        child.myInstanceMethod();
        System.out.println(child.toString());
   } 
}

class Parent extends Object{
    static int x;

    static{
        System.out.println("Parent class is being initialized");
    }

    {
        System.out.println("Parent instance initializer" + this);
    }

    int y;
    public Parent(){
        super();
        System.out.println("Parent Constructor" + this);
    }

    static void myStaticMethod(){}

    void myInstanceMethod(){}
}

class Child extends Parent {

    static {
        System.out.println("Child class is being initialized");
    }

    {
        System.out.println("Child instance initializer" + this);
    }

    public Child(){
        super();
        System.out.println("Child Constructor" + this);
    }
    int a;
    void myMethod(){}
}