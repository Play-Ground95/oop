public class Demo5 {

    int x;

    public Demo5(int x){
        super();
        // Invisible Line
        this.x = x;
        System.out.println(this);
    }

    void print(){
        System.out.println("x=" + x);
    }

    public static void main(String[] args) {
        Demo5 ref1 = new Demo5(5);
        Demo5 ref2 = new Demo5(10);
        Demo5 ref3 = new Demo5(-8);
        System.out.println(ref1 instanceof Demo5);
        ref2.print();   // 10
        ref1.print();   // 5
        ref3.print();   // -8
    }
}
