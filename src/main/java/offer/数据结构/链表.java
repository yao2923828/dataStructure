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

}
