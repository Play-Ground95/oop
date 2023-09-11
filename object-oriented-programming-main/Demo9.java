import java.util.Arrays;
public class Demo9 {

    public static void main(String[] args) {
        /* Page 2 */ Stack s1 = /* Page 1 */ new Stack();

        s1.push(10); /* Page 3 */
        s1.push(20); /* Page 4 */
        s1.print(); /* Page 5 */
    }
    
}

class Stack {
    int numbers[] = new int[0];

    public Stack() {
    }

    void push(int number){
        int[] temp = new int[numbers.length + 1];
        for (int i = 0; i < numbers.length; i++) {
            temp[i] = numbers[i];
        }
        temp[temp.length - 1] = number;
        numbers = temp;
    }

    void print(){
        System.out.println(Arrays.toString(numbers));
    }
}
