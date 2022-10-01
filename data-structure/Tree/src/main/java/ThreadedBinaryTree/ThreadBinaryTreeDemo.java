package ThreadedBinaryTree;

/**
 * 中序遍历线索化二叉树
 * @author Qiu
 * @data 2022/9/26 0026   9:26
 */
public class ThreadBinaryTreeDemo {

    public static void main(String[] args) {
        // 测试中序线索二叉树
        HeroNode root = new HeroNode(1, "a");
        HeroNode node2 = new HeroNode(3, "b");
        HeroNode node3 = new HeroNode(6, "c");
        HeroNode node4 = new HeroNode(8, "d");
        HeroNode node5 = new HeroNode(10, "e");
        HeroNode node6 = new HeroNode(14, "f");
        // 手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        // 测试线索化
        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        tree.setRoot(root);
        tree.threadedNode();
        // 测试10号节点的前驱节点
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10号节点的前驱节点是 = " + leftNode);
        System.out.println("10号节点的前驱节点是 = " + rightNode);
        // tree.infixOrder();
        System.out.println("使用线索化的方式遍历线索化二叉树");
        tree.threadedList();


    }
    
    
    
}


// 创建节点
/**
 * 创建节点
 */
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    /**
     * leftType = 0 表示指向左子树， leftType = 1 表示指向前驱节点
     * rightType = 0 表示指向右子树， rightType = 1 表示指向后继节点
     */
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


    /**
     * 前序遍历
     */
    public void preOrder() {
        // 输出父节点
        System.out.println(this);
        // 向左子树递归前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        // 向右子树递归前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }


    /**
     * 中序遍历
     */
    public void infixOrder() {
        // 向左子树递归中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        // 输出父节点
        System.out.println(this);
        // 向右子树递归中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        // 向左子树递归后序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        // 向右子树递归后序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        // 输出父节点
        System.out.println(this);
    }


    /**
     * 前序遍历查找
     *
     * @param no 编号
     * @return 返回编号，没有则返回null
     */
    public HeroNode preOrderSearch(int no) {
        // 比较当前节点
        if (this.no == no) {
            return this;
        }
        // 判断左子树是否为空，不为空递归查找
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        // 左子树找到节点,返回节点
        if (resNode != null) {
            return resNode;
        }
        // 左子树未找到节点，向右子树递归遍历
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }


    /**
     * 中序遍历查找
     *
     * @param no 编号
     * @return 返回编号，没有则返回null
     */
    public HeroNode infixOrderSearch(int no) {
        // 判断当前节点的左节点是否为空，不为空，递归中序查找
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        // 未找到节点，与当前节点相比较，如果是则返回当前节点
        if (this.no == no) {
            return this;
        }
        // 否则继续向右递归查找
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;

    }


    /**
     * 后序遍历查找
     *
     * @param no 编号
     * @return 返回编号，没有则返回null
     */
    public HeroNode postOrderSearch(int no) {
        // 判断当前节点的左子树是否为空，不为空，递归后序查找
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        // 判断当前节点的右子树是否为空，不为空，递归后序查找
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        // 左右子树未找到节点，与当前节点相比较，如果是则返回当前节点
        if (this.no == no) {
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




/**
 * 定义ThreadedBinaryTree 实现二叉树的线索化功能
 */
class ThreadedBinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root){
        this.root = root;
    }


    /**
     * 为了实现线索化，需要先创建要指向当前节点的前驱节点的指针,在递归进行线索化时pre总是保存前一个节点
     */
    private HeroNode pre = null;

    // 重载threadedNode方法
    public void threadedNode(){
        this.threadedNode(root);
    }



    /**
     * 编写对二叉树进行中序线索化的方法
     * @param node 当前需要线索化的节点
     */
    public void threadedNode(HeroNode node){

        // 如果node == null 则不能线索化
        if(node == null){
            return;
        }
        /**
         * 1. 线索化左子树
         * 2. 线索化当前节点
         * 3. 线索化右子树
         */
        // 1. 线索化左子树
        threadedNode(node.getLeft());
        // 2. 线索化当前节点


        //先处理当前节点的前驱节点
        if(node.getLeft() == null){
            // 当前节点的左指针指向前驱节点
            node.setLeft(pre);
            // 修改当前节点的左指针的类型,指向前驱节点
            node.setLeftType(1);
        }
        // 处理后继节点
        if(pre != null && pre.getRight() == null){
            pre.setRight(node);
            // 修改当前节点的右指针的类型,指向后继节点
            pre.setRightType(1);
        }
        // 每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;
        // 3. 线索化右子树
        threadedNode(node.getRight());
    }


    /**
     * 遍历线索化二叉树
     */
    public void threadedList(){
        // 定义变量，存储当前遍历的节点
        HeroNode node = root;
        // 非空
        while(node != null){
            // 循环找到leftType = 1 的节点，第一个为8
            // 随着遍历而变化
            while(node.getLeftType() == 0){
                node = node.getLeft();
            }
            //打印当前节点
            System.out.println(node);
            //如果当前节点的右指针指向后继节点，就一直输出
            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            // 替换遍历的节点
            node = node.getRight();
        }



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