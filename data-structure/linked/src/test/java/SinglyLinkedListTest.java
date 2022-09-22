/**
 * @author Qiu
 * @data 2022/9/18 0018   11:41
 */
public class SinglyLinkedListTest {

    public static void main(String[] args) {

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        GoodNode goodNode1 = new GoodNode(1, "a", 600);
        GoodNode goodNode2 = new GoodNode(2, "b", 700);
        GoodNode goodNode3 = new GoodNode(3, "c", 500);
        GoodNode goodNode4 = new GoodNode(4, "d", 300);
        GoodNode goodNode5 = new GoodNode(5, "e", 200);

        /*linkedList.add(goodNode1);
        linkedList.add(goodNode2);
        linkedList.add(goodNode3);
        linkedList.add(goodNode4);
        linkedList.add(goodNode5);*/

        singlyLinkedList.addOrder(goodNode3);
        singlyLinkedList.addOrder(goodNode2);
        singlyLinkedList.addOrder(goodNode5);
        singlyLinkedList.addOrder(goodNode4);
        singlyLinkedList.addOrder(goodNode1);

        singlyLinkedList.updateNode(new GoodNode(2,"f",111));
        //linkedList.delNote(5);
        System.out.println(singlyLinkedList.getLength());

        singlyLinkedList.list();
    }




}
