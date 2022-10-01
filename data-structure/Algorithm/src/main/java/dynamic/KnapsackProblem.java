package dynamic;

/**
 * 动态规划背包问题
 * @author Qiu
 * @data 2022/10/1 0001   15:06
 */
public class KnapsackProblem {


    public static void main(String[] args) {
        /**
         * 物品重量
         */
        int[] w = {1, 4, 3};
        /**
         * 物品价值
         */
        int[] val = {1500, 3000, 2000};
        /**
         * 背包容量
         */
        int m = 4;
        /**
         * 物品个数
         */
        int n = val.length;


        // 二维数组
        // v[i][j] 表示在前i个物品中能够装入容量为j的背包的最大价值
        int[][] v = new int[n + 1][m + 1];
        // 记录放入商品的情况
        int[][] path = new int[n + 1][m + 1];

        // 初始化第一行和第一列
        // 第一列设置为0
        for(int i = 0; i < v.length; i++){
            v[i][0] = 0;
        }
        // 第一行设置为0
        for(int i = 0; i < v.length; i++){
            v[0][i] = 0;
        }


        // 动态规划处理
        // 不处理第一行
        for(int i = 1; i < v.length; i++){
            // 不处理第一列
            for(int j = 1; j < v[0].length; j++){
                // i 从1开始，因此w[i] 修改成w[i - 1]
                if(w[i - 1] > j){
                    v[i][j] = v[i - 1][j];
                }else{
                    // i 从1开始，因此w[i] 修改成 Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    // 为了体现商品存放到背包的具体情况，不能直接只用公式，需要使用if-else
                    if(v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]){
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        // 将情况记录path
                        path[i][j] = 1;
                    }else{
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        // 输出v
        for(int i = 0; i < v.length; i++){
            for(int j = 0; j < v[i].length; j++){
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        // 输出商品放入详情

        int i = path.length - 1;
        int j = path[0].length - 1;
        // 从path的最后开始找
        while (i > 0 && j > 0){
            if(path[i][j] == 1){
                System.out.println("第" + i + "个商品放入背包");
                j -= w[i-1];
            }
            i--;
        }

    }

}
