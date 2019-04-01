package queue;

/**
 * <p>标题: 队列</p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2019/3/31 16:30</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public interface IQueue<E> {
    boolean enqueue(E item);
    E dequeue();
    E peek();
    int size();
    boolean isEmpty();
    boolean isFull();
}
