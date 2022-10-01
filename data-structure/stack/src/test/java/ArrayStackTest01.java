/**
 *
 * 回文数据测试
 * @author Qiu
 * @data 2022/9/17 0017   15:58
 */
public class ArrayStackTest01 {

    public static void main(String[] args) {
        /**
         * 回文数据
         * 通过ArrayStack数据判断一个字符串是否是回文数据
         */
        System.out.println(detecation("hello"));
        // false
        System.out.println(detecation("adada"));
        // false for循环中动态获取数组长度
        // true  for循环中静态获取数组长度

    }

    public static boolean detecation(String val){

        // 初始化栈对象
        ArrayStack arrayStack = new ArrayStack(100);
        // 获取字符串长度
        int length = val.length();
        // 将字符串数据逐次获取字符压栈到数组中
        for(int i = 0; i < length; i++){
            // charAt 返回指定位置的字符
            // 压栈
            arrayStack.push(val.charAt(i));
        }

        // 获取
        String newval = "";
        int length1 = arrayStack.length(); // 固定字符串长度
        for(int i = 0; i < length1; i++){
            // 判断是否非空
            if(!arrayStack.isEmptyStack()){
                char pop = (char)arrayStack.pop();
                newval = newval + pop;
            }
        }
        // 判断是否是回文数据
        if(val.equals(newval)){
            return true;
        }
        return false;


    }

}
