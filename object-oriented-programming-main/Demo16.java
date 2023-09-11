public class Demo16 {
    static int y = 10;

    public static void main(String[] args) {
        String y = "IJSE";

        MyB ref = new MyC();
        ref.myFun();
    }
}

class MyA{
   int x = 20;
   void myMethod(){
    System.out.println("MyA:" + x);
   }
   static void myFun(){
        System.out.println("MyA Function");
   }
}

class MyB extends MyA{
    static String x = "10";
    // static void myFun(){
    //     System.out.println("MyB Function");
    // }
}

class MyC extends MyB{
    @Override
    void myMethod(){
        System.out.println("MyC:" + x); 
    }

    static void myFun(){
        System.out.println("MyC Function");
    }
}
