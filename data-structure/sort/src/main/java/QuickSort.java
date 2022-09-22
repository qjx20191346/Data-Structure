import java.util.Arrays;

/**
 * 快速排序
 * @author Qiu
 * @data 2022/9/20 0020   21:32
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arrays = new int[]{44, 66, 3, 3, 2, 9, 11, 56, 34, 100};

        sort(arrays, 0, arrays.length-1);
        System.out.println(Arrays.toString(arrays));

    }


    public static void sort(int[] arrays, int left, int right){
        int l = left;
        int r = right;
        int temp = 0;
        int pivot = arrays[(left + right) / 2];

        while(l < r){
            // 中间值左边元素小于中间值，右边元素大于中间值
            while (arrays[l] < pivot){
                l++;
            }
            // 右边大于中间值
            while (arrays[r] > pivot){
                r--;
            }
            if(l >= r){
                break;
            }
            temp = arrays[l];
            arrays[l] = arrays[r];
            arrays[r] = temp;

            if(arrays[l] == pivot){
                // 等于中间值
                r--;
            }

            if (arrays[r] == pivot){
                l++;
            }
        }
        if (r == l){
            l++;
            r--;
        }
        if (left < r){
            sort(arrays, left, r);
        }
        if (right > l){
            sort(arrays, l, right);
        }

    }

}
