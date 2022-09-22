/**
 * 递归八皇后问题
 * @author Qiu
 * @data 2022/9/21 0021   21:33
 */
public class Queen8 {

    // 定义最大皇后数
    int max = 8;

    // 统计解法
    static int count = 0;

    // 定义数组，保存皇后的放置位置
    int[] array = new int[max];


    public static void main(String[] args) {
        // 测试
        Queen8 q = new Queen8();
        q.check(0);
        System.out.println("共有"+ count + "种解法");
    }


    /**
     * 放置n个皇后
     * @param n
     */
    private void check(int n){
        if(n == max){
            // n = 8 时起始已经放置了8个皇后
            print();
            return;
        }
        // 依次放入皇后，并判断冲突
        for(int i = 0; i < max; i++){
            // 将第n个皇后放置在第1列
            array[n] = i;
            // 判断是否冲突
            if(judge(n)){
                // 不冲突继续放皇后
                // 每一次递归时 进入check中都会有for(int i = 0; i < max; i++){}循环,因此会有回溯
                check(n + 1);
            }
            // 如果发生冲突，继续执行array[n] = i; 将第n个皇后放置在本行的后移的一个位置

        }


    }


    /**
     * 查看放置的第n个皇后，就去检测该皇后是否与前面的皇后发生冲突
     * @param n 第n个皇后
     * @return
     */
    private boolean judge(int n){
        for(int i = 0; i < n; i++){
            // 判断是否符合摆放要求，
            // array[i] == array[n] 判断第n个皇后是否与第n-1个皇后在同一列
            // Math.abs(n-i) == Math.abs(array[n] - array[i]) 判断第n个皇后是否与第n-1个皇后在同一斜线
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;

    }


    private void print(){
        count++;
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
