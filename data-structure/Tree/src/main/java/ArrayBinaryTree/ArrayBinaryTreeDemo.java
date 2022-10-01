package ArrayBinaryTree;

/**
 *
 * 数组顺序存储二叉树
 * @author Qiu
 * @data 2022/9/25 0025   16:27
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        // 初始化数组
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7 };

        // 初始化数组二叉树
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(array);
        // 前序存储
        arrBinaryTree.preOrder();
        System.out.println();
        // 前序存储
        arrBinaryTree.infixOrder();
        System.out.println();
        // 前序存储
        arrBinaryTree.postOrder();
        System.out.println();
    }


}


/**
 * 初始化数组二叉树
 */
class ArrBinaryTree{
    // 存储数据的节点的数组
    private int[] array;

    public ArrBinaryTree(int[] array) {
        this.array = array;
    }

    // 重载preOrder方法
    public void preOrder(){
        this.preOrder(0);
    }


    // 重载infixOrder方法
    public void infixOrder(){
        this.infixOrder(0);
    }



    // 重载postOrder方法
    public void postOrder(){
        this.postOrder(0);
    }





    /**
     * 顺序存储二叉树的前序遍历
     * @param index 数组下标
     */
    public void preOrder(int index){
        // 如果数组为空，或者array.length = 0
        if(array == null || array.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }
        // 输出当前元素
        System.out.print(array[index] + " ");
        // 数组范围内，向左递归遍历
        if((index * 2 + 1) < array.length){
            preOrder( 2 * index + 1);
        }
        // 数组范围内，向右递归遍历
        if((index * 2 + 2) < array.length){
            preOrder( 2 * index + 2);
        }
    }

    /**
     * 顺序存储二叉树的中序遍历
     * @param index 数组下标
     */
    public void infixOrder(int index){
        // 如果数组为空，或者array.length = 0
        if(array == null || array.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }
        // 数组范围内，向左递归遍历
        if((index * 2 + 1) < array.length){
            infixOrder( 2 * index + 1);
        }
        // 输出当前元素
        System.out.print(array[index] + " ");
        // 数组范围内，向右递归遍历
        if((index * 2 + 2) < array.length){
            infixOrder( 2 * index + 2);
        }
    }


    /**
     * 顺序存储二叉树的后序遍历
     * @param index 数组下标
     */
    public void postOrder(int index){
        // 如果数组为空，或者array.length = 0
        if(array == null || array.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }
        // 数组范围内，向左递归遍历
        if((index * 2 + 1) < array.length){
            postOrder( 2 * index + 1);
        }

        // 数组范围内，向右递归遍历
        if((index * 2 + 2) < array.length){
            postOrder( 2 * index + 2);
        }
        // 输出当前元素
        System.out.print(array[index] + " ");
    }


}