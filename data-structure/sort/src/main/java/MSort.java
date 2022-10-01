import java.util.Arrays;

/**
 * 归并排序（分治）
 * @author Qiu
 * @data 2022/9/22 0022   21:18
 */
public class MSort {

    public static void main(String[] args) {

        int[] array = new int[]{6, 9, 1, 4, 7, 3, 2, 5};
        System.out.println("排序前的数组" + Arrays.toString(array));
        // 临时数组
        int[] temp = new int[array.length];

        sort(array, 0, array.length - 1, temp);

        System.out.println("排序后的数组" + Arrays.toString(array));

    }

    public static void sort(int [] array, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            // 向左分解
            sort(array, left, mid, temp);
            // 向右分解
            sort(array, mid + 1, right, temp);
            // 合并数据
            sum(array,left,right,mid,temp);
        }
    }
    // 最后合并数据
    public static void sum(int [] array, int left, int right, int mid, int[] temp){

        int i = left;
        int j = mid + 1;
        // 指向临时数组的下标
        int t = 0;
        while(i <= mid && j <= right){
            if (array[i] <= array[j]){
                temp[t] = array[i];
                t++;
                i++;
            }else{
                temp[t] = array[j];
                t++;
                j++;
            }
        }
        // 如果是奇数个数组，，将剩余的元素直接存入数组(左多右少)
        while (i <= mid){
            temp[t] = array[i];
            t++;
            i++;
        }
        // 如果是奇数个数组，，将剩余的元素直接存入数组(右多左少)
        while (j <= right){
            temp[t] = array[j];
            t++;
            j++;
        }

        // 将临时数组中的元素添加到原数组中
        int tempIndex = left;
        int k = 0;
        while(tempIndex <= right){
            array[tempIndex] = temp[k];
            k++;
            tempIndex++;
        }
    }
}
