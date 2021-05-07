package dataStructure.tree;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2019/4/1 10:09</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public interface IBiTree<E> {
    void create(E val,Node<E> l,Node<E> r);
    Node<E> getLchild(Node<E> p);
    Node<E> getRchild(Node<E> p);
    void insetL(E val,Node<E> p);
    void insetR(E val,Node<E> p);
    Node<E> deleteL(Node<E> p);
    Node<E> deleteR(Node<E> p);
    Node<E> search(Node<E> root,E value);
    void traverse(Node<E> root,int i);
    Node<E> getHead();
    boolean isEmpty();
    Node<E> root();
    boolean isLead(Node<E> p);

    void inorder(Node<E> p);
    void preorder(Node<E> p);
    void postorder(Node<E> p);
    void levelorder(Node<E> root);
}
