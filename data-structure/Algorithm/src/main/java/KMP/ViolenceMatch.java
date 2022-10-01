package KMP;

/**
 * 暴力匹配
 * @author Qiu
 * @data 2022/10/1 0001   16:27
 */
public class ViolenceMatch {

    public static void main(String[] args) {
        String srt1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        int str2Length = str2.length();
        int index = violenceMatch(srt1,str2);
        System.out.println("匹配的字符串从第" + index + "位到第"+ (index + str2Length) + "位");
    }


    /**
     * 暴力匹配算法
     * @param str1 字符串库
     * @param str2 待匹配字符串
     * @return 返回下标
     */
    public static int violenceMatch(String str1, String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        // 指向s1
        int i = 0;
        // 指向s2
        int j = 0;

        // 保证检索不越界
        while( i < s1Len && j < s2Len){
            if(s1[i] == s2[j]){
                i++;
                j++;
            } else {
                // 匹配失败
                // str1[i] != str2[j] 令 i = i -(j - 1) j = 0
                i = i - (j - 1);
                j = 0;
            }
        }
        // 判断是否匹配成功
        if(j == s2Len){
            return i - j;
        }else {
            return -1;
        }

    }

}
