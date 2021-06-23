package dataStructure.array;

/**
 * 动态数组的实现
 */
public class GenericArrayTest<T> {

    private T data[];

    private int size;

    public GenericArrayTest(int capacity) {
        this.data=(T[])new Object[capacity];
        this.size=0;
    }

    public GenericArrayTest() {
        //需要默认一个初始容量
        this(10);
    }


    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 获取当前元素个数
    public int count() {
        return size;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return size==0;
    }

    // 修改 index 位置的元素
    public void set(int index, T e) {
        if(index<0||index>size)throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");;
        data[index]=e;
    }

    // 获取对应 index 位置的元素
    public T get(int index) {
        if(index<0||index > size)throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");;
        return data[index];
    }

    // 查看数组是否包含元素e
    public boolean contains(T e) {
        for (int i=0;i<size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // 获取对应元素的下标, 未找到，返回 -1
    public int find(int e) {

        for (int i=0;i<size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }


    // 在 index 位置，插入元素e, 时间复杂度 O(m+n)
    public void add(int index, T e) {
        if(index>0)return;
        //判断index不合理，应该判断实际大小
        if(size==data.length){
            //扩容
            T [] newData=(T[])new Object[2*data.length];
            for (int i=0;i<size;i++){
                newData[i]=data[i];
            }
            data=newData;
            newData=null;
        }
        for(int i=size;i>index;i--){
            data[i]=data[i-1];
        }
        data[index]=e;
        size++;
    }

    // 向数组头插入元素
    public void addFirst(T e) {
        this.add(0,e );
    }

    // 向数组尾插入元素
    public void addLast(T e) {
        this.add(size,e);
    }

    // 删除 index 位置的元素，并返回
    public T remove(int index) {
        if(index<0||index>size) throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.") ;

        T value=data[index];
        for(int i=index;i<size;i++){
            data[i]=data[i+1];
        }
        size--;
        //缩容的标准可以再优化下
        if(size<data.length/2){
            //缩容
            T [] data2=(T[])new Object[data.length>>1];
            for(int i=0;i<size;i++){
                data2[i]=data[i];
            }
            data=data2;
            data2=null;
        }
        return value;

    }

    // 删除第一个元素
    public T removeFirst() {
        return this.remove(0);
    }

    // 删除末尾元素
    public T removeLast() {
        return remove(size-1);

    }

    // 从数组中删除指定元素
    public void removeElement(int e) {
        for (int i=0;i<size;i++){
            if(data[i].equals(e)){
                remove(i);
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }
}