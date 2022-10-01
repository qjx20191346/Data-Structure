/**
 * 二叉排序树
 * @author Qiu
 * @data 2022/9/28 0028   15:47
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] array = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        // 循环添加节点到二叉排序树
        for(int i = 0; i < array.length; i++){
            binarySortTree.add(new Node(array[i]));
        }
        // 中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树");
        binarySortTree.infixOrder();

        // 测试删除叶子节点
        binarySortTree.delNode(10);
        //binarySortTree.delNode(9);

        System.out.println("root = " + binarySortTree.getRoot());
        System.out.println("删除节点后");
        binarySortTree.infixOrder();


    }
}


/**
 * 创建二叉排序树
 */
class BinarySortTree{
    // 根节点
    private Node root;


    public Node getRoot() {
        return root;
    }

    /**
     * 添加节点
     * @param node 待排序节点
     */
    public void add(Node node){
        if(root == null){
            root = node;
        } else{
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }else{
            System.out.println("二叉排序树为空，无法遍历");
        }
    }

    /**
     * 查找要删除的节点
     * @param value 希望删除的节点的值
     * @return 如果找到返回要删除的节点，未找到返回null
     */
    public Node search(int value){
        if(root == null){
            return null;
        }else{
            return root.search(value);
        }
    }


    /**
     * 查找要删除的节点的父节点
     * @param value 希望删除的结点的值
     * @return 如果找到返回要删除节点的父节点，未找到返回null
     */
    public Node searchParent(int value){
       if(root == null){
           return null;
       }else{
           return root.searchParent(value);
       }
    }


    /**
     * 删除节点
     * @param value 待删除节点的值
     */
    public void delNode(int value){
        if(root == null){
            return;
        }else{
            // 1. 先找到要删除的节点
            Node targetNode = search(value);
            // 如果没有找到要删除的节点
            if(targetNode == null){
                return;
            }
            // 如果当前二叉排序树只有一个节点
            if(root.left == null && root.right == null){
                root = null;
                return;
            }
            // 去找到targetNode的父节点
            Node parent = searchParent(value);
            // 如果要删除的节点是叶子节点
            if(targetNode.left == null && targetNode.right == null){
                // 判断targetNode是父节点的左子节点还是右子节点
                if(parent.left != null && parent.left.value ==value){
                    // 是左子节点
                    parent.left = null;
                }else if (parent.right != null && parent.right.value == value){
                    // 是右子节点
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                // 删除右两颗子树的节点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            }else{
                // 删除只有一颗子树的节点
                // 判断要删除的节点是左子节点还是右子节点
                // 如果要删除的节点有左子节点
                if(targetNode.left != null){
                    if(parent != null){
                        // 如果targetNode 是parent的左子节点
                        if(parent.left.value == value){
                            parent.left = targetNode.left;
                        }else{
                            // targetNode 是parent的右子节点
                            parent.right = targetNode.left;
                        }
                    }else{
                        root = targetNode.left;
                    }
                }else{
                    if(parent != null){
                        // 要删除的节点有右子节点
                        // 如果targetNode 是parent的左子节点
                        if(parent.left.value == value){
                            parent.left = targetNode.right;
                        }else{
                            // 如果targetNode 是parent的右子节点
                            parent.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }


    /**
     * 1. 返回以node位节点的二叉排序树的最小节点的值
     * 2. 删除node 为根节点的二叉排序树的最小节点
     * @param node 传入节点（当作二叉树的根节点）
     * @return 返回的以node位根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node){
        Node target = node;
        // 循环查找左子节点，找到最小值
        while (target.left != null){
            target = target.left;
        }
        // 这是 target指向最小节点
        delNode(target.value);
        return target.value;
    }


}




class Node{
    int value;
    Node left;
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




    /**
     * 按照二叉排序树的方式添加节点
     * @param node 添加的节点
     */
    public void add(Node node){
        if(node == null){
            return;
        }
        // 判断节点值与当前指数的根节点的值的关系
        if(node.value < this.value){
            // 当前节点的左子节点为空
            if(this.left == null){
                this.left = node;
            }else{
                // 递归的向左子树添加节点
                this.left.add(node);
            }
        }else {
            // 添加的节点的值大于当前节点的值
            if(this.right == null){
                this.right = node;
            }else{
                // 递归的向右子树添加节点
                this.right.add(node);
            }
        }
    }

    /**
     * 中序变量
     */
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }



    /**
     * 查找要删除的节点
     * @param value 希望删除的节点的值
     * @return 如果找到返回要删除的节点，未找到返回null
     */
    public Node search(int value){
        if(value == this.value){
            return this;
        } else if(value < this.value){
            // 判断左子树是否为空
            if(this.left == null){
                return null;
            }
            // 如果查找的值小于当前节点的值，向左子树递归查找
            return this.left.search(value);
        } else{
            // 如果查找的值大于当前节点的值，向右子树递归查找
            if(this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }


    /**
     * 查找要删除的节点的父节点
     * @param value 希望删除的结点的值
     * @return 如果找到返回要删除节点的父节点，未找到返回null
     */
    public Node searchParent(int value){
        // 如果当前节点就是要删除节点的父节点。返回该节点
        if((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        } else {
            // 如果查找的值小于该节点的值，并且该节点的左子节点不为空，递归的向左查找
            if(value < this.value && this.left != null){
                return this.left.searchParent(value);
            }
            // 如果查找的值大于该节点的值，并且该节点的右子节点不为空，递归的向右查找
            else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            }else {
                // 没有父节点
                return null;
            }

        }
    }


}
