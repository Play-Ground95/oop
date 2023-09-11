public class Demo3 {
    public static void main(String[] args) {
        // new  Customer
        //      Customer()
        new Customer();
        /* Output:
         * Customer class is being initialized
         * Instance Initializer 1
         * Instance Initializer 2
         * Customer() constructor
         */
        System.out.println("------------------");
        new Customer(); // new Customer + Customer()
        /* Output:
         * Instance Initializer 1
         * Instance Initializer 2
         * Customer() constructor
         */
    }
}
