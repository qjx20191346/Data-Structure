package Divide_and_Conquer;

/**
 * 分治法解决汉诺塔问题
 * @author Qiu
 * @data 2022/10/1 0001   10:26
 */
public class HanoiTower {

    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }


    /**
     * 汉诺塔的移动问题
     * @param num 待移动的盘子个数
     * @param a 柱子a(起点)
     * @param b 柱子b
     * @param c 柱子c(终点)
     */
    public static void hanoiTower(int num, char a, char b, char c){

        if(num == 1){
            System.out.println("第1个盘子从 " + a + "->" + c);
        } else {
            // num >= 2 看作两个盘，1. 最下面的盘 2.上面所有盘
            // 1. 先把最上面的所有盘 A -> B, 移动过程使用C
            hanoiTower(num - 1, a, c, b );
            // 2. 把最下面的盘 A -> C
            System.out.println("第" + num + "个盘子从 " + a + "->" + c);
            // 3. 把B塔所有盘子从 B -> C， 移动过程使用A
            hanoiTower(num - 1, b, a, c);
        }

    }

}
