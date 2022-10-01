/**
 *
 * @author Qiu
 * @data 2022/9/29 0029   10:47
 */
public class AvlTreeDemo {

    public static void main(String[] args) {
        // 左旋转测试
        // int[] array = {4, 3, 6, 5, 7, 8};
        // 右旋转测试
        int[] array = {10, 11, 7, 6, 8, 9};
        // 创建一个AvlTree对象
        AvlTree at = new AvlTree();
        // 添加节点
        for(int i = 0; i < array.length; i++){
            at.add(new Node(array[i]));
        }
        // 中序遍历
        System.out.println("中序遍历");
        at.infixOrder();
        // 没有进行平衡处理的树的高度
        System.out.println("开始平衡处理树");
        System.out.println("树的高度 " + at.getRoot().height()); // 3
        System.out.println("树的左子树高度 " + at.getRoot().leftHeight()); // 2
        System.out.println("树的右子树高度 " + at.getRoot().rightHeight()); // 2
        System.out.println("当前树的根节点 " + at.getRoot()); // 8
        System.out.println("当前树的根节点的左子节点 " + at.getRoot().left); // 7
        System.out.println("当前树的根节点的左子节点的左子节点 " + at.getRoot().left.left); // 6
    }
}


/**
 *  创建AvlTree
 */
class AvlTree{
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





class Node {
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
     *
     * @param node 添加的节点
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        // 判断节点值与当前指数的根节点的值的关系
        if (node.value < this.value) {
            // 当前节点的左子节点为空
            if (this.left == null) {
                this.left = node;
            } else {
                // 递归的向左子树添加节点
                this.left.add(node);
            }
        } else {
            // 添加的节点的值大于当前节点的值
            if (this.right == null) {
                this.right = node;
            } else {
                // 递归的向右子树添加节点
                this.right.add(node);
            }
        }

        // 当添加完一个节点后，如果:（右子树的高度 - 左子树的高度） > 1，左旋转
        if(rightHeight() - leftHeight() > 1){
            // 如果右子树的左子树的高度大于其右子树的高度
            if(right != null && right.leftHeight() > right.rightHeight()){
                // 先对当前节点的右子树进行右旋转
                right.rightRotate();
                // 再对当前节点进行左旋转
                leftRotate();
            }else {
                leftRotate();
            }
            return;
        }

        // 当添加完一个节点后，如果:（左子树的高度 - 右子树的高度） > 1，右旋转
        if(leftHeight() - rightHeight() > 1){
            // 如果左子树的右子树的高度大于其左子树的高度
            if(left != null && left.rightHeight() > left.leftHeight()){
                // 先对当前节点的左子树进行左旋转
                left.leftRotate();
                // 再对当前节点进行右旋转
                rightRotate();
            }else {
                rightRotate();
            }

        }

    }




    /**
     * 中序变量
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }


    /**
     * 查找要删除的节点
     *
     * @param value 希望删除的节点的值
     * @return 如果找到返回要删除的节点，未找到返回null
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            // 判断左子树是否为空
            if (this.left == null) {
                return null;
            }
            // 如果查找的值小于当前节点的值，向左子树递归查找
            return this.left.search(value);
        } else {
            // 如果查找的值大于当前节点的值，向右子树递归查找
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }


    /**
     * 查找要删除的节点的父节点
     *
     * @param value 希望删除的结点的值
     * @return 如果找到返回要删除节点的父节点，未找到返回null
     */
    public Node searchParent(int value) {
        // 如果当前节点就是要删除节点的父节点。返回该节点
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            // 如果查找的值小于该节点的值，并且该节点的左子节点不为空，递归的向左查找
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            }
            // 如果查找的值大于该节点的值，并且该节点的右子节点不为空，递归的向右查找
            else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                // 没有父节点
                return null;
            }

        }
    }


    /**
     * 返回以当前节点为根节点的树的高度
     * @return 以当前节点为根节点的树的高度
     */
    public int height(){
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }


    /**
     * 返回左子树树的高度
     * @return 左子树树的高度
     */
    public int leftHeight(){
       if(left == null){
           return 0;
       }
       return left.height();
    }


    /**
     * 返回右子树树的高度
     * @return 左子树树的高度
     */
    public int rightHeight(){
        if(right == null){
            return 0;
        }
        return right.height();
    }

    /**
     * 左旋转
     * 1. 创建新的节点，以当前根节点的值作为新节点
     * 2. 将新的节点的左子树设置成当前节点的左子树
     * 3. 把新的节点的右子树设置成当前节点的右子树的左子树
     * 4. 把当前节点的值替换成右子节点的值
     * 5. 把当前节点的右子树设置成右子树的右子树
     * 6. 把当前节点的左子树（左子节点）设置成新的节点
     */
    private void leftRotate(){
        // 1. 创建新的节点，以当前根节点的值作为新节点
        Node newNode = new Node(value);
        // 2. 将新的节点的左子树设置成当前节点的左子树
        newNode.left = left;
        // 3. 把新的节点的右子树设置成当前节点的右子树的左子树
        newNode.right = right.left;
        // 4. 把当前节点的值替换成右子节点的值
        value = right.value;
        // 5. 把当前节点的右子树设置成右子树的右子树
        right = right.right;
        // 6. 把当前节点的左子树（左子节点）设置成新的节点
        left = newNode;
    }

    /**
     * 右旋转
     * 1. 创建新的节点，以当前根节点的值作为新节点
     * 2. 将新的节点的右子树设置成当前节点的右子树
     * 3. 把新的节点的左子树设置成当前节点的左子树的右子树
     * 4. 把当前节点的值替换成左子节点的值
     * 5. 5. 把当前节点左子树值设置成左子树的左子树
     * 6. 把当前节点的右子树（右子节点）设置成新的节点
     */
    private void rightRotate(){
        // 1. 创建新的节点，以当前根节点的值作为新节点
        Node newNode = new Node(value);
        //2. 将新的节点的右子树设置成当前节点的右子树
        newNode.right = right;
        // 3. 把新的节点的左子树设置成当前节点的左子树的右子树
        newNode.left = left.right;
        //  4. 把当前节点的值替换成左子节点的值
        value = left.value;
        // 5. 把当前节点左子树值设置成左子树的左子树
        left = left.left;
        // 6. 把当前节点的右子树（右子节点）设置成新的节点
        right = newNode;
    }




}