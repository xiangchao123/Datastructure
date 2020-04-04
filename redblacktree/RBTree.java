package redblacktree;

/**
 * 1.创建RBTree，定义颜色
 * 2.创建RBNode
 * 3.辅助方法定义：parentOf(node),isRed(node),isRed(node),setRed(node),setBlack(node),inOrderPrint()
 * 4.左旋方法定义:leftRotate(node)
 * 5.右旋方法定义:rightRotate(node)
 * 6.公开插入接口方法定义:insert(K key,V value)
 * 7.内部插入接口方法定义:insert(RBNode node)
 * 8.修正插入导致红黑树失衡的方法定义:insertFixUp(RBNode node)
 * 9.测试红黑树正确性
 * Created by xiangchao on 2020/4/3.
 */
public class RBTree<K extends Comparable<K>,V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private RBNode root;

    /**
     *
     * @author chosen1
     * @date  获取当前节点的父节点
     * @param node
     * @return 
    */
    private RBNode parentOf(RBNode node){
        if(node!=null){
            return node.parent;
        }
        return null;
    }
    /**
     * @author chosen1
     * @date 节点是否为红色
     * @param
     * @return
    */
    private boolean isRed(RBNode node){
        if(node!=null){
            return node.color==RED;
        }
        return false;
    }
    /**
     * @author chosen1
     * 节点是否为黑色
    */
    private boolean isBlack(RBNode node){
        if(node!=null){
            return node.color==BLACK;
        }
        return false;
    }
    /**
     * @author chosen1
     * 设置节点为红色
    */
    private void setRed(RBNode node){
        if(node!=null){
            node.color = RED;
        }
    }
    /**
     * @author chosen1
     * 设置节点为红色
     */
    private void setBlack(RBNode node){
        if(node!=null){
            node.color = BLACK;
        }
    }

    /**
     * @author chosen1
     * 中序打印二叉树
    */
    public void inOrderPrint(){
        inOrderPrint(this.root);
    }
    private void inOrderPrint(RBNode node){
        if(node!=null){
            inOrderPrint(node.left);
            System.out.println(node.key+"color:"+node.value);
            inOrderPrint(node.right);
        }
    }

    /**
     * @author chosen1
     * 公开的插入方法
    */
    private void insert(K key,V value){
        RBNode node  = new RBNode();
        node.setKey(key);
        node.setValue(value);
        //新节点一定是红色
        node.setColor(RED);
        insert(node);
    }
    private void insert(RBNode node){
        //第一步：查找当前node的父节点
        RBNode parent = null;
        RBNode x = this.root;
        while (x!=null){
            parent = x;
            int cmp = node.key.compareTo(x.key);
            if(cmp>0){
                x=x.right;
            }
            else if(cmp==0){
                x.setValue(node.getValue());
                return;
            }else {
                x=x.left;
            }
        }
        node.parent=parent;
        //判断node与parent谁大
        if(parent!=null) {
            int cmp = node.key.compareTo(parent.key);
            if(cmp>0){
                parent.right=node;
            }else {
                parent.left=node;
            }
        }
        else {
            this.root=node;
        }
        //需要调用修复红黑树平衡方法
        insertFixUp(node);
    }

    /**
     * @author chosen1
     * 插入后修复红黑树平衡方法
     *    |---情景1.红黑树为空树，将根节点染色为黑色
     *    |---情景2.插入节点的key已经存在，不需要处理
     *    |---情景3.插入节点的父节点为黑色，不需要处理
     *    情景4 需要处理
     *    |---情景4：插入节点的父节点为红色
     *        |---情景4.1：叔叔节点存在，并且为红色（父-叔 双红），将父-叔染为黑色，爷爷染为红色，并以爷爷节点为当前节点
     *                      进行下一轮处理
     *        |---情景4.2：叔叔节点不存在，或者为黑色，父节点为爷爷节点的左子树
     *            |---情景4.2.1:插入节点为父节点的左子节点（LL情况），将父染为黑色，爷爷染为红色，然后以爷爷节点右旋，ok
     *            |---情景4.2.2：插入节点为父节点的右子节点（LR情况），以父节点进行一次左旋，得到LL双红的情景（4.2.1），
     *                          然后指定父节点为当前节点，进行下一轮处理。
     *        |---情景4,3：叔叔节点不存在，或者为黑色，父节点为爷爷节点的右子树
     *            |---情景4.3.1:插入节点为父节点的右子节点（RR情况），将父染为黑色，爷爷染为红色，以爷爷节点左旋，ok
     *            |---情景4.3.2：插入节点为父节点的左子节点（RL情况），以父节点进行一次右旋，得到RR双红情景（4.3.1），
     *                          然后指定父节点为当前节点，进行下一轮处理。
    */
    private void insertFixUp(RBNode node){
        this.root.setColor(BLACK);
        RBNode parent = parentOf(node);
        RBNode gparent = parentOf(parent);
        //情景4：插入节点的父节点为红色
        if(parent!=null&&isRed(parent)){
            //如果父节点是红色，那么一定存在爷爷节点
            RBNode uncle = null;
            if(parent==gparent.left){//父节点为爷爷节点的左子树
                uncle=gparent.right;
                //情景4.1：叔叔节点存在，并且为红色（父-叔 双红）
                if(uncle!=null&&isRed(uncle)){
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    insertFixUp(gparent);
                    return;
                }
                //情景4.2：叔叔节点不存在，或者为黑色
                if(uncle==null||isBlack(uncle)){
                    //情景4.2.1:插入节点为父节点的左子节点（LL情况），将父染为黑色，爷爷染为红色，然后以爷爷节点右旋，ok
                    if(node==parent.left) {
                        setBlack(parent);
                        setRed(gparent);
                        rightRotate(gparent);
                        return;
                    }
                    //情景4.2.2：插入节点为父节点的右子节点（LR情况）
                    if(node==parent.right){
                        leftRotate(parent);
                        insertFixUp(parent);
                        return;
                    }
                }
            }else {//父节点为爷爷节点的右子树
                uncle = gparent.left;
                //情景4.1：叔叔节点存在，并且为红色（父-叔 双红）
                if(uncle!=null&&isRed(uncle)){
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    insertFixUp(gparent);
                    return;
                }

                //情景4,3：叔叔节点不存在，或者为黑色，父节点为爷爷节点的右子树
                if(uncle==null||isBlack(uncle)){
                    //情景4.3.1:插入节点为父节点的右子节点（RR情况），将父染为黑色，爷爷染为红色，以爷爷节点左旋，ok
                    if(node==parent.right){
                        setBlack(parent);
                        setRed(gparent);
                        leftRotate(gparent);
                        return;
                    }
                    //情景4.3.2：插入节点为父节点的左子节点（RL情况），以父节点进行一次右旋，得到RR双红情景（4.3.1），
                    if(node==parent.left){
                        rightRotate(parent);
                        insertFixUp(parent);
                        return;
                    }
                }
            }
        }
    }



    /**
     * @author chosen1
     * 左旋示意图：对节点x进行左旋
     *     p                       p
     *    /                       /
     *   x                       y
     *  / \                     / \
     * lx  y      ----->       x  ry
     *    / \                 / \
     *   ly ry               lx ly
     * 左旋做了三件事：
     * 1. 将x的右子节点指向y的左子节点（ly) ，并将y的左子节点的父节点更新为x
     * 2. 当x的父节点（非空时），更新y的父节点为x的父节点，并将x的父节点指定子树指定为y
     * 3. 将x的父节点更新为y，将y的左子节点更新为x
    */
    private void leftRotate(RBNode x){
        RBNode y = x.right;
        //将x的右子节点指向y的左子节点（ly)
        x.right = y.left;
        if(y.left!=null){
            y.left.parent=x;
        }
        //当x的父节点（非空时），更新y的父节点为x的父节点，并将x的父节点指定子树指定为y
        if(x.parent!=null){
            y.parent = x.parent;
            if(x==x.parent.left){
                x.parent.left =y;
            }else {
                x.parent.right=y;
            }
        }else {
            this.root=y;
            this.root.parent=null;
        }
        //将x的父节点更新为y，将y的左子节点更新为x
        x.parent = y;
        y.left=x;
    }

    /**
     * @author chosen1
     *右旋示意图：对节点y进行右旋
     *        p                   p
     *       /                   /
     *      y                   x
     *     / \                 / \
     *    x  ry   ----->      lx  y
     *   / \                     / \
     * lx  rx                   rx ry
     * 右旋做了三件事：
     *  1. 将y的左子节点指向x的右子节点 ，并且更新x的右子节点的父节点为y
     * 2. 当y的父节点（非空时），更新x的父节点为y的父节点，并将y的父节点指定子树指定为x
     * 3. 将y的父节点更新为x，将x的右子节点更新为y
    */
    private void rightRotate(RBNode y){
        RBNode x = y.left;
        //将y的左子节点指向x的右子节点 ，并且更新x的右子节点的父节点为y
        y.left = x.right;
        if(x.left!=null){
            x.left.parent=y;
        }
        //当y的父节点（非空时），更新x的父节点为y的父节点，并将y的父节点指定子树指定为x
        if(y.parent!=null){
            x.parent = y.parent;
            if(y==y.parent.left){
                y.parent.left=x;
            }else {
                y.parent.right=x;
            }
        }else {
            this.root=x;
            this.root.parent=null;
        }
        //将y的父节点更新为x，将x的右子节点更新为y
        y.parent=x;
        x.right=y;
    }


    static class RBNode<K extends Comparable<K>,V>{
        private RBNode parent;
        private RBNode left;
        private RBNode right;
        private boolean color;
        private K key;
        private V value;

        public RBNode() {
        }

        public RBNode(RBNode parent, RBNode left, RBNode right, boolean color, K key, V value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }

        public RBNode getParent() {
            return parent;
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }

        public RBNode getLeft() {
            return left;
        }

        public void setLeft(RBNode left) {
            this.left = left;
        }

        public RBNode getRight() {
            return right;
        }

        public void setRight(RBNode right) {
            this.right = right;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
