package graph;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2019/4/1 10:52</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class GraphAdjMatrix<E> implements IGraph<E> {
    private E[] vexs;
    private int [][] edges;
    private int numOfVexs;
    private int maxNumOfVexs;
    private boolean [] visited;

    public GraphAdjMatrix(int maxNumOfVexs,Class<E> type) {
        this.maxNumOfVexs = maxNumOfVexs;
        edges=new int[maxNumOfVexs][maxNumOfVexs];
        vexs= (E[]) Array.newInstance(type, maxNumOfVexs);
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
        vexs[numOfVexs++]=v;
        return true;
    }

    @Override
    public boolean deleteVex(E v) {

        for (int i=0;i<numOfVexs;i++){
            if(vexs[i].equals(v)){
                for (int j=i;j<numOfVexs;j++){
                    vexs[j]=vexs[j+1];
                }
                vexs[numOfVexs-1]=null;
                for(int col=i;col<numOfVexs-1;col++){
                    for (int row=0;row<numOfVexs;row++){
                        edges[col][row]=edges[col+1][row];
                    }
                }
                for(int row=i;row<numOfVexs-1;row++){
                    for (int col=0;col<numOfVexs;col++){
                        edges[col][row]=edges[col][row+1];
                    }
                }
                numOfVexs--;
                return true;

            }
        }
        return false;
    }

    @Override
    public int indexOfVex(E v) {
        for(int i=0;i<numOfVexs;i++){
            if(vexs[i].equals(v)){
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
        return vexs[v];
    }

    @Override
    public boolean insertEdge(int v1, int v2, int weight) {
        if(v1<0||v2<0||v1>=numOfVexs||v2>=numOfVexs){
            throw new ArrayIndexOutOfBoundsException();
        }
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        return true;
    }

    @Override
    public boolean deleteEdge(int v1, int v2) {
        if(v1<0||v2<0||v1>=numOfVexs||v2>=numOfVexs){
            throw new ArrayIndexOutOfBoundsException();
        }
        edges[v1][v2]=0;
        edges[v2][v1]=0;
        return true;
    }

    @Override
    public int getEdge(int v1, int v2) {
        if(v1<0||v2<0||v1>=numOfVexs||v2>=numOfVexs){
            throw new ArrayIndexOutOfBoundsException();
        }
        return edges[v1][v2];
    }

    @Override
    public String depthFirstSearch(int v) {
        if(v<0||v>=numOfVexs){
            throw  new ArrayIndexOutOfBoundsException();
        }
        visited=new boolean[numOfVexs];
        StringBuilder sb=new StringBuilder();
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(v);
        visited[v]=true;
        while (!stack.isEmpty()){
            v=stack.pop();
            sb.append(vexs[v]+",");
            for (int i=numOfVexs-1;i>=0;i--){
                if(edges[v][i]!=0&&edges[v][i]!=Integer.MAX_VALUE&&!visited[i]){
                    stack.push(i);
                    visited[i]=true;
                }
            }
        }
        return sb.length()>0?sb.substring(0,sb.length()-1):null;
    }

    @Override
    public String breadFirstSearch(int v) {
        if(v<0||v>=numOfVexs){
            throw  new ArrayIndexOutOfBoundsException();
        }
        visited=new boolean[numOfVexs];
        StringBuilder sb=new StringBuilder();
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.offer(v);
        visited[v]=true;
        while (!queue.isEmpty()){
            v=queue.poll();
            sb.append(vexs[v]+",");
            for (int i=0;i<numOfVexs;i++){
                if(edges[v][i]!=0&&edges[v][i]!=Integer.MAX_VALUE&&!visited[i]){
                    queue.offer(i);
                    visited[i]=true;
                }
            }
        }
        return sb.length()>0?sb.substring(0,sb.length()-1):null;
    }

    @Override
    public int[] dijkstra(int v) {
        if(v<0||v>=numOfVexs){
            throw  new ArrayIndexOutOfBoundsException();
        }
        boolean [] st=new boolean[numOfVexs];
        int [] distance=new int[numOfVexs];
        for(int i=0;i<numOfVexs;i++){
            for(int j=i+1;j<numOfVexs;j++){
                if(edges[i][j]==0){
                    edges[i][j]=Integer.MAX_VALUE;
                    edges[j][i]=Integer.MAX_VALUE;
                }
            }
        }
        for(int i=0;i<numOfVexs;i++){
            distance[i]=edges[v][i];
        }
        st[v]=true;
        for (int i=0;i<numOfVexs;++i){
            int min=Integer.MIN_VALUE;
            int index=-1;
            for(int j=0;j<numOfVexs;++j){
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
                    if(edges[index][w]!=Integer.MAX_VALUE&&(min+edges[index][w]<distance[w])){
                        distance[w]=min+edges[index][w];
                    }
                }
            }
        }
        return distance;

    }
}
