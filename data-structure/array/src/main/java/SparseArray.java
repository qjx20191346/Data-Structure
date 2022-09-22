/**
 * 使用二维数组，模拟棋盘数据
 * @author Qiu
 * @data 2022/9/19 0019   20:01
 */
public class SparseArray {

    public static void main(String[] args) {
        // 使用二维数组，模拟棋盘数据
        int[][] array = new int[11][11];
        // 填写数据
        array[1][2] = 1;
        array[2][4] = 2;

        // 打印棋盘
        for(int[] row :array){
            for(int val :row){
                System.out.print(val + " ");
            }
            System.out.println();
        }

        /**
         * 需要把二维数组中的有效数压缩到稀疏数组中
         */

        // 计算二维数组中的有效数据
        int sum = 0;
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(array[i][j] != 0){
                    sum++;
                }
            }
        }

        // System.out.println("有效数据个数"+sum);

        // 定义稀疏数组
        int [][] sparseArray = new int[sum+1][3];
        // 第0行第0列，行数11
        sparseArray[0][0] = 11;
        // 第0行第1列，列数11
        sparseArray[0][1] = 11;
        // 有效数据个数
        sparseArray[0][2] = sum;

        // 将数据写入稀疏数组
        int count = 0;
        // 行索引
        for(int i = 0; i < 11; i++){
            // 列索引
            for(int j = 0; j < 11; j++){
                // 判断是否是有效数据
                if(array[i][j] != 0){
                    // 指针偏移
                    count++;
                    // 稀疏数组行数
                    sparseArray[count][0] = i;
                    // 稀疏数组列数
                    sparseArray[count][1] = j;
                    // 存储在稀疏数组中的元素的值
                    sparseArray[count][2] = array[i][j];
                }
            }
        }
        System.out.println("----------------------------------");
        // 打印稀疏数组
        for(int i = 0; i < sparseArray.length; i++){
            System.out.println(sparseArray[i][0]+","+sparseArray[i][1]+","+sparseArray[i][2]);
        }


        /**
         * 将稀疏数组转换为二维数组
         */

        int[][] oldArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        /**
         * sparseArray[i][1] 二维数组的行数
         * sparseArray[i][2] 二维数组的列数
         * sparseArray[i][3] 二维数组的值
         * 其他数据默认为0
         */
        for(int i = 1; i <= count; i++){
           oldArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("-----------------------------------");
        // 还原原始数组棋盘

        for(int[] row: oldArray){
            for (int val: row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
