/**
 * @author Qiu
 * @data 2022/9/23 0023   15:57
 */
public class Student {

    public int id;
    public String name;

    // 指向下一个节点的指针
    public Student next;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getNext() {
        return next;
    }

    public void setNext(Student next) {
        this.next = next;
    }
}
