/**
 * @author Qiu
 * @data 2022/9/18 0018   16:56
 */
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        // 初始化双向链表
        DoubleLinkedList linkedList = new DoubleLinkedList();

        BookNode bookNode1 = new BookNode(1, "aa", 66);
        BookNode bookNode2 = new BookNode(2, "bb", 76);
        BookNode bookNode3 = new BookNode(3, "cc", 86);
        BookNode bookNode4 = new BookNode(4, "dd", 96);

        linkedList.addLast(bookNode1);
        linkedList.addLast(bookNode2);
        linkedList.addLast(bookNode3);
        linkedList.addLast(bookNode4);

        linkedList.delNode(1);

        linkedList.list();
    }


}
