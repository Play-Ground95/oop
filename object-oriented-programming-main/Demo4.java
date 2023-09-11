public class Demo4 {
    static int x = 5;

    public Demo4(){
        super();
        // Invisible Line
        System.out.println("Constructor Body");
    }

    {
        System.out.println("Object is being initialized");
    }

    void print(){
        int x = 10;
        System.out.println(x);
    }

    static{
        System.out.println("Demo4 is being initialized");
    }

    public static void main(String[] args) {
        System.out.println("--------------");
        new Demo4().print();
    }
}
