/**
 * @author Qiu
 * @data 2022/9/19 0019   14:46
 */
public class CircleSinglyLinkedList {
    // 首节点
    private Boy first = new Boy(-1);



    /**
     * 根据环形链表
     */

    public void addBoy(int nums){
        if(nums < 1){
            System.out.println("数据不正确");
            return;
        }
        // 临时节点
        Boy temp = null;
        for(int i = 1; i <= nums; i++){
            Boy boy = new Boy(i);

            // 判断是否是第一个数据
            if(i == 1){
                first = boy;
                // 第一个元素指向自己
                first.setNext(first);
                temp = first;
            }else{
                temp.setNext(boy);
                boy.setNext(first);
                temp = boy;
            }

        }


    }


    /**
     * 查看环形链表的节点
     */

    public  void showBoy(){

        if(first == null){
            System.out.println("链表为空");
            return;
        }
        Boy boy = first;
        while (true){
            System.out.println("该节点的编号为"+boy.getNo());
            if (boy.getNext() == first){
                // 遍历结束，最后一个节点
                break;
            }
            // 指针移动，遍历节点
            boy = boy.getNext();
        }
    }

    /**
     * 打印出约瑟夫问题的顺序
     * @param starNo 开始节点
     * @param countNum 数的次数
     * @param nums 节点总数
     */
    public void countBoy(int starNo, int countNum, int nums){
        if (first == null || starNo < 1 || starNo > nums){
            System.out.println("参数错误");
            return;
        }

        /**
         * 定义辅助指针，指向最后一个节点
         */
        Boy helper = first;
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }


        /**
         * 寻找起始位置,把first重新定义为起始位置
         */

        for(int j = 0; j < starNo - 1; j++){
            first = first.getNext();
            helper = helper.getNext();
        }


        /**
         * 开始计数时，数到m的字节出列, first 和  helper移动m-1次，即可找到出列的字节
         */
        while (true){
            if(helper == first){
                // 只有以恶节点
                break;
            }
            for(int j = 0; j < countNum - 1; j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println(first.getNo() + "号字节出列");
            first = first.getNext();
            // 辅助节点相连
            helper.setNext(first);
        }
        // 只剩下最后一个字节
        System.out.println("最后出列的字节编号是" + first.getNo());

    }


}
