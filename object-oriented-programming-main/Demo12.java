public class Demo12 {

    public static void main(String[] args) {
        Stack2 stack = new Stack2();
        stack.push(10);
        // stack.push(20);
        // stack.push(30);
        // stack.push(40);
        // stack.push(25);
        // stack.print();
    }
}

class Stack2 {
    Node head;
    Node tail;

    void push(int number){
        if (head == null){
            head = new Node(number, null);
            tail = head;
        }else{
            tail.next = new Node(number, null);
            tail = tail.next;
        }
    }

    int peek(){
        if (tail == null) throw new RuntimeException("Stack is empty");
        return tail.value;
    }

    void print(){
        if (head == null){
            System.out.println("[]");
        }else{
            System.out.print("[");
            Node temp = head;
            while (temp != null){
                System.out.print(temp.value + ",");
                temp = temp.next;
            }
            System.out.println("\b]");
        }
    }
}

class Node {
    int value;
    Node next;

    public Node(int value, Node next) {

        this.value = value;
        this.next = next;
    }  
}