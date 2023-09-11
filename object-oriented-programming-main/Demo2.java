public class Demo2 {

    static int x = 10;
    public static void main(String[] args) {
        int x = 20;
        System.out.println(x);  // Shadowing
        System.out.println(Demo2.x);
    }
}
