package linked;

/**
 * <p>标题: 线性表</p>
 * <p>功能描述: 单链表</p>
 *
 * <p>创建时间: 2019/3/30 17:13</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class SLinkList<E> implements ILinarList<E> {
    private Node<E> start;
    int size;
    private static class Node<E>{
        E item;
        Node<E> next;
        Node(E element,Node<E> next){
            this.item=element;
            this.next=next;
        }
    }

    public SLinkList() {
        start=null;
    }

    @Override
    public boolean add(E item) {
        if(start==null){
            start=new Node<E>(item, null);
        }else{
            Node current=start;
            while(current.next!=null){
                current=current.next;
            }
            current.next=new Node(item, null);
            size++;
        }
        return true;
    }

    @Override
    public boolean add(int index, E item) {
        rangeCheck(index);
        Node current,previous;
        Node newNode=new Node(item,null);
        if(index==0){
            newNode.next=start;
            start=newNode;
            size++;
        }else{
            current=start;
            previous=null;
            int j=0;
            while (current!=null&&j<index){
                previous=current;
                current=current.next;
                j++;
            }
            if(j==index){
                previous.next=newNode;
                newNode.next=current;
                size++;
            }
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
        }else{
            Node<E> previous=null;
            int j=1;
            while (current.next!=null&&j<=index){
                previous=current;
                current=current.next;
                j++;
            }
            previous.next=current.next;
            oldValue=current.item;
            current=null;
            size--;
        }
        return oldValue;
    }

    @Override
    public int indexof(E item) {
        int index=0;
        if(item==null){
            for (Node<E> x=start;x!=null;x=x.next){
                if(x.item==null){
                    return index;
                }
                index++;
            }
        }else{
            for (Node<E> x=start;x!=null;x=x.next){
                if(item.equals(x.item)){
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
        for(Node<E> x=start;x!=null;){
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

    public void rangeCheck(int index){
        if(index<0|| index>size){
            throw new IllegalArgumentException("index非法");
        }
    }
}
