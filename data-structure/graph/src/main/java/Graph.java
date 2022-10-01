import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 图
 * @author Qiu
 * @data 2022/9/29 0029   21:12
 */
public class Graph {

    /**
     * 存储顶点的集合
     */
    private ArrayList<String> vertexList;

    /**
     * 存储图对应的临阶矩阵
     */
    private int[][] edges;

    /**
     * 边的数目
     */
    private int numOfEdges;

    /**
     * 定义数组boolean[] 记录某个节点是否被访问
     */
    private boolean[] isVisited ;

    public static void main(String[] args) {
        // 测试图的初始化
        // 顶点个数
        int n = 8;
        // 初始化顶点的值
        //String Vertexs[] = {"A", "B", "C", "D", "E"};
        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        // 创建图对象
        Graph graph = new Graph(8);
        // 循环添加顶点
        for(String value: Vertexs){
            graph.insertVertex(value);
        }
        // 添加边 A-B B-C A-C B-D B-E
        /*graph.insertEdge(0,1,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);*/
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.insertEdge(3,7,1);
        graph.insertEdge(4,7,1);
        graph.insertEdge(2,5,1);
        graph.insertEdge(2,6,1);
        graph.insertEdge(5,6,1);

        // 显示邻接矩阵
        graph.showGraph();

        // 测试深度优先搜索
        System.out.println("深度遍历");
        graph.dfs();

        System.out.println();

        // 测试广度优先搜索
        System.out.println("广度遍历");
        graph.bfs();


    }


    /**
     * 构造器
     * @param n n个数据
     */
    public Graph(int n){
        // 初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[8];
    }


    /**
     * 得到第一个相邻顶点的下标
     * @param index
     * @return 如果存在返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index){
        for(int j = 0; j < vertexList.size(); j++){
            if(edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }

    /**
     * 根据前一个顶点的下标获取下一个相邻顶点的信息
     * @param v1 顶点
     * @param v2 顶点
     * @return 下一个相邻顶点的信息
     */
    public int getNextNeighbor(int v1, int v2){
        for(int j = v2 + 1; j < vertexList.size(); j++){
            if(edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    /**
     * 深度优先搜索
     * @param isVisited 顶点是否被访问
     * @param i 顶点
     */
    private void dfs(boolean[] isVisited, int i){
        // 输出访问节点
        System.out.print(getValueByIndex(i) + "-->");
        // 将访问过的顶点设置为true
        isVisited[i] = true;
        // 查找顶点i的下一个顶点
        int w = getFirstNeighbor(i);
        // 存在相邻顶点
        while(w != -1){
            // 没有被访问过
            if(!isVisited[w]){
                dfs(isVisited, w);
            }
            // 如果w顶点已经被访问
            w = getNextNeighbor(i, w);
        }

    }


    /**
     * 重载dfs
     */
    public void dfs(){
        isVisited = new boolean[vertexList.size()];
        // 遍历所有顶点,进行dfs回溯
        for (int i = 0; i < getNumOfVertex(); i++){
            if(! isVisited[i]){
                dfs(isVisited, i);
            }
        }
    }


    /**
     * 广度优先搜索
     * @param isVisited 顶点是否被访问
     * @param i 顶点
     */
    public void bfs(boolean[] isVisited, int i){
        // 队列的头结点的下标
        int u;
        // 邻接节点
        int w;
        // 队列记录访问顺序
        LinkedList search = new LinkedList();
        // 访问节点，输出节点信息
        System.out.print(getValueByIndex(i) + "-->");
        // 标记被访问信息
        isVisited[i] = true;
        // 将节点接入队列
        search.addLast(i);
        // 循环加入节点
        while (!search.isEmpty()){
            // 取出队列头节点下标
            u = (Integer) search.removeFirst();
            // 得到第一个临界点的下标
            w = getFirstNeighbor(u);
            // 找到顶点
            while (w != -1){
                // 判断是否被访问过
                if(!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "-->");
                    // 标记已被访问
                    isVisited[w] = true;
                    // 入队
                    search.addLast(w);
                }
                // 已经访问过了
                // 以u为前驱节点，找到w后面的下一个邻接节点
                w = getNextNeighbor(u, w);
            }
        }
    }


    /**
     * 对bsf重载
     */
    public void bfs(){
        isVisited = new boolean[vertexList.size()];
        for(int i = 0; i < getNumOfVertex(); i++){
            if(!isVisited[i]){
                bfs(isVisited, i);
            }
        }
    }



    /**
     * 返回顶点的个数
     * @return 顶点的个数
     */
    public int getNumOfVertex(){
        return vertexList.size();
    }

    /**
     * 返回边的个数
     * @return 边的个数
     */
    public int getNumOfEdges(){
        return numOfEdges;
    }

    /**
     * 返回顶点i(下标) 对应的数据
     * @param i 顶点
     * @return 顶点i(下标) 对应的数据
     */
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    /**
     * 返回v1 v2 的值
     * @param v1 顶点
     * @param v2 顶点
     * @return 顶点的值
     */
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    /**
     * 显示图对应的矩阵
     */
    public void showGraph(){
        for(int[] link : edges){
            System.err.println(Arrays.toString(link));
        }
    }

    /**
     * 插入节点
     * @param vertex 节点的值
     */
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     * 插入边
     * @param v1 表示点的下标即是第几个顶点
     * @param v2 第二个顶点对应的下标
     * @param weight 矩阵中表示关联的数值
     */
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}




