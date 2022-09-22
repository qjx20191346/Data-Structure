import java.util.Arrays;

/**
 * 希尔排序
 * @author Qiu
 * @data 2022/9/22 0022   16:10
 */
public class ShellSort {

    public static void main(String[] args) {

        int [] array = new int[]{11, 55, 6, 9, 3, 1, 0 ,-1, 8, 4};

        System.out.println("排序前 " + Arrays.toString(array));

        // 实现增量的变化
        for(int gap = array.length / 2; gap > 0; gap /= 2){
            for(int i = gap; i < array.length; i++){
                for(int j = i - gap; j >= 0; j -= gap){
                    if(array[j] > array[j + gap]){
                        int temp = 0;
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp ;
                    }
                }
            }
        }
        System.out.println("排序后 " + Arrays.toString(array));
    }
}
