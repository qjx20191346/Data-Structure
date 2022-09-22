/**
 * 双向链表对BookNode的操作
 * @author Qiu
 * @data 2022/9/18 0018   16:55
 */
public class DoubleLinkedList {
    // 头节点
    private BookNode head = new BookNode(0, "", 0.0);

    /**
     * 在结尾添加新的节点
     * @param bookNode
     */
    public void addLast(BookNode bookNode){
        // 获取头节点
        BookNode temp = head;

        while(true){
            if(temp.next == null){
                // 空双向链表
                break;
            }
            temp = temp.next;
        }
        //前节点指向添加节点，添加节点指向前节点和后节点，添加节点的next
        temp.next = bookNode;
        bookNode.pre = temp;
    }


    /**
     * 修改节点
     * 通过id进行对比，id相同则修改，id不同，则未找到节点
     */
    public void updateNode(BookNode bookNode){
        boolean flag = false;
        if(head.next == null){
            // 空双向链表
            System.out.println("空双向链表");
            return;
        }
        BookNode temp = head.next;

        while(true){
            // 节点为空值
            if (temp == null){
                break;
            }
            // 找到节点
            if (temp.id == bookNode.id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = bookNode.name;
            temp.price = bookNode.price;
        }else {
            System.out.println("未找到要修改的节点");
        }
    }

    /**
     * 双向链表删除节点
     */
    public void delNode(int id){
        if(head.next == null){
            System.out.println("空链表。。。");
            return;
        }
        BookNode temp = head.next;
        boolean flag = false;
        while(true){
            // 空链表
            if (temp == null){
                break;
            }
            if (temp.id == id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.pre.next = temp.next;
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.println("未找到节点");
        }

    }

    public void list() {
        if (head.next == null) {
            System.out.println("空链表。。。");
            return;
        }
        // 获取节点
        BookNode temp = head.next;
        while (true) {
            if (temp == null) {
                // 循环遍历结束，无节点
                break;
            }
            // 获取元素
            System.out.println(temp);
            // 获取所有元素
            temp = temp.next;
        }
    }

}
