import java.sql.SQLException;

public class Demo15 {
    public static void main(String[] args) {
        B ref = new C();
        System.out.println(ref.x);
        // ref.myMethod();
        ref.myMethod();
    }
}

class A {
    {
        System.out.println("A's intance initializer");
        //System.out.println("x in A = " + x);
    }
    int x = 10;
    public A(){
        super();
        System.out.println("A's constructor");
        System.out.println("x in A = " + x);
        System.out.println("x in B = " + ((B) this).x);
        System.out.println("x in C = " + ((C) this).x);
    }
    static {
        System.out.println("A class is being initialized");
    }
    // void myMethod(){
    //     System.out.println("B's myMethod()");
    // }
}

class B extends A {
    int x = 20;
    public B(){
        System.out.println("B's constructor");
    }
    static {
        System.out.println("B class is being initialized");
    }
    {
        System.out.println("B's intance initializer");
    }
    public void myMethod(){
        System.out.println("B's myMethod()");
    }
}

class C extends B {
    int x = 30;
    public C(){
        System.out.println("C's constructor");
        System.arraycopy(getClass(), x, getClass(), x, x);
    }
    static {
        System.out.println("C class is being initialized");
    }
    {
        System.out.println("C's intance initializer");
    }
    public void myMethod() {//throws SQLException, ClassNotFoundException{
        System.out.println("C's myMethod()");
    }
}

class Super extends Object{}
class Sub extends Super {}
