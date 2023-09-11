public class Demo18 {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.breakCar();   // A. 2,3 B. 2,1
    }
}

class Vehicle {
    void drive(){
        System.out.println("1. Vehicle is driving");
    }
    void breakCar(){
        System.out.println("2. Breaking");
        drive();
        this.drive();
        Vehicle.this.drive();
        ((Vehicle)(this)).drive();
    }
}

class Car extends Vehicle {

    void drive(){
        System.out.println("3. Driving");
    }
}
