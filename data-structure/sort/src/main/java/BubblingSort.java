import java.util.Arrays;

/**
 * 冒泡排序
 * @author Qiu
 * @data 2022/9/20 0020   20:57
 */
public class BubblingSort {
    public static void main(String[] args) {

        int[] arrays = new int[]{4,7,9,3,1};
        System.out.println(Arrays.toString(arrays));
        // 临时变量
        int temp = 0;
        // 控制比较的行数
        for(int i = 0; i < arrays.length - 1; i++){
            // 控制比较的次数
            for(int j = 0; j < arrays.length - 1 - i; j++){
                if(arrays[j] > arrays[j + 1]){
                    temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arrays));
    }
}
