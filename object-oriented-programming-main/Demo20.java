public class Demo20 {
    public static void main(String[] args) {
        MyChild2 mc = new MyChild2("abc");
        mc.doSomething(20);  // A. 20, B. abc, C. 10
    }
}

class MySuper2 {
    int x = 10;
    void abc(){
        ((MyChild2)(this)).print(((MyChild2)(this)).x);
    }
}

class MyChild2 extends MySuper2{
    static String x;
    MyChild2(String x){
        this.x = x;
    }
    void print(Object x){
        System.out.println(x);
    }
    void doSomething(double x){
        super.abc();

        // System.out.println(x);
        // System.out.println(this.x);
        // System.out.println(super.x);
        // System.out.println(MyChild2.this.x);
        // System.out.println(MyChild2.super.x);
        // MySuper2 superRef = this;
        // System.out.println(superRef.x);
        // System.out.println(((MyChild2)superRef).x);
    }
}