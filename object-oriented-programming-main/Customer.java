public class Customer{

    public static String something = "Hello";   // Static Variable
    public int batch = 11;                      // Instance Variable

    /* Object/Instance Initializer */
    {
        System.out.println("Instance Initializer 1");
    }

    public Customer () {
        super();
        // Invisible Line (Object is being initialized here)
        System.out.println("Customer() constructor");
    }
    
    static {
        System.out.println("Customer class is being initialized");
    }

    public static void doSomething(){
        System.out.printf("%s World! \n", something);
    }

    {
        System.out.println("Instance Initializer 2");
    }

    public void print(){
        System.out.println("Direct Entry Program - " + batch);
    }
}
