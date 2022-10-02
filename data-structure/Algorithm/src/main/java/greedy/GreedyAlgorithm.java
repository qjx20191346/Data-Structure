package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 贪心算法
 * @author Qiu
 * @data 2022/10/2 0002   9:35
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {

        // 创建广播电台
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        // 将电台放入broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("天津");
        hashSet1.add("上海");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        // 加入Map
        broadcasts.put("k1", hashSet1);
        broadcasts.put("k2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("k4", hashSet4);
        broadcasts.put("k5", hashSet5);

        //存放所有地区（随时变化）
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");


        // 创建ArrayList， 存放电台选择的集合
        ArrayList<String> selects = new ArrayList<String>();

        // 定义一个临时集合，在遍历过程中，存放遍历过程中的电台覆盖的区域和当前还没有覆盖区域的地区的交集。
        HashSet<String> tempSet = new HashSet<String>();

        String maxKey = null;
        // 定义maxKey，保存在一次遍历过程中，能够覆盖的最大的未覆盖的地区对应的电台的key
        // 如果maxKey 不为 null, 则加入到selects
        while (allAreas.size() != 0){
            // 每次循环将Maxkey制空
            maxKey = null;
            // allAreas.size() != 0，表示还没有覆盖所有地区
            // 遍历broadCasts, 取出对应的key
            for(String key: broadcasts.keySet()){
                tempSet.clear();
                // 当前这个key能够覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                // 求出tempSet 和 allAreas 的交集
                tempSet.retainAll(allAreas);
                // 如果当前这个集合包含的未覆盖地区的数量，比maxKy指向的集合未覆盖的地区还多
                // tempSet.size() > broadcasts.get(maxKey).size()) 贪心算法特性
                /*maxTempSet.addAll(broadcasts.get(maxKey));tempSet.size() > maxTempSet.size();*/
                if(tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())){
                    maxKey = key;
                }
            }
            if(maxKey != null){
                selects.add(maxKey);
                // 将maxKey指向的广播电台从allAreas中去除
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println("得到的选择的结果 " + selects);

    }

}
