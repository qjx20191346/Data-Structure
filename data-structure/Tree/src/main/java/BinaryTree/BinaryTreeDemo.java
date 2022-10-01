package BinaryTree;

/**
 * 树的前序中序后序遍历
 * @author Qiu
 * @data 2022/9/24 0024   17:05
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {

        // 初始化二叉树
        BinaryTree binaryTree = new BinaryTree();
        // 创建节点
        HeroNode root = new HeroNode(1,"a");
        HeroNode node2 = new HeroNode(2,"b");
        HeroNode node3 = new HeroNode(3,"c");
        HeroNode node4 = new HeroNode(4,"d");
        HeroNode node5 = new HeroNode(5,"e");
        // 手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);

/*        // 前序遍历
        System.out.println("前序遍历");
        binaryTree.preOrder();

        // 中序遍历
        System.out.println("中序遍历");
        binaryTree.infixOrder();

        // 后序遍历
        System.out.println("后序遍历");
        binaryTree.postOrder();


        // 前序遍历
        System.out.println("前序遍历查找");
        BinaryTree.HeroNode resNode = binaryTree.preOrderSearch(5);
        if(resNode != null){
            System.out.println("已经找到节点，信息为 no = " + resNode.getNo() + " name = " + resNode.getName());
        }else {
            System.out.println("未找到该节点" );
        }


        // 中序遍历
        System.out.println("中序遍历查找");
        BinaryTree.HeroNode resNode2 = binaryTree.infixOrderSearch(5);
        if(resNode2 != null){
            System.out.println("已经找到节点，信息为 no = " + resNode2.getNo() + " name = " + resNode2.getName());
        }else {
            System.out.println("未找到该节点" );
        }


        // 后序遍历
        System.out.println("后序遍历查找");
        BinaryTree.HeroNode resNode3 = binaryTree.postOrderSearch(5);
        if(resNode3 != null){
            System.out.println("已经找到节点，信息为 no = " + resNode3.getNo() + " name = " + resNode3.getName());
        }else {
            System.out.println("未找到该节点" );
        }*/

        // 测试删除节点
        System.out.println("删除前，前序遍历");
        binaryTree.preOrder();

        binaryTree.delNode(3);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder();
    }


}


/**
 * 定义二叉树
 */
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root){
        this.root = root;
    }

    // 删除节点
    public void delNode(int no){
        if(root != null){
            // 判断root是否是要删除的节点
            if(root.getNo() == no){
                root = null;
            }else {
                // 递归删除
                root.delNode(no);
            }
        }else {
            System.out.println("空树无法删除");
        }
    }



    // 前序遍历
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    // 中序遍历
    public void infixOrder(){
        if(this.root != null) {
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    // 后序遍历
    public void postOrder(){
        if(this.root != null) {
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 前序遍历
    public HeroNode preOrderSearch(int no){
        if(root != null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }
    }

    // 中序遍历
    public HeroNode infixOrderSearch(int no){
        if(root != null){
            return root.infixOrderSearch(no);
        }else{
            return null;
        }
    }

    // 后序遍历
    public HeroNode postOrderSearch(int no){
        if(root != null){
            return root.postOrderSearch(no);
        }else{
            return null;
        }
    }

}







/**
 * 创建节点
 */
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;


    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTree.HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


    /**
     * 前序遍历
     */
    public void preOrder(){
        // 输出父节点
        System.out.println(this);
        // 向左子树递归前序遍历
        if(this.left != null){
            this.left.preOrder();
        }
        // 向右子树递归前序遍历
        if(this.right != null){
            this.right.preOrder();
        }
    }


    /**
     * 中序遍历
     */
    public void infixOrder(){
        // 向左子树递归中序遍历
        if(this.left != null){
            this.left.infixOrder();
        }
        // 输出父节点
        System.out.println(this);
        // 向右子树递归中序遍历
        if(this.right != null){
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        // 向左子树递归后序遍历
        if(this.left != null){
            this.left.postOrder();
        }
        // 向右子树递归后序遍历
        if(this.right != null){
            this.right.postOrder();
        }
        // 输出父节点
        System.out.println(this);
    }


    /**
     * 前序遍历查找
     * @param no 编号
     * @return 返回编号，没有则返回null
     */
    public HeroNode preOrderSearch(int no){
        // 比较当前节点
        if(this.no == no){
            return this;
        }
        // 判断左子树是否为空，不为空递归查找
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        // 左子树找到节点,返回节点
        if (resNode != null){
            return resNode;
        }
        // 左子树未找到节点，向右子树递归遍历
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }


    /**
     * 中序遍历查找
     * @param no 编号
     * @return 返回编号，没有则返回null

     */
    public HeroNode infixOrderSearch(int no){
        // 判断当前节点的左节点是否为空，不为空，递归中序查找
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        // 未找到节点，与当前节点相比较，如果是则返回当前节点
        if(this.no == no){
            return this;
        }
        // 否则继续向右递归查找
        if(this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;

    }


    /**
     * 后序遍历查找
     * @param no 编号
     * @return 返回编号，没有则返回null
     */
    public HeroNode postOrderSearch(int no){
        // 判断当前节点的左子树是否为空，不为空，递归后序查找
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        // 判断当前节点的右子树是否为空，不为空，递归后序查找
        if(this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        // 左右子树未找到节点，与当前节点相比较，如果是则返回当前节点
        if(this.no == no){
            return this;
        }
        return resNode;
    }


    /**
     * 递归删除节点
     * 1. 如果是非叶子节点直接删除子树
     * 2. 如果是叶子节点则删除该节点
     * 思路
     * 1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
     * 2.如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将 this.left = null; 并且就返回(结束递归删除)
     * 3.如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将 this.right= null ;并且就返回(结束递归删除)
     * 4.如果第 2 和第 3 步没有删除结点，那么我们就需要向左子树进行递归删除
     * 5.如果第 4 步也没有删除结点，则应当向右子树进行递归删除.
     * @param no
     */
    public void delNode(int no){
        // 2.如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将 this.left = null; 并且就返回(结束递归删除)
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        // 3.如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将 this.right= null ;并且就返回(结束递归删除)
        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        // 4.如果第 2 和第 3 步没有删除结点，那么我们就需要向左子树进行递归删除
        if(this.left != null){
            this.left.delNode(no);
        }
        // 5.如果第 4 步也没有删除结点，则应当向右子树进行递归删除.
        if(this.right != null){
            this.right.delNode(no);
        }

    }



}
