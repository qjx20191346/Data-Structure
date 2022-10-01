/**
 * 哈希表数组类
 * @author Qiu
 * @data 2022/9/23 0023   16:25
 */
public class HashTable {

    private StudentLinkedList[] studentLinkedLists;

    private int size;

    public HashTable(int size){
        // 初始化
        this.size = size;
        studentLinkedLists = new StudentLinkedList[size];

        // 数组中添加链表对象
        for(int i = 0; i < size; i++){
            studentLinkedLists[i] = new StudentLinkedList();
        }
    }

    /***
     * 哈希函数
     * @param sid
     * @return
     */
    public int hashCodes(int sid){
        return sid % size;
    }

    /**
     * 添加学生
     */
    public void add(Student student){
        // 决定数组中的下标
        int hashVal = hashCodes(student.id);
        // 向指定的链表对象中添加数据
        studentLinkedLists[hashVal].add(student);
    }

    /**
     * 遍历查看数组中的元素
     * @return
     */
    public void list(){
        for(int i = 0; i < size; i++){
            studentLinkedLists[i].list(i);
        }
    }

    /**
     * 根据学生id查询信息
     */
    public void findById(int id){
        int hashVal = hashCodes(id);

        Student students = studentLinkedLists[hashVal].findById(id);
        if (students != null){
            System.out.println("在第" + hashVal + "链表中找到学生信息。编号是" + id);
        }else{
            System.out.println("整个哈希表中未找到数据");
        }
    }
}
