import java.util.Arrays;

/**
 * 插入排序
 * @author Qiu
 * @data 2022/9/22 0022   14:02
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] array = new int[]{2, 5, 6, 3, 4, 7, 1, 8};
        System.out.println("排序前的结果: " + Arrays.toString(array));

        // 控制获取每一个元素
        for (int i = 1; i < array.length; i++){
            // 比较次数
            for(int j = i; j >= 1; j--){
                // 与前一个元素比较，是否小于前面的元素
                if(array[j] < array[j - 1]){
                    // 交换位置
                    int temp = 0;
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }else {
                    break;
                }
            }
        }
        System.out.println("排序后的结果: " + Arrays.toString(array));
    }



}
