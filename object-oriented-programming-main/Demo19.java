public class Demo19 {
    public static void main(String[] args) {
        Sub2 ref = new Sub2();
        Parent2 parentRef = ref;
        System.out.println(ref);
        System.out.println(parentRef);
        ref = (Sub2) parentRef;

        // System.out.println(s1.x);
        // s1.print();

    }
}

class Parent2 {
    int x = 10;
    void print(){
        System.out.println(x);
        System.out.println(this.x); 
        System.out.println(Parent2.this.x);

        // Sub2 ref = (Sub2) this; 
        // System.out.println(ref.x);      
        // System.out.println(((Sub2)this).x);        
    }
}

class Sub2 extends Parent2 {
    int x = 20; 
}
