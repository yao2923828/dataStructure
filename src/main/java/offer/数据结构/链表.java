package offer.数据结构;

import java.util.ArrayList;
import java.util.Stack;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2021/7/3 7:58</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class 链表 {
    class ListNode {
        public int val;
        public ListNode next=null;

        ListNode(int val){
            this.val=val;
        }
    }

    /**
     * 从尾到头打印链表
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> ret= new ArrayList<>();
        if(listNode!=null){
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode){
        Stack<Integer> stack=new Stack<>();
        while (listNode!=null){
            stack.add(listNode.val);
            listNode=listNode.next;
        }

        ArrayList ret=new ArrayList();
        while (!stack.isEmpty()){
            ret.add(stack.pop());
        }
        return ret;
    }

    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode){
        //头插法构建逆序表
        ListNode head=new ListNode(-1);
        while (listNode!=null){
            ListNode memo=listNode.next;
            listNode.next=head.next;
            head.next=listNode;
            listNode=memo;
        }

        //构建Arraylist
        ArrayList ret=new ArrayList();
        head=head.next;
        while (head!=null){
            ret.add(head.val);
            head=head.next;
        }
        return ret;
    }

    /**
     * 删除链表中重复的结点
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val)
                next = next.next;
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
    /**
     * 链表中倒数第 K 个结点
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode P1 = head;
        while (P1 != null && k-- > 0)
            P1 = P1.next;
        if (k > 0)
            return null;
        ListNode P2 = head;
        while (P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        return P2;
    }
    /**
     * 链表中环的入口结点
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode slow = pHead, fast = pHead;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    /**
     * 反转链表
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = ReverseList(next);
        next.next = head;
        return newHead;
    }

    public ListNode ReverseList2(ListNode head) {
        ListNode newList = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }

    /**
     * 合并两个排序的链表
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    /**
     * 复杂链表的复制
     */
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        // 插入新节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // 建立 random 链接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null)
                clone.random = cur.random.next;
            cur = clone.next;
        }
        // 拆分
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }

    /**
     * 两个链表的第一个公共结点
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }
}
