package KMP;

import java.util.Arrays;

/**
 * KMP算法
 * @author Qiu
 * @data 2022/10/1 0001   17:12
 */
public class KmpAlgorithm {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int str2Length = str2.length() - 1;
        int[] next = kmpNext("ABCDABD");
        System.out.println("next = " +  Arrays.toString(next));

        int index = kmpSearch(str1, str2, next);
        System.out.println("匹配的字符串从第" + index + "位到第"+ (index + str2Length) + "位");
    }


    /**
     * KMP算法
     * @param str1 源字符串
     * @param str2 子串
     * @param next 部分匹配表 子串对应的部分匹配表
     * @return -1 没有匹配， 否则返回第一个匹配位置
     */
    public static int kmpSearch(String str1, String str2, int[] next){

        for(int i = 0, j = 0; i < str1.length(); i++){

            // KMP算法核心
            while( j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j - 1];
            }

            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if(j == str2.length()){
                return i - j + 1;
            }
        }
        return -1;
    }



    /**
     * 获取一个字符串的部分匹配值表
     * @param dest 用于存储部分匹配值表
     * @return 部分匹配值表
     */
    public static int[] kmpNext(String dest){
        // 创建一个next数组保存部分匹配值表
        int[] next = new int[dest.length()];
        // 字符串长度位1, 部分匹配值位0
        next[0] = 0;
        for(int i = 1, j = 0; i < dest.length(); i++){
            // 当dest.charAt(i) != dest.charAt(j) 满足时，需要从next[j - 1]获取新的j
            // 直到dest.charAt(i) == dest.charAt(j) 才退出
            // kmp算法的核心
            while(j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }
            // dest.charAt(i) == dest.charAt(j)满足时， 部分匹配值 +1
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;

    }
}
