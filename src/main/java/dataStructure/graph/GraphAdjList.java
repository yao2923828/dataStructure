package dataStructure.graph;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2019/4/1 12:28</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class GraphAdjList<E> implements IGraph<E> {
    private VNode<E> [] vexs;
    private int numOfVexs;
    private int maxNumOfVexs;
    private boolean [] visited;

    public GraphAdjList(int maxNumOfVexs) {
        this.maxNumOfVexs = maxNumOfVexs;
        vexs= (VNode<E>[]) Array.newInstance(VNode.class, maxNumOfVexs);
    }

    @Override
    public int getNumOfVertex() {
        return numOfVexs;
    }

    @Override
    public boolean insertVex(E v) {
        if(numOfVexs>=maxNumOfVexs){
            return false;
        }
        VNode<E> vex=new VNode<E>();
        vex.data=v;
        vexs[numOfVexs++]=vex;
        return true;
    }

    @Override
    public boolean deleteVex(E v) {
        for(int i=0;i<numOfVexs;i++){
            if(vexs[i].data.equals(v)){
                for (int j=i;j<numOfVexs-1;j++){
                    vexs[j]=vexs[j+1];
                }
                vexs[numOfVexs-1]=null;
                numOfVexs--;
                ENode current;
                ENode previous;
                for(int j=0;j<numOfVexs;j++){
                    if(vexs[j].firstadj==null){
                        continue;
                    }
                    if(vexs[j].firstadj.adjvx==i){
                        vexs[j].firstadj=null;
                        continue;
                    }
                    current=vexs[j].firstadj;
                    while (current!=null){
                        previous=current;
                        current=current.nextadj;
                        if(current!=null&&current.adjvx==i){
                            previous.nextadj=current.nextadj;
                            break;
                        }
                    }
                }
                for (int j=0;j<numOfVexs;j++){
                    current=vexs[j].firstadj;
                    while (current!=null){
                        if(current.adjvx>i){
                            current.adjvx--;
                        }
                        current=current.nextadj;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOfVex(E v) {
        for (int i=0;i<numOfVexs;i++){
            if(vexs[i].data.equals(v)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public E valueOfVex(int v) {
        if(v<0||v>=numOfVexs){
            return null;
        }
        return vexs[v].data;
    }

    @Override
    public boolean insertEdge(int v1, int v2, int weight) {
        if(v1<0||v2<0||v1>numOfVexs||v2>numOfVexs){
            throw new ArrayIndexOutOfBoundsException();
        }
        ENode vex1=new ENode(v2, weight);
        if(vexs[v1].firstadj==null){
            vexs[v1].firstadj=vex1;
        }else {
            vex1.nextadj=vexs[v1].firstadj;
            vexs[v1].firstadj=vex1;
        }
        ENode vex2=new ENode(v1, weight);
        if(vexs[v2].firstadj==null){
            vexs[v2].firstadj=vex2;
        }else{
            vex2.nextadj=vexs[v2].firstadj;
            vexs[v2].firstadj=vex2;
        }
        return true;
    }

    @Override
    public boolean deleteEdge(int v1, int v2) {
        if(v1<0||v2<0||v1>numOfVexs||v2>numOfVexs){
            throw new ArrayIndexOutOfBoundsException();
        }
        ENode current=vexs[v1].firstadj;
        ENode previous=null;
        while (current!=null&&current.adjvx!=v2){
            previous=current;
            current=current.nextadj;
        }
        if(current!=null){
            previous.nextadj=current.nextadj;
        }
        current=vexs[v2].firstadj;
        while (current!=null&&current.adjvx!=v1){
            previous=current;
            current=current.nextadj;
        }
        if(current!=null){
            previous.nextadj=current.nextadj;
        }
        return true;
    }

    @Override
    public int getEdge(int v1, int v2) {
        if(v1<0||v2<0||v1>numOfVexs||v2>numOfVexs){
            throw new ArrayIndexOutOfBoundsException();
        }
        ENode current=vexs[v1].firstadj;
        while (current!=null){
            if(current!=null){
                return current.weight;
            }
            current=current.nextadj;
        }
        return 0;
    }

    @Override
    public String depthFirstSearch(int v) {
        if(v<0||v>=numOfVexs){
            throw new ArrayIndexOutOfBoundsException();
        }
        visited=new boolean[numOfVexs];
        StringBuilder sb=new StringBuilder();
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(v);
        visited[v]=true;
        ENode current;
        while (!stack.isEmpty()){
            v=stack.pop();
            sb.append(vexs[v].data+",");
            current=vexs[v].firstadj;
            while (current!=null){
                if(!visited[current.adjvx]){
                    stack.push(current.adjvx);
                    visited[current.adjvx]=true;
                }
                current=current.nextadj;
            }
        }
        return sb.length()>0?sb.substring(0,sb.length()-1):null;
    }

    @Override
    public String breadFirstSearch(int v) {
        if(v<0||v>=numOfVexs){
            throw new ArrayIndexOutOfBoundsException();
        }
        visited=new boolean[numOfVexs];
        StringBuilder sb=new StringBuilder();
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.offer(v);
        ENode current;
        while (!queue.isEmpty()){
            v=queue.poll();
            sb.append(vexs[v].data+",");
            current=vexs[v].firstadj;
            while (current!=null){
                if(!visited[current.adjvx]){
                    queue.offer(current.adjvx);
                    visited[current.adjvx]=true;
                }
                current=current.nextadj;
            }
        }
        return sb.length()>0?sb.substring(0,sb.length()):null;
    }

    @Override
    public int[] dijkstra(int v) {
        if(v<0||v>=numOfVexs){
            throw new ArrayIndexOutOfBoundsException();
        }
        boolean[] st=new boolean[numOfVexs];
        int [] distance=new int[numOfVexs];
        for(int i=0;i<numOfVexs;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        ENode current=vexs[v].firstadj;
        while (current!=null){
            distance[current.adjvx]=current.weight;
            current=current.nextadj;
        }
        distance[v]=0;
        st[v]=true;
        for (int i=0;i<numOfVexs;i++){
            int min=Integer.MAX_VALUE;
            int index=-1;
            for(int j=0;j<numOfVexs;j++){
                if(st[j]==false){
                    if(distance[j]<min){
                        index=j;
                        min=distance[j];
                    }
                }
            }
            if(index!=-1){
                st[index]=true;
            }
            for (int w=0;w<numOfVexs;w++){
                if(st[w]==false){
                    current=vexs[w].firstadj;
                }
                while (current!=null){
                    if(current.adjvx==index){
                        if((min+current.weight)<distance[w]){
                            distance[w]=min+current.weight;
                            break;
                        }
                    }
                    current=current.nextadj;
                }
            }
        }
        return distance;
    }

    private static class ENode{
        int adjvx;
        int weight;
        ENode nextadj;

        public ENode(int adjvx, int weight) {
            this.adjvx = adjvx;
            this.weight = weight;
        }
    }
    private static class VNode<E>{
        E data;
        ENode firstadj;
    }
}
