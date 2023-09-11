public class Demo17 {
    public static void main(String[] args) {
        Animal pet = new Dog("Boola");
        System.out.println(pet.name);
        pet.eat();
    }
}

class Animal {
    String name = "Animal";

    void eat(){
        System.out.printf("%s is eating \n", name);
    }
}

class Dog extends Animal {
    String name;

    public Dog(String name){
        this.name = name;
    }

    void eat(){
        System.out.printf("%s is eating \n", name);
        super.eat();
        System.out.println(super.name);
        // System.out.println(this);  this is a special local variable
        // System.out.println(super); super is not a local variable
    }
}
