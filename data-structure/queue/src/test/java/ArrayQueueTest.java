/**
 * @author Qiu
 * @data 2022/9/19 0019   21:45
 */
public class ArrayQueueTest {

    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(5);

        aq.add(1);
        aq.add(2);
        aq.add(3);
        aq.add(4);
        aq.add(5);

        int i = aq.get();
        System.out.println(i);

        aq.findQueue();
    }
}
