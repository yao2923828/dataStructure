package dataStructure.array;

/**
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 *
 * Author: Zheng
 * modify: xing, Gsealy
 */
public interface IArray {

    //根据索引，找到数据中的元素并返回
    public int find(int index);

    //插入元素:头部插入，尾部插入
    public boolean insert(int index, int value);
    //根据索引，删除数组中元素
    public boolean delete(int index);
    public void printAll() ;
}
