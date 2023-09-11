public class Demo23 {
    public static void main(String[] args) {
        
    }
}

// final class MyLeafClass {

// }

// class MyChildClass2 extends MyLeafClass {

// }

abstract class MyNormalParentClass {
    void print(){
        System.out.println("I can override this print method");
    }
    final static void execute(){        // Leaf Methods

    }
    final void execute2(){              // Leaf Methods

    }
}

class MyNormalChildClass extends MyNormalParentClass {
    void print(){
        System.out.println("Hooray!");
    }
    // static void execute(){

    // }
    // void execute(){

    // }
}