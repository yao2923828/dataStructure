package offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <p>标题:剑指offer </p>
 * <p>功能描述:可参考：https://www.cyc2018.xyz </p>
 *
 * <p>创建时间: 2021/5/30 22:06</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class Main {

    /**
     *题目6：输出一个链表的头结点，从尾到头反过来打印出每个节点的值。
     */
    class ListNode{
        int data;
        ListNode next;
    }
    /**
     * 使用栈结构
     */
    void printListReversinglyIteratively(ListNode head){
        Stack nodes=new Stack();
        ListNode currentNode=head;
        while (currentNode.next!=null){
            nodes.push(currentNode);
            currentNode=currentNode.next;
        }
        while (!nodes.isEmpty()){
            System.out.print(nodes.pop());
        }
    }
    /**
     * 使用递归
     */
    void printListReversionglyRecursively(ListNode head){
        ListNode cureentNode=head;
        if(cureentNode==null){
            return;
        }
        if(cureentNode.next!=null){
            printListReversionglyRecursively(cureentNode.next);
        }
        System.out.print(cureentNode.data);
    }

    /**
     * 面试题7：输出某个二叉树的前序遍历和中序遍历结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中
     * 都不包含重复的数字。例如，输入前序遍历序列{1,2,4,7,3,5,6,8}中序遍历序列{4,7,2,1,5,3,8,6},则重建如图所示
     * 的二叉树并输出它的头文件。
     */
    class BinaryTreeNode{
        int value;
        BinaryTreeNode leftNode;
        BinaryTreeNode rightNode;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        //缓存中序遍历数组每个值对应的索引，空间换时间，不需要遍历去查询下标
        private Map<Integer,Integer> indexForInOrders=new HashMap<>();
        /**
         * 重建二叉树
         * @param inOrder 中序遍历序列
         * @param preOrder  前序遍历序列
         * @return 返回二叉树的根节点
         */
        BinaryTreeNode reConstructBinaryTree(int [] preOrder,int [] inOrder){
            for (int i=0;i<inOrder.length;i++)
                indexForInOrders.put(inOrder[i],i );
            return reConstructBinaryTree(preOrder, 0,preOrder.length-1 ,0 );
        }
        /**
         * 重建二叉树
         * @param pre 前序序列
         * @param preL  左边界
         * @param preR 有边界
         * @param inL  ？这个参数怎么理解，应该就是中序序列的左边界值
         * @return 重建的二叉树根节点
         */
        BinaryTreeNode reConstructBinaryTree(int [] pre,int preL,int preR,int inL){
            if(preL>preR){
                return null;
            }
            BinaryTreeNode root=new BinaryTreeNode(pre[preL]);
            int inIndex=indexForInOrders.get(root.value);
            int leftTreeSize=inIndex-inL;
            root.leftNode=reConstructBinaryTree(pre, preL+1,preL+leftTreeSize,inL);
            root.rightNode=reConstructBinaryTree(pre, preL+leftTreeSize, preR, inL+leftTreeSize+1);
            return root;

        }

        /**
         * 解法2，书上的解法，
         * 疑问：第二个数组要不要传递下去,如何分解成子问题求解
         * @param preOrder 前序遍历
         * @param inOrder  中序遍历
         */
        BinaryTreeNode construct(int [] preOrder,int [] inOrder){
            //边界值校验
            if(preOrder==null || inOrder==null){
                return null;
            }
            return constructCore(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
        }
        /**
         * @param preOrder
         * @param preLeft
         * @param preRight
         * @param inOrder
         * @param inLeft
         * @param inRight
         */
        BinaryTreeNode constructCore(int [] preOrder,int preLeft,int preRight,int [] inOrder,int inLeft,int inRight){

            //前序序列的第一个数字是根节点的值
            BinaryTreeNode root=new BinaryTreeNode(preOrder[preLeft]);
            //终止条件,只有一个元素
            if(preLeft==preRight && inLeft==inRight){
                return root;
            }
            //获取根节点在中序遍历中的下标值
            int rootIndex=0;
            for(int i=0;i<inOrder.length;i++){
                if(inOrder[i]==root.value){
                    rootIndex=i;
                    break;
                }
            }
            //构建左子树
            root.leftNode=constructCore(preOrder, preLeft+1,rootIndex-inLeft,inOrder ,inLeft , rootIndex-1);
            //构建右子树
            root.rightNode=constructCore(preOrder,preLeft+(rootIndex-preLeft+1) ,preRight , inOrder, rootIndex+1, inRight);
            return root;

        }

    }

    /**
     * 题目8：二叉树的下一个节点
     * 给定一颗二叉树和其中的一个节点，如何找出任意中序遍历序列下一个节点？树中的节点除了有两个分别指向左、右子节点的指针，
     * 还有一个指向父节点的指针
     */
    class BinaryTreeNode2{
        int value;
        BinaryTreeNode2 leftNode;
        BinaryTreeNode2 rightNode;
        BinaryTreeNode2 nextNode;

        /**
         * 返回指定节点的中序遍历的下一个节点
         * @param pNode 目标节点
         */
        public BinaryTreeNode2 getNext(BinaryTreeNode2 pNode){

            if(pNode==null){
                return null;
            }
            if(pNode.rightNode!=null){
                BinaryTreeNode2 node=pNode.rightNode;
                while (node.leftNode!=null){
                    node=node.leftNode;
                }
                return node;
            }else {
                if(pNode.nextNode!=null){
                    BinaryTreeNode2 node=pNode;
                    while (node.nextNode!=null){
                        BinaryTreeNode2 parentNode=node.nextNode;
                        if(parentNode.leftNode==pNode){
                            return parentNode;
                        }else {
                            node=node.nextNode;
                        }
                    }
                }

            }
            return null;

        }

    }

    /**
     * 面试题9：用两个栈实现一个队列。队列的声明如下，请实现他的两个函数appendTail和deleteHead,分别完成在队列尾部插入节点
     * 和在队列头部删除节点的功能
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void appendTail(int value){
        stack1.push(value);

    }

    public int deleteHead() throws Exception {

        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            throw new Exception("queue is empty");
        }
        return stack2.pop();
    }

    /**
     * 面试10 斐波那契数列
     * 题目1：求斐波那契数列的第N项。
     * 写好一个函数，输出N，求斐波那契数列的第N。斐波那契数列的定义如下：
     *      { 0 n=0
     * f(n)={ 1 n=1
     *      { f(n-1)+f(n-2) n>1
     */

    /**
     *  解法1--递归
     */
    public int fibonacci(int n){
        if(n==0)return 0;
        if(n==1)return 1;
        return fibonacci(n-1)+fibonacci(n-2);

    }

    /**
     * 解法2-非递归
     */
    public int fibonacci2(int n){
        if(n<0){
            return -1;
        }
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int fn=0;
        int f1=0,f2=1;
        for (int i=2;i<=n;i++){
            fn=f1+f2;
            f1=f2;
            f2=fn;
        }
        return fn;

    }

    /**
     * 题目二：青蛙跳台阶问题
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级台阶总共有多少种跳法
     */

    public int JumpFloor(int n) {
        if (n <= 2)
            return n;
        int pre2 = 1, pre1 = 2;
        int result = 0;
        for (int i = 2; i < n; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    /**
     * 面试题11：旋转数据的最小数字
     * 题目：把一个数组最开始的若干个元素搬到数据的末端。我们称之为数据组的旋转，输入一个递增排序的数组的一个旋转
     * 输出旋转数组的最小元素。例如，数组{3,4,5,1,2} 为{1,2,3,4,5}的一个旋转，该数组的最小元素为1.
     */
    







}
