public class Demo1 {
    public static void main(String[] args) throws Exception{
        // Explicitly 
        // Class.forName("Customer");

        // Implicitly

        // 1. Accessing Static Members
        // System.out.println(Customer.something);
        // Customer.doSomething();

        // 2. Creating New Instances
        new Customer();
    }
}