import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 基数排序
 * @author Qiu
 * @data 2022/9/20 0020   16:23
 */
public class BasicSort {

    public static void main(String[] args) {

        // 待排数组
        int[] arrays = new int[]{53,542,3,63,14,214,154,748,616};
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss:SS");
        System.out.println("开始前时间" + sf.format(new Date()));

        sort(arrays);
        System.out.println("结束时间" + sf.format(new Date()));

    }


    /**
     * 1. 获取元素最大位
     *
     * @param arrays
     */
    public static void sort(int[] arrays){
        int max = 0;
        // 获取最大位数
        for(int i = 0; i < arrays.length; i++){
            if (arrays[i] > max){
                max = arrays[i];
            }
        }
        // 将int类型转换为string类型，获取字符串长度
        int maxLength = (max+"").length();


        /**
         * 定义二维数组，大小为10，表示10个桶，每个桶也是一个数组
         */

        // 定义桶
        int[][] bucket = new int[10][arrays.length];
        // 辅助数组
        int[] bucketElementCount = new int[10];
        // 循环获取无序数列
        for(int i = 0; i < arrays.length; i++){
            // 个位数，作为桶的下标
            int locationElement = arrays[i] % 10;
            // 放入桶中
            bucket[locationElement][bucketElementCount[locationElement]] = arrays[i];
            bucketElementCount[locationElement]++;
        }

        /**
         * 遍历每一个桶，经元素存放到源数组中
         * 第一轮，对个位数进行判断
         */
        int index = 0;
        for(int k = 0; k < bucketElementCount.length; k++){
            if (bucketElementCount[k] != 0){
                // 根据辅助数组获取元素
                for(int l = 0; l < bucketElementCount[k]; l++){
                    // 替换原数组中的待排数据
                    arrays[index++] = bucket[k][l];
                }
            }
            bucketElementCount[k] = 0;
        }
        System.out.println(Arrays.toString(arrays));


        // 第一轮，对十位数进行判断
        for(int j = 0; j < arrays.length; j++){
            int locationElement = arrays[j]/10%10;

            bucket[locationElement][bucketElementCount[locationElement]] = arrays[j];
            bucketElementCount[locationElement]++;
        }

        // 按桶的顺序放回原数组中
        int index2 = 0;
        for (int k = 0; k < bucketElementCount.length; k++){
            if(bucketElementCount[k] != 0){
                for(int l = 0; l < bucketElementCount[k];l++){
                    arrays[index2++] = bucket[k][l];
                }
            }
            // 将辅助数据重新赋值为0
            bucketElementCount[k] = 0;
        }


        /**
         * 获取百位数比较
         */

        for (int j = 0;j<arrays.length;j++){
            int locationElement = arrays[j]/100%10;

            bucket[locationElement][bucketElementCount[locationElement]] = arrays[j];
            bucketElementCount[locationElement]++;
        }

        /**
         * 取出来按照桶的顺序放回原数组中
         */
        int indx = 0;
        for (int k = 0;k<bucketElementCount.length;k++){
            if (bucketElementCount[k] !=0){
                for (int l=0;l<bucketElementCount[k];l++){
                    arrays[indx++] = bucket[k][l];
                }
            }
            bucketElementCount[k] = 0;
        }


        System.out.println("基数排序后的顺序:"+Arrays.toString(arrays));
    }



}
