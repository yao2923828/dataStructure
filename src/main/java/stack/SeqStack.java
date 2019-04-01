package stack;

import java.lang.reflect.Array;

/**
 * <p>标题: 栈</p>
 * <p>功能描述: 数组实现</p>
 *
 * <p>创建时间: 2019/3/31 16:09</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class SeqStack<E> implements IStack<E>{
    private int maxsize;
    private E [] data;
    private int top;

    public SeqStack(Class<E> type,int size) {
        data= (E[]) Array.newInstance(type, size);
        maxsize=size;
        top=-1;
    }

    @Override
    public E push(E item) {
        if(!isFull()){
            data[++top]=item;
            return item;
        }
        return null;
    }

    @Override
    public E pop() {
        E item=null;
        if(!empty()){
            item=data[top];
        }
        return item;
    }

    @Override
    public E peek() {
        E item=null;
        if(!empty()){
            item=data[top];
        }
        return item;
    }

    @Override
    public int size() {
        return top+1;
    }

    @Override
    public boolean empty() {
        if(top==-1){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if(top==maxsize-1){
            return true;
        }
        return false;
    }
}
