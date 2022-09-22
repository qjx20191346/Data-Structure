/**
 * 单向链表对GoodNode的操作
 * @author Qiu
 * @data 2022/9/17 0017   22:21
 */
public class SinglyLinkedList {
    // 头节点
    private GoodNode node = new GoodNode(0,"",0.0);


    /**
     * 向链表中添加节点
     * @param goodNode
     */
    public void add(GoodNode goodNode){
        GoodNode temp = node;
        while (true){
            if(temp.next == null){
                // 存在空节点，停止遍历,插入数据
                break;
            }
            // 不为空，再向后取，直到取到空节点，插入数据
            temp = temp.next;
        }
        // 如果最后没有相关联的数据节点，新建节点，添加节点，插入数据
        temp.next = goodNode;
    }


    /**
     * 按照id值进行添加，按id的大小，从小到大的顺序添加
     */
    public void addOrder(GoodNode goodNode){
        // 标识
        boolean flag = false;
        GoodNode temp = node;
        //判断新老节点的冲突
        while (true){
            if(temp.next == null){
                break;
            }
            // 存在下一个节点就再次获取节点
            if (temp.next.id > goodNode.id){
                // 按id排序,锁定位置，无需继续遍历，可以继续存储
                break;
            }
            else if (temp.next.id == goodNode.id){
                flag = true;
                // 禁止重复, 无法存储
                break;
            }
            temp = temp.next;
        }
        // 如果标识为true，表示id重复，即节点重复，无法添加节点
        if(flag){
            System.out.println("已经存在该物品，无法重复添加");
        }else{
            goodNode.next = temp.next;
            temp.next = goodNode;
        }
    }


    /**
     * 修改节点
     */

    public void updateNode(GoodNode goodNode){
        // 判断链表是否为空
        if(node.next == null){
            System.out.println("此链表为空");
        }
        // 临时存放
        GoodNode temp = node.next;
        // 区分何时跳出循环，标识符，true表示找到结点
        boolean flag = false;
        while(true){
            if (temp == null){
                break;
            }
            // id重复
            if (temp.id == goodNode.id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            // 修改节点
            temp.name = goodNode.name;
            temp.price = goodNode.price;
        }else{
            System.out.println("在整个链表中未找到目标结点");
        }
    }


    /**
     * 结点删除
     * 根据节点编号删除
     */

    public void delNote(int id){

        GoodNode temp = node;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                // 为找到
                break;
            }
            if (temp.next.id == id){
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("在整个链表中未找到目标结点");
        }
    }

    /**
     * 查看链表中所有元素
     */

    public void list(){
        if(node.next == null){
            System.out.println("链表为空");
            return;
        }
        // 获取节点
        GoodNode temp = node.next;
        while (true){
            if (temp == null){
                // 循环遍历结束，无节点
                break;
            }
            // 获取元素
            System.out.println(temp);
            // 获取所有元素
            temp = temp.next;
        }
    }


    /**
     * 面试题
     * 计算单链表中存在的节点个数
     * 不统计头节点
     */
    public int getLength(){
        if(node.next == null){
            System.out.println("空链表");
            return 0;
        }

        GoodNode temp = node.next;
        int length = 0;
        // 不为空，通过长度计算节点数
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }





}
