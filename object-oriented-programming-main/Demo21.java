public class Demo21 {
    public static void main(String[] args) {
        Sup s = new Chi();
        s.execute();
    }
}

class Sup {
    int x = 10;
    void execute(){
        print();
    }
    void print(){
        System.out.println(x);
    }
}

class Chi extends Sup {
    int x = 20;
    void execute(){
        super.execute();
    }
    void print(){
        System.out.println(x);
    }
}
