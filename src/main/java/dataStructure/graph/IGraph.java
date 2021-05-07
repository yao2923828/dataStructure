package dataStructure.graph;

/**
 * <p>标题: 图</p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2019/4/1 10:46</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public interface IGraph<E> {
    public int getNumOfVertex();
    boolean insertVex(E v);
    boolean deleteVex(E v);
    int indexOfVex(E v);
    E valueOfVex(int v);
    boolean insertEdge(int v1,int v2,int weight);
    boolean deleteEdge(int v1,int v2);
    int getEdge(int v1,int v2);
    String depthFirstSearch(int v);
    String breadFirstSearch(int v);
    int [] dijkstra(int v);
}
