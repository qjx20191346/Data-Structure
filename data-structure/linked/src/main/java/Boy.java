/**
 * 节点类对象
 * 约瑟夫问题，单向链表闭合回路
 * @author Qiu
 * @data 2022/9/18 0018   21:45
 */
public class Boy {
    // 编号
    private int no;
    // 指向下一个节点
    private Boy next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy(int no) {
        this.no = no;
    }
}
