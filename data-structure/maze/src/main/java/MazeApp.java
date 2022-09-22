/**
 * 递归解决迷宫问题
 * @author Qiu
 * @data 2022/9/20 0020   9:50
 */
public class MazeApp {

    public static void main(String[] args) {

        int[][] map = new int[8][7];

        /**
         * 将第一行和最后一行设置为墙，设为1
         */
        for(int i = 0; i < 7; i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        /**
         * 将第一列和最后一列设置为墙，设为1
         */
        for(int i = 0; i < 8; i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }

        /**
         * 设置障碍墙
         */
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("新的迷宫");

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");;
            }
            System.out.println();
        }

        isRun(map,1,1);

        System.out.println("行走路线");
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");;
            }
            System.out.println();
        }

    }

    /**
     * 设置起点[1][1]和终点[6][5]
     * 判断四周方向是否可行 0表示没有走过，1表示障碍物，2表示可行，3表示已经走过无法再走
     * @return
     */
    public static boolean isRun(int[][] map,int i, int j){
        if(map[6][5] == 2){
            // 终点
            return true;
        }else{
            if (map[i][j] == 0){
                // 没有走过的路
                map[i][j] = 2;

                // 向上右下左行动(递归)
                if(isRun(map, i+1, j)){
                    return true;
                } else if (isRun(map, i, j+1)) {
                    return true;
                } else if (isRun(map,i-1, j)) {
                    return true;
                } else if (isRun(map, i, j-1)) {
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else{
                // 除了0其他全部禁止通过
                return false;
            }
        }

    }























}
