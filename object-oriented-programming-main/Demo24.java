import mypackage.Customer;

public class Demo24 {
    public static void main(String[] args) {
        CrazyCustomer customer = new CrazyCustomer();
        // customer.id = 1;
        // customer.name = "Kasun";
        // customer.address = "Galle";
        customer.contact = "078-1234567";
        customer.print();
    }
}

class CrazyCustomer extends Customer {
    CrazyCustomer(){
        // id = 1;
        // name = "Kasun";
        address = "Galle";
        contact = "078-1234567";
    }
    public void print(){
        super.print();
    }
}