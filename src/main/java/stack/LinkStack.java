package stack;

/**
 * <p>标题: 栈</p>
 * <p>功能描述: 链表实现</p>
 *
 * <p>创建时间: 2019/3/31 16:17</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class LinkStack<E> implements IStack<E>{
    private StackNode<E> top;
    private int size;

    public LinkStack() {
        top=null;
        size=0;
    }

    @Override
    public E push(E item) {
        StackNode<E> newnode=new StackNode<E>(item);
        if(!empty()){
            newnode.setNext(top);
        }
        top=newnode;
        ++size;
        return item;
    }

    @Override
    public E pop() {
        E item=null;
        if(!empty()){
            item=top.getData();
            top=top.getNext();
            size--;
        }
        return item;
    }

    @Override
    public E peek() {
        E item=null;
        if(!empty()){
            item=top.getData();
        }
        return item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        if(top==null && size==0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }
    public class StackNode<E>{
        private E data;
        private StackNode<E> next;

        public StackNode() {
        }

        public StackNode(E data) {
            this.data = data;
        }

        public StackNode(E data, StackNode<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public StackNode<E> getNext() {
            return next;
        }

        public void setNext(StackNode<E> next) {
            this.next = next;
        }
    }

}


