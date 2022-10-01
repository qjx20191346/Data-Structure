/**
 *
 * 插值查找
 * @author Qiu
 * @data 2022/9/23 0023   9:56
 */
public class InsertSearch {

    public static void main(String[] args) {

        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};

        int left = 0;

        int right = array.length - 1;

        int searchVal = 5;

        int index = Search(array, left, right, searchVal);
        System.out.println("该元素的索引是" + index);

    }


    public static int Search(int[] array, int left, int right, int searchVal){

        // 防止数组越界
        if(left > right || searchVal < array[0] || searchVal > array[array.length - 1]){
            return -1;
        }
        int mid = left + (right - left)*(searchVal - array[left])/(array[right] - array[left]);
        int midVal = array[mid];

        if(searchVal > midVal){
            return Search(array, mid + 1, right, searchVal);
        } else if(searchVal < midVal){
            return Search(array, left, mid - 1, searchVal);
        } else {
            return mid;
        }
    }
}
