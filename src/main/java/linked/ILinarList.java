package linked;

/**
 * <p>标题: 线性表</p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2019/3/30 16:45</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public interface ILinarList<E> {
    boolean add(E item); //添加元素
    boolean add(int index,E item); //插入元素
    E romove(int index); //删除元素
    int indexof(E item); //定位元素
    E get(int index); //取元素
    E set(int index,E item); //设置元素
    int size(); //求线性长度
    void clear(); //清空线性表
    boolean isEmpty(); //判断线性表是否为空
}
