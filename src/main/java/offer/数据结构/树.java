package offer.数据结构;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2021/8/23 6:30</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class 树 {

    public class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /**
     * 重建二叉树
     */
    // 缓存中序遍历数组每个值对应的索引
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
            indexForInOrders.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

    /**
     * 二叉树的下一个结点
     */
    public class TreeLinkNode {

        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null; // 指向父结点的指针

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode)
                    return parent;
                pNode = pNode.next;
            }
        }
        return null;
    }

    /**
     * 树的子结构
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return isSubtreeWithRoot(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
    }

    /**
     * 二叉树的镜像
     */
    public TreeNode Mirror(TreeNode root) {
        if (root == null)
            return root;
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }
    /**
     * 对称的二叉树
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        if (t1.val != t2.val)
            return false;
        return isSymmetrical(t1.left, t2.right) && isSymmetrical(t1.right, t2.left);
    }

    /**
     * 从上往下打印二叉树
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode t = queue.poll();
                if (t == null)
                    continue;
                ret.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return ret;
    }
    /**
     * 把二叉树打印成多行
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null)
                    continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (list.size() != 0)
                ret.add(list);
        }
        return ret;
    }
    /**
     *  按之字形顺序打印二叉树
     */
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null)
                    continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (reverse)
                Collections.reverse(list);
            reverse = !reverse;
            if (list.size() != 0)
                ret.add(list);
        }
        return ret;
    }
    /**
     * 二叉搜索树的后序遍历序列
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1)
            return true;
        int rootVal = sequence[last];
        int cutIndex = first;
        while (cutIndex < last && sequence[cutIndex] <= rootVal)
            cutIndex++;
        for (int i = cutIndex; i < last; i++)
            if (sequence[i] < rootVal)
                return false;
        return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex, last - 1);
    }
    /**
     * 二叉树中和为某一值的路径
     */
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null)
            return;
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(path));
        } else {
            backtracking(node.left, target, path);
            backtracking(node.right, target, path);
        }
        path.remove(path.size() - 1);
    }
    /**
     *  二叉搜索树与双向链表
     */
    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode root) {
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        node.left = pre;
        if (pre != null)
            pre.right = node;
        pre = node;
        if (head == null)
            head = node;
        inOrder(node.right);
    }
    /**
     * 序列化二叉树
     */
    private String deserializeStr;

    public String Serialize(TreeNode root) {
        if (root == null)
            return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    public TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    private TreeNode Deserialize() {
        if (deserializeStr.length() == 0)
            return null;
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        if (node.equals("#"))
            return null;
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }
    /**
     * 二叉查找树的第 K 个结点
     */
    private TreeNode ret2;
    private int cnt = 0;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return ret2;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null || cnt >= k)
            return;
        inOrder(root.left, k);
        cnt++;
        if (cnt == k)
            ret2 = root;
        inOrder(root.right, k);
    }
    /**
     * 二叉树的深度
     */
    public int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
    /**
     * 平衡二叉树
     */
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null || !isBalanced)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;
        return 1 + Math.max(left, right);
    }

    /**
     * 树中两个节点的最低公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
