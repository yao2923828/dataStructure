package dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2019/4/1 10:16</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class LinkBiTree<E> implements IBiTree<E> {
    private Node<E> head;
    public Node<E> getHead(){
        return head;
    }

    public LinkBiTree() {
        this.head=null;
    }
    public LinkBiTree(E val) {
        this(val,null,null);
    }
    public LinkBiTree(E val,Node<E> lp,Node<E> rp) {
        Node<E> p=new Node<E>(val,lp,rp);
        head=p;
    }

    @Override
    public void create(E val, Node<E> l, Node<E> r) {

    }

    @Override
    public Node<E> getLchild(Node<E> p) {
        return p.getLchild();
    }

    @Override
    public Node<E> getRchild(Node<E> p) {
        return p.getRchild();
    }

    @Override
    public void insetL(E val, Node<E> p) {
        Node<E> tmp=new Node<E>(val);
        tmp.setLchild(p.getLchild());
        p.setLchild(tmp);
    }

    @Override
    public void insetR(E val, Node<E> p) {
        Node<E> tmp=new Node<E>(val);
        tmp.setRchild(p.getRchild());
        p.setRchild(tmp);
    }

    @Override
    public Node<E> deleteL(Node<E> p) {
        if(p==null||p.getLchild()==null){
            return null;
        }
        Node<E> tmp=p.getLchild();
        p.setLchild(null);
        return tmp;
    }

    @Override
    public Node<E> deleteR(Node<E> p) {
        if(p==null || p.getRchild()==null){
            return null;
        }
        Node<E> tmp=p.getRchild();
        p.setRchild(null);
        return tmp;
    }

    @Override
    public Node<E> search(Node<E> root, E value) {
        Node<E> p=root;
        if(p==null){
            return null;
        }
        if(p.getData().equals(value)){
            return p;
        }
        if(p.getLchild()!=null){
            return search(p.getLchild(), value);
        }
        if(p.getRchild()!=null){
            return search(p.getRchild(), value);
        }
        return null;
    }

    @Override
    public void traverse(Node<E> root, int i) {

    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public Node<E> root() {
        return head;
    }

    @Override
    public boolean isLead(Node<E> p) {
        return p!=null&&p.getLchild()==null&&p.getRchild()==null;
    }

    @Override
    public void inorder(Node<E> p) {
        if(isEmpty()){
            System.out.println("Tree is empty");
            return;
        }
        if(p!=null){
            inorder(p.getLchild());
            System.out.println(p.getData()+" ");
            inorder(p.getRchild());
        }

    }

    @Override
    public void preorder(Node<E> p) {
        if(isEmpty()){
            System.out.println("Tree is empty");
            return;
        }
        if(p!=null){
            System.out.println(p.getData()+" ");
            preorder(p.getLchild());
            preorder(p.getRchild());
        }
    }

    @Override
    public void postorder(Node<E> p) {
        if(isEmpty()){
            System.out.println("Tree is empty");
            return;
        }
        if(p!=null){
            postorder(p.getLchild());
            postorder(p.getRchild());
            System.out.println(p.getData()+" ");
        }
    }

    @Override
    public void levelorder(Node<E> root) {
        if(root==null){
            return;
        }
        Queue<Node<E>> q=new LinkedList<Node<E>>();
        q.add(root);
        while (!q.isEmpty()){
            Node<E> tmp=q.poll();
            System.out.println(tmp.getData()+" ");
            if(tmp.getLchild()!=null){
                //将当前节点的左孩子入队
                q.add(tmp.getLchild());
            }
            if(tmp.getRchild()!=null){
                //将当前节点的右孩子节点入队
                q.add(tmp.getRchild());
            }
        }
    }
}
