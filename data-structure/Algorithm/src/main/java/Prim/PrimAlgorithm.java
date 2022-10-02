package Prim;

import java.util.Arrays;

/**
 * 普利姆算法 (权值固定)
 * @author Qiu
 * @data 2022/10/2 0002   14:35
 */
public class PrimAlgorithm {

    public static void main(String[] args) {
        // 测试图是否创建成功
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        // 用二维数组表示邻接矩阵的关系
        int [][] weight = new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};
        // 创建MyGraph对象
        MyGraph graph = new MyGraph(verxs);
        // 创建MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        // 输出
        minTree.showGraph(graph);
        // 测试prim算法
        minTree.prim(graph, 0);


    }
}


/**
 * 创建最小生成树
 */
class MinTree{
    /**
     * 创建图的邻接矩阵
     * @param graph 图
     * @param verxs 图的节点个数
     * @param data 存放节点数据
     * @param weight 存放边，临接矩阵
     */
    public void createGraph(MyGraph graph, int verxs, char data[], int[][] weight){
        int i, j;
        for(i = 0; i < verxs; i++){
            graph.data[i] = data[i];
            for(j = 0; j < verxs; j++){
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    /**
     * 显示图的邻接矩阵
     * @param graph 邻接矩阵
     */
    public void showGraph(MyGraph graph){
        for(int[] link: graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * prim算法，得到最小生成树
     * @param graph 最小生成树
     * @param v 从图的第几个顶点开始
     */
    public void prim(MyGraph graph, int v){
        // 标记顶点是否被访问过
        int visited[] = new int[graph.verxs];
        // visited 默认元素的值是0
        // 将一访问的节点设置为已访问
        visited[v] = 1;
        // 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        // 将minWeight初始化为较大的数，后面在遍历过程中，会被替换
        int minWeight = 10000;
        // 因为有graph.verxs顶点，prim算法结束后，有graph.verxs - 1 边
        for(int k = 1; k < graph.verxs; k++){
            // i表示访问过的顶点
            for(int i = 0; i < graph.verxs; i++){
                // j表示没有访问过的顶点
                for (int j = 0; j < graph.verxs; j++){
                    if(visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight){
                        // 替换minWeight（寻找已经访问过的顶点和未访问过的顶点间权值最小的边）
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            // 找到最小的一条边
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            // 将当前顶点标记为已经访问过
            visited[h2] = 1;
            // 将minWeight 重新设置为10000
            minWeight = 10000;
        }



    }


}


/**
 * 图
 */
class MyGraph{
    /**
     * 图的节点个数
     */
    int verxs;
    /**
     * 存放节点数据
     */
    char[] data;
    /**
     * 存放边，临接矩阵
     */
    int[][] weight;

    public MyGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];

    }
}