package dataStructure.stack;

/**
 * <p>标题:栈 </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2019/3/31 16:07</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public interface IStack<E> {
    E push(E item);
    E pop();
    E peek();
    int size();
    boolean empty();
    boolean isFull();
}
