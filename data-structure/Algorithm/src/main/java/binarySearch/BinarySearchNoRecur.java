package binarySearch;

/**
 * 二分查找非递归
 * @author Qiu
 * @data 2022/10/1 0001   9:46
 */
public class BinarySearchNoRecur {

    public static void main(String[] args) {

        int[] array = {1, 3, 6, 11, 67, 100};
        int target = 100;
        int index = binarySearch(array, target);
        System.out.println("index = " + index);

    }


    /**
     * 二分查找非递归
     * @param array 待查数组, 升序数组
     * @param target 目标值
     * @return 目标值再数组中的下标， -1表示未找到
     */
    public static int binarySearch(int[] array, int target){

        int left = 0;
        int right = array.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(array[mid] == target){
                return mid;
            } else if(array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
