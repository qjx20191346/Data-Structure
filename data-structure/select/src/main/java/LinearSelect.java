/**
 * 线性排序
 * @author Qiu
 * @data 2022/9/22 0022   21:52
 */
public class LinearSelect {

    public static void main(String[] args) {

        // 查询该数组下是否有9这个元素，返回起索引值，否则返回-1
        int[] array = new int[]{11, 4, 6, 2, 3, 9, 7, 8};

        int i = show(array,9);
        System.out.println("下标为 " + i + "是第 "+ (i+1) + "个元素");
    }

    public static int show(int[] array, int target){

        for(int i = 0; i < array.length; i++){
            if(array[i] == target){
                return i;
            }
        }
        return -1;
    }
}
