package Heap;

import java.util.Arrays;

/**
 * 堆排序
 * @author Qiu
 * @data 2022/9/26 0026   15:25
 */
public class HeapSort {

    public static void main(String[] args) {
        // 升序排列(大顶堆)
        int[] array = {4, 6, 8, 5, 9, -11, 2222, 3, 1, 0};
        heapSort(array);


    }


    /**
     * 编写堆排序的方法
     */
    public static void heapSort(int[] array){
        int temp = 0;

        System.out.println("堆排序");

        /*// 分布完成
        adjustHeap(array, 1, array.length);
        System.out.println("第一次 " + Arrays.toString(array));

        adjustHeap(array, 0, array.length);
        System.out.println("第二次 " + Arrays.toString(array));*/

        /**
         * 最终代码,将无序序列构建成一个堆，根据升序或降序需求选择大顶堆或者小顶堆
         */
        for(int i = array.length / 2 - 1; i >= 0; i--){
            adjustHeap(array, i, array.length);
        }

        /**
         * 1. 将堆顶元素与末尾元素交换，将最大元素下沉到数组末端
         * 2. 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
         */
        for(int j = array.length - 1; j > 0; j--){
            // 交换元素
            temp = array[j];
            array[j] = array[0];
            array[0] = temp;
            // 从堆顶开始查找
            adjustHeap(array, 0 , j);
        }

        System.out.println("最终排序后数组为 " + Arrays.toString(array));

    }

    /**
     * 将一个数组(二叉树)，调整成一个大顶堆
     * 完成将以 i对应的非叶子结点的树调整成大顶堆
     * @param array 待调整的数组
     * @param i 非叶子节点在数组中的索引
     * @param length 对多少个元素进行调整，length在逐渐减少
     */
    public static void adjustHeap(int[] array, int i, int length){

        // 获取当前元素的值，保存在临时变量中
        int temp = array[i];
        // 开始调整
        /**
         * 1. k = i * 2 + 1; 表示 K 是 i 节点的左子节点
         * 2.
         */
        for(int k = i * 2 + 1; k < length; k = 2 * k + 1){
            // k + 1 < length && array[k] > array[k+1] 即为小顶堆排序
            if(k + 1 < length && array[k] < array[k+1]){
                // 左子节点的值小于右子节点的值
                k++;
            }
            // 如果子节点大于父节点
            // array[k] < temp 即为小顶堆排序
            if(array[k] > temp){
                // 将较大的节点的值赋值给当前的节点
                array[i] = array[k];
                // i 指向 k 继续循环
                i = k;
            } else{
                break;
            }
        }
        // 当for循环结束后，已将将以i为父节点的树的最大值，放在了最顶上，此时i 不再是传入的值，而是指向当前节点。
        // 将temp的值放到调整后的位置
        array[i] = temp;

    }

}
