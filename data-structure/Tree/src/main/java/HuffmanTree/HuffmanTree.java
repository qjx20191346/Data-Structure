package HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 霍夫曼树
 * @author Qiu
 * @data 2022/9/26 0026   20:45
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] array = {13, 7, 8, 3, 29, 6, 1};
        Node root = CreateHuffmanTree(array);
        // 测试
        preOrder(root);
    }

    /**
     * 测试HuffmanTree树创建成功, 遍历
     */
    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        } else{
            System.out.println("空树，无法遍历");
        }

    }


    /**
     * 创建HuffmanTree
     * @param array 需要创建创建HuffmanTree树的数组
     * @return 创建好的HuffmanTree树节点
     */
    public static Node CreateHuffmanTree(int[] array){

        /**
         * 1. 遍历数组
         * 2. 将数组中每个元素构成一个Node
         * 3. 将Node 放入的到ArrayList中
         */
        List<Node> nodes = new ArrayList<>();
        for(int value : array){
            nodes.add(new Node(value));
        }

        /**
         * 循环处理数组
         */
        while (nodes.size() > 1){
            // 排序 从小到大
            Collections.sort(nodes);
            System.out.println("nodes = " + nodes);

            /**
             * 取出根节点权值最小的两颗二叉树
             * 1. 取出权值最小的二叉树
             * 2. 取出权值第二小的节点
             * 3. 构建一颗新的二叉树
             * 4. 从ArrayList删除处理过的二叉树
             * 5. 将新生成的节点加入nodes
             */

            // 1. 取出权值最小的二叉树
            Node leftNode = nodes.get(0);
            // 2. 取出权值第二小的节点
            Node rightNode = nodes.get(1);
            // 3. 构建一颗新的二叉树，left.value + right.value 父节点的权值
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            // 4. 从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 5. 将新生成的节点加入nodes
            nodes.add(parent);
        }
        // 返回HuffmanTree的root节点
        return nodes.get(0);
    }

}


/**
 * 创建节点类
 *
 * 为了让Node 对象支持排序一般让类实现Collections 集合排序
 * 让Node实现Comparable 接口
 */
class Node implements Comparable<Node> {

    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }

    }




    /**
     * 节点权值
     */
    int value;
    /**
     * 指向左节点
     */
    Node left;
    /**
     * 指向右节点
     */
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


    @Override
    public int compareTo(Node o) {
        // 从小到大排序
        return this.value - o.value;
    }
}