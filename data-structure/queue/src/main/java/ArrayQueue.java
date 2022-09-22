/**
 * 数组实现队列插入
 * @author Qiu
 * @data 2022/9/19 0019   21:28
 */
public class ArrayQueue {

    // 定义数组
    private int[] array;
    // 设置容量大小
    private int maxSize;
    // 设置头指针, 默认指向-1
    private int frontPoint;
    // 设置尾指针, 默认指向-1
    private int rearPoint;


    /**
     * 队列初始化
     * @param maxSize
     */
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        array = new int[maxSize];

        frontPoint = -1;
        rearPoint = -1;
    }


    /**
     * 判断队列是否为满队列
     * @return
     */
    public boolean isFull(){
        // 尾指针指向队列最大值减一
        return rearPoint == maxSize - 1;
    }

    /**
     * 判断队列是否为空队列
     * @return
     */
    public boolean isEmpty(){
        return frontPoint == rearPoint;
    }

    /**
     * 添加元素进入队列
     */

    public void add(int n){
        // 判断是否为满队列
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        // 指针后移
        rearPoint++;
        // 数据添加到指针位置
        array[rearPoint] = n;
    }


    /**
     * 获取队列元素并且删除元素，出队列
     */
    public int get(){
        if(isEmpty()){
            throw new  RuntimeException("队列已空");
        }
        // 头指针后移
        frontPoint++;
        return array[frontPoint];
    }


    /**
     * 查看队列的所有元素
     */
    public void findQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列已空");
        }
        for(int i = 0; i < array.length; i++){
            System.out.println("array["+i+"] = " + array[i]);
        }
    }

    /**
     * 查看队头元素，不是出队列
     */
    public int frontQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列已空");
        }
        return array[frontPoint + 1];
    }



}
