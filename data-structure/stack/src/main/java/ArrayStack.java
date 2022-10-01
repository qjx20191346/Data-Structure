/**
 * @author Qiu
 * @data 2022/9/17 0017   15:35
 */
public class ArrayStack {

    /**
     * 栈的大小
     */
    private int maxStack;

    /**
     * 数组模拟栈
     */
    private int[] stack;

    /**
     * 表示栈顶所在的位置，默认情况下如果没有数据，使用-1
     */
    private int top = -1;


    public ArrayStack(int maxStack){
        this.maxStack = maxStack;
        // 初始化数组容量
        stack = new int[maxStack];
    }


    /**
     * 1. 压栈
     * 2. 出栈
     * 3. 判断是否是空栈
     * 4. 判断是否是满栈
     */
    // 判断是否是满栈
    public boolean isFullStack(){
        return this.top == this.maxStack - 1;
    }

    // 判断是否是空栈
    public boolean isEmptyStack(){
        return this.top == -1;
    }


    // 压栈
    public void push(int val){
        // 是否栈满
        if(isFullStack()){
            // 运行时异常
            throw new RuntimeException("此栈已满");
        }

        // 栈针加一
        top++;
        // 压栈
        stack[top] = val;
    }


    public int pop(){
        // 判断是否栈空
        if(isEmptyStack()){
            // 运行时异常
            throw new RuntimeException("此栈已空");
        }
        // 出栈
        int value = stack[top];
        // 栈针减一
        top--;
        return value;
    }


    /**
     * 查看栈中所有元素
     */
    public void list(){
        // 判断是否栈空
        if(isEmptyStack()){
            // 运行时异常
            throw new RuntimeException("此栈已空");
        }

        for(int i = 0; i < stack.length; i++){
            System.out.println("stack["+i+"]=" + stack[i]);
        }

    }

    /**
     * 此时栈中元素存在的个数
     */
    public int length(){
        return this.top + 1;
    }


    /**
     * 判断是否是一个运算符 + - * /
     */
    public boolean isOper(char v){
        return v == '+' || v == '-' || v == '*' || v == '/';
    }

    /**
     * 使用数字表示运算的优先级
     */
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        }else {
            return -1;
        }
    }




    /**
     * 返回栈的栈顶数据
     * @return
     */
    public int peek(){
        return this.stack[top];
    }


    /**
     * 返回栈的容量大小
     * @return
     */
    public int stackLength(){
        return this.stack.length;
    }


    /**
     * 计算两个数进行运算的结果
     */
    public int calculate(int num1, int num2, int oper){
        // 计算结果
        int result = 0;
        switch (oper){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;

            default:
                break;
        }
        return result;
    }




}
