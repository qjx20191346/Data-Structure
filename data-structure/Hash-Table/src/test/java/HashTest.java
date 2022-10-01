/**
 * @author Qiu
 * @data 2022/9/23 0023   16:55
 */
public class HashTest {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable(10);

        //添加学生信息
        Student student1 = new Student(1, "张三");
        Student student2 = new Student(2, "李四");
        Student student3 = new Student(3, "王五");
        Student student4 = new Student(4, "马六");
        Student student5 = new Student(4, "王二麻子");
        hashTable.add(student1);
        hashTable.add(student2);
        hashTable.add(student3);
        hashTable.add(student4);
        hashTable.add(student5);
        hashTable.list();

        hashTable.findById(4);
    }
}
