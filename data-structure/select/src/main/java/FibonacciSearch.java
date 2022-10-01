import java.util.Arrays;

/**
 *
 * 斐波那契查找
 * @author Qiu
 * @data 2022/9/23 0023   10:38
 */
public class FibonacciSearch {

    public static void main(String[] args) {
        int[] array = new int[]{1,1,2,3,5,8,13,21,34,55,89};

        int index = Search(array, 55);

        System.out.println(index);
    }

    public static int[] f(){
        int[] f = new int[20];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i < f.length; i++){
            f[i] = f[i - 1] + f[i - 2];

        }
        return f;
    }


    public static int Search(int[] array, int key){
        int low = 0;
        int hight = array.length - 1;
        int k = 0;
        int mid = 0;
        int[] f = f();

        // 寻找分割点
        while (hight > f[k] - 1){
            k++;
        }

        int[] temp = Arrays.copyOf(array, f[k]);

        // 扩充数组
        for(int i = hight + 1; i < temp.length; i++){
            temp[i] = array[hight];
        }

        while (low <= hight){
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]){
                hight = mid - 1;
                k--;
            } else if (key > temp[mid]){
                low = mid + 1;
                k -= 2;
            } else {
                if(mid <= hight){
                    return mid;
                }else {
                    return hight;
                }
            }

        }

        return -1;

    }
}
