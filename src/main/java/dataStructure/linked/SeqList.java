package dataStructure.linked;

import java.lang.reflect.Array;

/**
 * <p>标题: 线性表</p>
 * <p>功能描述: 数据实现</p>
 *
 * <p>创建时间: 2019/3/30 16:51</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class SeqList<E> implements ILinarList<E> {
    private int maxsize;
    private E[] data;
    private int size;

    public SeqList(Class<E> type,int maxsize) {
        this.maxsize = maxsize;
        data= (E[]) Array.newInstance(type, maxsize);
        size=0;
    }

    @Override
    public boolean add(E item) {
        if(!isFull()){
            data[size++]=item;
            return true;
        }
        return false;
    }



    @Override
    public boolean add(int index, E item) {
        rangeCheck(index);
        if(!isFull()){
            for (int j=size-1;j>=index;j--){
                data[j+1]=data[j];
            }
            data[index]=item;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public E romove(int index) {
        rangeCheck(index);
        if(!isEmpty()){
            E oldValue=data[index];
            for (int j=index;j<size-1;j++){
                data[j]=data[j+1];
            }
            data[--size]=null;
            return oldValue;
        }
        return null;
    }



    @Override
    public int indexof(E item) {
        if(item==null){
            for (int i=0;i<size;i++){
                if(data[i]==null){
                    return i;
                }
            }
        }else{
            for (int i=0;i<size;i++){
                if(item.equals(data[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return data[index];
    }

    @Override
    public E set(int index, E item) {
        rangeCheck(index);
        E oldValue=data[index];
        data[index]=item;
        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i=0;i<size;i++){
            data[i]=null;
        }
        size=0;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==maxsize;
    }
    private void rangeCheck(int index) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
    }
}
