/**
 * @author Qiu
 * @data 2022/9/18 0018   16:50
 */
public class BookNode {

    public int id;
    public String name;
    public double price;

    // 下一个节点 直接后继
    public BookNode next;
    // 上一个节点 直接前驱
    public BookNode pre;

    public BookNode(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
