/**
 * 单链表实现商品增删改查，并根据编号排序
 * @author Qiu
 * @data 2022/9/17 0017   22:10
 */
public class GoodNode {
    // 商品编号
    public int id;
    // 商品名称
    public String name;
    // 商品价格
    public double price;
    // 下一个节点的内存地址
    public GoodNode next;

    public GoodNode(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    @Override
    public String toString() {
        return "GoodNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
