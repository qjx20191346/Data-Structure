/**
 * 折半查找(二分查找)
 * @author Qiu
 * @data 2022/9/23 0023   9:29
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] array = new int[]{1,2,3,4,5,6,7,8,9,0};
        // 目标元素
        int target = 7;
        int index = search(array, target);
        System.out.println("目标值索引是" + index);

    }


    public static int search(int[] array, int target){
        // 最小的索引指针位置
        int min = 0;
        // 最大的索引指针位置
        int max = array.length - 1;

        while(min <= max){
            // 平均的索引指针位置
            int mid = (min + max) / 2;
            if(array[mid] == target){
                return mid;
            }
            if (array[mid] < target){
                min = mid + 1;
            }
            if(array[mid] > target){
                max = mid - 1;
            }
        }
        return -1;
    }
}
