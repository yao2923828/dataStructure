package dataStructure.tree;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2019/4/1 10:10</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class Node<E> {
    private E data;
    private Node<E> lchild;
    private Node<E> rchild;

    public Node() {
        this(null);
    }

    public Node(E data) {
        this(data,null,null);
    }

    public Node(Node<E> lchild, Node<E> rchild) {
        this(null,lchild,rchild);
    }

    public Node(E data, Node<E> lchild, Node<E> rchild) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getLchild() {
        return lchild;
    }

    public void setLchild(Node<E> lchild) {
        this.lchild = lchild;
    }

    public Node<E> getRchild() {
        return rchild;
    }

    public void setRchild(Node<E> rchild) {
        this.rchild = rchild;
    }
}
