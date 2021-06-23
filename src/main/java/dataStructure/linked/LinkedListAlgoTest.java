package dataStructure.linked;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 *
 * Author: Zheng
 */
public class LinkedListAlgoTest {

  // 单链表反转
  public static Node reverse(Node head) {
    Node previousNode=null;
    Node currentNode=head;
    Node headNode=null;

    while (currentNode!=null){
      if(currentNode!=null){
        head=currentNode;
      }
      Node nextNode=currentNode.next;

      currentNode.next=previousNode;

      previousNode=currentNode;
      currentNode=nextNode;
    }
    return currentNode;
  }

  // 检测环
  public static boolean checkCircle(Node list) {
    if(list==null){
      return false;
    }
    Node fast=list.next;
    Node slow=list;
    while (fast!=null&&fast.next!=null){
      //让快的先跑起来
      fast=fast.next.next;
      slow=slow.next;
      if(fast==slow){
        return true;
      }
    }

    return false;
  }

  // 有序链表合并,这里需要分两种情况，是否允许使用额外的空间。默认应该是不允许的
  public static Node mergeSortedLists(Node la, Node lb) {


    return null;
  }

  // 删除倒数第K个结点
  public static Node deleteLastKth(Node list, int k) {
    return null;
  }

  // 求中间结点
  public static Node findMiddleNode(Node list) {
    return null;
  }

  public static void printAll(Node list) {
    Node p = list;
    while (p != null) {
      System.out.print(p.data + " ");
      p = p.next;
    }
    System.out.println();
  }

  public static Node createNode(int value) {
    return new Node(value, null);
  }

  public static class Node {
    private int data;
    private Node next;

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }

    public int getData() {
      return data;
    }
  }

}
