/**
 * 计算器测试
 * @author Qiu
 * @data 2022/9/17 0017   17:20
 */
public class ArrayStackTest02 {

    public static void main(String[] args) {
        //String str = "1+7";
        String str = "1+2+6*3+4-6/2";
        /**
         * 1.需要遍历字符串，获取每一个字符
         * 2.判断当前字符是一个运算符还是一个数字
         * 3.把数字存放在数字栈中，把运算符放在运算符栈
         * 4.运算符栈：  如果是一个空栈，那么直接运算符入栈，如果运算符栈中已经了其他运算符，
         * 就需要先对比运算符优先级，新进来的运算符如果小于等于原栈中运算符，那么需要把原运算符弹栈，
         * 数字栈中数字进行弹栈，进行运算，运算后的结果重新放入数字栈中，新运算符入栈。
         * 如果新运算符优先级大于原符号栈中运算符，那么新的符号直接入栈
         */
        // 初始化数字栈
        ArrayStack numStack = new ArrayStack(100);
        // 初始化符号栈
        ArrayStack symbolStack = new ArrayStack(100);
        // 获取字符串的长度
        int length = str.length();
        int temp1 = 0; // 数字栈中需要计算的数字
        int temp2 = 0; // 数字栈中需要计算的数字
        int result = 0; // 数字栈中需要计算的数字的结果
        int symbolChar = 0; // 运算符

        String value = ""; // 存储对位数字

        for(int i = 0; i < length; i++){
            // 获取运算符
            char c = str.charAt(i);
            // 判断字符类型,是否是运算符
            if(symbolStack.isOper(c)){
                // 判断是否是空栈
                if(!symbolStack.isEmptyStack()){
                    // 非空，就比较运算符优先级(与栈顶元素相比较)(优先级低)
                    if(symbolStack.priority(c) <= symbolStack.priority(symbolStack.peek())){
                        // 把原运算符弹栈， 数字栈中数字进行弹栈，进行运算，运算后的结果重新放入数字栈中，新运算符入栈
                        // 1. 去符号栈中获取栈顶的运算符号
                        temp1 = numStack.pop();
                        temp2 = numStack.pop();
                        // 2. 去数字栈中获取需要计算的两个数字
                        symbolChar = symbolStack.pop();
                        // 计算结果
                        result = numStack.calculate(temp1,temp2,symbolChar);
                        // 3. 将结果再次放入数字栈中
                        numStack.push(result);
                        // 4. 将当前符号压入符号栈中
                        symbolStack.push(c);
                    }else{ // 优先级高
                        // 直接将符号压入符号栈
                        symbolStack.push(c);
                    }
                }else{ // 空栈
                    // 直接将符号压入符号栈
                    symbolStack.push(c);
                }
            }else { // 不是运算符 33+44
                /**
                 * 先记录数字，将所有连续的数字合并为一个数字
                 */
                value += c; // 多位数拼接为一位数

                if(i == length - 1){
                    // 字符长最后一位一定是数字，直接入栈
                    numStack.push(Integer.parseInt(value)); // 格式转换
                }else { // 非最后一个字符，判断是否是字符
                    char data = str.substring(i+1,i+2).charAt(0);
                    if(symbolStack.isOper(data)){
                        numStack.push(Integer.parseInt(value));
                        value=""; // 刷新value值
                    }
                }
            }
        }
        while(true){
            if (symbolStack.isEmptyStack()){
                break;
            }
            // 获取数字栈数据
            temp1 = numStack.pop();
            temp2 = numStack.pop();
            // 获取符号栈数据
            symbolChar = symbolStack.pop();
            // 计算结果
            result = numStack.calculate(temp1,temp2,symbolChar);
            // 压栈
            numStack.push(result);
        }
        // 最后数字栈中只有结果一个数据
        // 出栈
        int res = numStack.pop();
        System.out.println("结果是" + res);

    }
}
