package dataStructure.array;

/**
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 *
 * Author: Zheng
 * modify: xing, Gsealy
 */
public class ArrayTest implements IArray{
    //存储数据
    private int [] data;
    //数据的最大长度
    private int n;
    //数组实际存储的元素数量
    private int count;

    public ArrayTest(int capacity) {
        data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    @Override
    public int find(int index) {
        if (index < -1 || index > count)
            return -1;
        return data[index];
    }

    @Override
    public boolean insert(int index, int value) {
        if(count==n){
            System.out.println("数据已满");
            return false;
        }
        if(index<-1||index>count)return false;
        //新增时，元素需要向后移动
        for (int i=count;i > index;i--){
            data[i]=data[i-1];
        }
        data[index]=value;
        count++;
        return true;
    }

    @Override
    public boolean delete(int index) {
        if(index<0||index>count-1) return false;
        //删除时，元素需要向前补齐
        for(int i=index-1;i<count;i--){
            data[i]=data[i+1];
        }
        return true;
    }

    @Override
    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();
    }
}
