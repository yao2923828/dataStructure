package linked;

/**
 * <p>标题: 线性表</p>
 * <p>功能描述: 双向链表实现</p>
 *
 * <p>创建时间: 2019/3/31 15:24</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class DLinkList<E> implements ILinarList<E> {
    private  Node<E> start;
    int size;
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
        Node(E element,Node<E> prev,Node<E> next){
            this.item=element;
            this.next=next;
            this.prev=prev;
        }
    }
    public DLinkList(){
        start=null;
    }
    @Override
    public boolean add(E item) {
        Node<E> newnode=new Node<>(item, null, null);
        if(isEmpty()){
            start=newnode;
            size++;
            return true;
        }
        Node<E> current=start;
        while (current.next!=null){
            current=current.next;
        }
        current.next=newnode;
        newnode.prev=current;
        newnode.next=null;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, E item) {
        Node<E> current;
        Node<E> previous;
        rangeCheck(index);
        Node<E> newnode=new Node<E>(item,null,null);
        if(index==0){
            newnode.next=start;
            start=newnode;
            size++;
            return true;
        }
        current=start;
        previous=null;
        int j=0;
        while (current!=null&&j<index){
            previous=current;
            current=current.next;
            j++;
        }
        if(j==index){
            newnode.next=current;
            newnode.prev=previous;
            if(current!=null){
                current.prev=newnode;
            }
            previous.next=newnode;
            size++;
        }
        return true;
    }

    @Override
    public E romove(int index) {
        E oldValue=null;
        rangeCheck(index);
        Node<E> current=start;
        if(index==0){
            oldValue=current.item;
            start=current.next;
            size--;
        }else {
            Node<E> previous=null;
            int j=1;
            while (current.next!=null && j<=index){
                previous=current;
                current=current.next;
                j++;
            }
            previous.next=current.next;
            if(current.next!=null)
                current.next.prev=previous;
            oldValue=current.item;
            current=null;
            previous=null;
            size--;
        }
        return oldValue;
    }

    @Override
    public int indexof(E item) {
        int index=0;
        if(item==null){
            for(Node<E> current=start;current!=null;current=current.next){
                if(current.item==null){
                    return index;
                }
                index++;
            }
        }else{
            for(Node<E> current=start;current!=null;current=current.next){
                if(item.equals(current.item)){
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        E item=null;
        rangeCheck(index);
        Node<E> current=start;
        int j=0;
        while (current.next!=null&&j<index){
            current=current.next;
            j++;
        }
        if(j==index){
            item=current.item;
        }
        return item;
    }

    @Override
    public E set(int index, E item) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (Node<E> x=start;x!=null;){
            Node<E> next=x.next;
            x.item=null;
            x.next=null;
            x=next;
        }
        start=null;
        size=0;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    private void rangeCheck(int index) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
    }
}
