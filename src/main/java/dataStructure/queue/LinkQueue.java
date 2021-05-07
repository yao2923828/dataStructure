package dataStructure.queue;

/**
 * <p>标题: 队列</p>
 * <p>功能描述: 链表实现</p>
 *
 * <p>创建时间: 2019/3/31 17:00</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class LinkQueue<E> implements IQueue<E>{
    private QueueNode<E> front;
    private QueueNode<E> rear;
    private int maxsize;
    private int size;

    public LinkQueue() {
        front=rear=null;
        size=0;
        maxsize=0;
    }
    public LinkQueue(int maxsize) {
        this.maxsize=maxsize;
    }

    @Override
    public boolean enqueue(E item) {
        QueueNode<E> newnode=new QueueNode<E>(item);
        if(!isFull()){
            if(isEmpty()){
               front=newnode;
               rear=newnode;
            }else{
                rear.setNext(newnode);
                rear=newnode;
            }
            ++size;
            return true;
        }
        return false;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            return null;
        }
        QueueNode<E> node=front;
        front=front.getNext();
        if(front==null){
            rear=null;
        }
        --size;
        return node.getData();
    }

    @Override
    public E peek() {
        if(!isEmpty()){
            return front.getData();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(front==rear && size==0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if(maxsize!=0&& size==maxsize){
            return true;
        }
        return false;
    }
    class QueueNode<E>{
        private E data;
        private QueueNode<E> next;

        public QueueNode() {
        }

        public QueueNode(E data) {
            this.data = data;
        }

        public QueueNode(E data, QueueNode<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public QueueNode<E> getNext() {
            return next;
        }

        public void setNext(QueueNode<E> next) {
            this.next = next;
        }
    }
}
