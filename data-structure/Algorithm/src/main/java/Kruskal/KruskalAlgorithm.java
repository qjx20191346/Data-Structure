package Kruskal;

/**
 * 克鲁斯卡尔算法
 * @author Qiu
 * @data 2022/10/2 0002   17:22
 */
public class KruskalAlgorithm {

    /**
     * 边的个数
     */
    private int edgeNum;
    /**
     * 顶点数组
     */
    private char[] vertexs;
    /**
     * 邻接矩阵
     */
    private int[][] matrix;
    /**
     * 使用INF 表示两个顶点不能连通
     */
    private static final int INF = Integer.MAX_VALUE;


    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        // 邻接矩阵
        int matrix[][] = {

        };

        // 创建KruskalAlgorithm 对象实例
        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm(vertexs, matrix);
        // 输出临界矩阵
        kruskalAlgorithm.print();

    }

    /**
     *
     * @param vertexs
     * @param matrix
     */
    public KruskalAlgorithm(char[] vertexs, int[][] matrix){
        // 初始化顶点数和边的个数
        int vlen = vertexs.length;

        // 初始化顶点, 复制拷贝
        this.vertexs = new char[vlen];
        for(int i = 0; i < vertexs.length; i++){
            this.vertexs[i] = vertexs[i];
        }

        // 初始化边
        this.matrix = new int[vlen][vlen];
        for(int i = 0; i < vlen; i++){
            for(int j = 0; j < vlen; j++){
                this.matrix[i][j] = matrix[i][j];
            }
        }
        // 统计边
        for(int i = 0; i < vlen; i++){
            for(int j = 0; j < vlen; j++){
                if(this.matrix[i][j] != INF){
                    edgeNum++;
                }
            }
        }
    }

    /**
     * 打印邻接矩阵
     */
    public void print(){
        System.out.println("临接矩阵为 ");
        for(int i = 0; i < vertexs.length; i++){
            for(int j = 0; j < vertexs.length; j++){
                System.out.printf("%12d" , matrix[i][j]);
            }
            System.out.println();
        }
    }

}
