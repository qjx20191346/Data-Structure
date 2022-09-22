/**
 * @author Qiu
 * @data 2022/9/19 0019   16:02
 */
public class CircleSinglyLinkedListTest {

    public static void main(String[] args) {

        // 初始化对象
        CircleSinglyLinkedList cl = new CircleSinglyLinkedList();
        cl.addBoy(5);
        cl.showBoy();

        // 起始为1号，间隔为2，总计5个节点
        cl.countBoy(1, 2, 5);
    }
}
