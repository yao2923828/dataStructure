package queue;

import java.lang.reflect.Array;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2019/3/31 16:32</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class SeqQueue<E> implements IQueue<E>{
    private int maxsize;
    private E [] data;
    private int front;
    private int rear;

    public SeqQueue(Class<E> type,int size) {
        data= (E[]) Array.newInstance(type, size);
        maxsize=size;
        front=rear-1;
    }

    @Override
    public boolean enqueue(E item) {
        if(!isFull()){
            rear=(rear+1)%maxsize;
            data[rear]=item;
            return true;
        }
        return false;
    }

    @Override
    public E dequeue() {
        if(!isEmpty()){
            front=(front+1)%maxsize;
            return data[front];
        }
        return null;
    }

    @Override
    public E peek() {
        if(!isEmpty()){
            return data[(front+1)%maxsize];
        }
        return null;
    }

    @Override
    public int size() {
        return (rear-front+maxsize)%maxsize;
    }

    @Override
    public boolean isEmpty() {
        if(front==rear){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if((front==-1&&rear==maxsize+1)|| (rear+1)%maxsize==front){
            return true;
        }
        return false;
    }
}
