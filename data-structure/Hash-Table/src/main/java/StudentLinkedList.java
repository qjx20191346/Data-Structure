/**
 * 哈希表链表类
 * @author Qiu
 * @data 2022/9/23 0023   15:59
 */
public class StudentLinkedList {

    // 头节点
    private Student head;


    // 添加节点

    public void add(Student student){
        if (head == null){
            // 添加的是第一个数据是第一个节点
            head = student;
            return;
        }
        Student temp = head;

        while (true){
            if (temp.next == null){
                // 是否有下一个节点
                break;
            }
            // 继续查找
            temp = temp.next;
        }
        // 追加新节点
        temp.next = student;
    }


    /**
     * 查看链表中的数据
     * @param no
     */
    public void list(int no){
        if(head == null){
            System.out.println("第" + no + "链表为空");
            return;
        }

        Student temp = head;
        while (true){
            System.out.print("id = " + temp.id + " name = " + temp.name + " ");

            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        System.out.println();
    }


    /**
     * 根据学生编号查询信息
     * @param id
     * @return
     */
    public Student findById(int id){
        if(head == null){
            System.out.println("空链表");
        }
        // 临时节点
        Student temp = head;
        // 循环查询数据
        while (true){
            if (temp.id == id){
                break;
            }
            if (temp.next == null){
                // 遍历所有节点，循环结束
                temp = null;
                break;
            }
            temp = temp.next;
        }
        return temp;
    }
}
