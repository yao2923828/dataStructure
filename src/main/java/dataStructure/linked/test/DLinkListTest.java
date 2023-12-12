package dataStructure.linked.test;

import dataStructure.linked.DLinkList;
import dataStructure.linked.ILinarList;

/**
 * <p>标题: 线性表</p>
 * <p>功能描述: 双向链表实现</p>
 *
 * <p>创建时间: 2019/3/31 15:24</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class DLinkListTest<E> implements ILinarList<E> {
    private Node<E> head;
    private int size;

    public class Node<E>{
        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E data, Node<E> next, Node<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    @Override
    public boolean add(E item) {
        Node<E> newNode=new Node<>(item,null,null);
        if(isEmpty()){
            head=newNode;
            size++;
            return true;
        }
        //这里不能直接使用head,会修改头指针的引用
        Node<E> current=head;
        while (current!=null){
            current=current.next;
        }
        newNode.prev=current;
        current.next=newNode;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, E item) {
        //场景1 链表为空
        //场景2 插入头结点
        //场景3 插入尾结点
        //如何拿到前一个节点的以及当前节点。
        if(index<0||index>size){
            return false;
        }
        Node<E> newNode=new Node<>(item,null ,null );
        if(isEmpty()){
            head=newNode;
            size++;
            return true;
        }

        if(index==0){
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
            size++;
            return true;
        }

        if(index==size){
            Node<E> current=head;
            while (current!=null){
                current=current.next;
            }
            current.next=newNode;
            newNode.prev=current;
            size++;
            return true;
        }

        Node<E> current=head;
        Node<E> previous=null;
        for(int i=0;i<index;i++){
            previous=current;
            current=current.next;
        }
        newNode.next=current.next;
        newNode.prev=previous;
        previous.next=newNode;
        current.prev=newNode;
        size++;
        return false;
    }

    public static void main(String[] args) {
        DLinkList test=new DLinkList();
        test.add(1);
        test.add(0,2 );
    }

    @Override
    public E romove(int index) {

        //参数校验
        if(index<0||index>size){
            throw new IllegalArgumentException("参数不合法");
        }

        //删除节点
        Node<E> current=head;
        Node<E> previous=null;
        for (int i=0;i<index;i++){
            previous=current;
            current=current.next;
        }
        previous.next=current.next;
        current.next.prev=previous;

        current.prev=null;
        current.next=null;
        size--;

        return null;
    }

    @Override
    public int indexof(E item) {
        if(size==0){
            return -1;
        }
        Node<E> current=head;
        int index=0;
        do {
            //判断元素相等，一定能使用==吗，这个是需要思考的
            if(current.data==item){
                return index;
            }
        }while (current.next!=null);
        return -1;
    }

    @Override
    public E get(int index) {

        Node<E> current=head;
        for (int i=0;i<index;i++){
            current=current.next;
        }
        return current.data;
    }

    @Override
    public E set(int index, E item) {
        Node<E> current=head;
        for (int i=0;i<index;i++){
            current=current.next;
        }
        current.data=item;
        return item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

}
