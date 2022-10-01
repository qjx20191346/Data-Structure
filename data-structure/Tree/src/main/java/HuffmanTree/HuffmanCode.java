package HuffmanTree;


import java.io.*;
import java.util.*;

/**
 * 哈夫曼编码
 * @author Qiu
 * @data 2022/9/27 0027   15:04
 */
public class HuffmanCode {

    public static void main(String[] args) {
        /*String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);

        byte[] huffmanCodesBytes = huffmanZip(contentBytes);
        System.out.println("压缩后的结果是 " + Arrays.toString(huffmanCodesBytes) + " 长度为 " + huffmanCodesBytes.length);*/

        /*List<HuffmanNode> nodes = getNodes(contentBytes);
        System.out.println("nodes = " + nodes);

        // 测试创建的赫夫曼树
        System.out.println("霍夫曼树");
        HuffmanNode huffmanTreeRoot = createHuffmanTree(nodes);
        System.out.println("前序遍历");
        huffmanTreeRoot.preOrder();

        // 测试是否生成了对应上的哈夫曼编码
        Map<Byte, String> huffmanCodes =  getCodes(huffmanTreeRoot);
        System.out.println("生成的哈夫曼编码表" + huffmanCodes);

        // 测试
        *//*zip(contentBytes, huffmanCodes);*//*
        byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
        System.out.println("huffmanCodeBytes = " + Arrays.toString(huffmanCodeBytes));
*/
        // 发送huffmanCodeBytes 数组

        // 测试byteToBitString方法
        //System.out.println(byteToBitString((byte) -1));

        // 测试decode方法
        /*byte[] sourceBytes = decode(huffmanCodes, huffmanCodesBytes);
        System.out.println("原来的字符串 " + new String(sourceBytes));*/


        // 测试压缩文件（按对象流压缩）
        /*String srcFile = "";
        String dstFile = "";
        zipFile(srcFile, dstFile);
        System.out.println("压缩文件成功");*/

        // 测试解压文件（按对象流解压）
        String zipFile = "";
        String dstFile = "";
        unZipFile(zipFile, dstFile);
        System.out.println("解压文件成功");
    }


    /**
     * 将一个文件jinx压缩
     * @param srcFile 待压缩文件的路径
     * @param dstFile 压缩后文件的保存目录
     */
    public static void zipFile(String srcFile, String dstFile){
        // 创建文件输入流
        FileInputStream is = null;
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try{
            // 创建文件输入流
            is = new FileInputStream(srcFile);
            // 创建一个与原文件大小相同的byte数组
            byte[] b = new byte[is.available()];
            // 读取文件
            is.read(b);
            // 对原文件进行压缩
            byte[]  huffmanBytes = huffmanZip(b);
            // 创建文件输出流
            os = new FileOutputStream(dstFile);
            // 创建一个与文件输出流相关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            // 以对象流的方式写入赫夫曼编码，为了灾后和恢复原文件时使用
            oos.writeObject(huffmanBytes);
            // 将赫夫曼编码写入压缩文件中
            oos.writeObject(huffmanCodes);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                // 关闭资源
                is.close();
                os.close();
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }


    /**
     * 对压缩文件进行解压
     * @param zipFile 待解压的压缩文件
     * @param dstFile 解压后保存的路径
     */
    public static void unZipFile(String zipFile, String dstFile){

        // 定义文件输出流
        InputStream is = null;
        // 定义文件输出流
        OutputStream os = null;
        // 定义对象输入流
        ObjectInputStream ois = null;
        try{
            // 创建文件输入流
            is = new FileInputStream(zipFile);
            // 创建一个与is对象相关联的对象输入流
            ois = new ObjectInputStream(is);
            // 读取byte数组 huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            // 读取保存的赫夫曼编码表
            Map<Byte, String > huffmanCodes = (Map<Byte, String>) ois.readObject();
            //解码
            byte[] bytes = decode(huffmanCodes, huffmanBytes);
            // 创建文件输出流
            os = new FileOutputStream(dstFile);
            // 将数组写入目标文件
            os.write(bytes);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 关闭资源
            try {
                is.close();
                os.close();
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }









    /**
     * 对对应的压缩数据进行解码
     * @param huffmanCodes 赫夫曼编码表 map
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 原来的字符长对应的数组
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes){

        // 1. 得到huffmanBytes 对应的二进制字符串
        StringBuilder stringBuilder = new StringBuilder();
        // 将byte数组转成二进制的字符串
        for(int i = 0; i < huffmanBytes.length; i++){
            byte b = huffmanBytes[i];
            // 判断是否是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1 );
            stringBuilder.append(byteToBitString(!flag, b));
        }
        // 把字符串安装指定的霍夫曼编码进行解码
        // 把赫夫曼编码表进行调换，反向查询
        Map<String, Byte> map = new HashMap<String, Byte>();
        for(Map.Entry<Byte, String> entry:huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
        // 创建要给的集合，存放在byte中
        List<Byte> list = new ArrayList<>();
        // 扫描stringBuilder二进制对应的字符串
        for(int i = 0; i < stringBuilder.length();){
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while(flag){
                // 取出0 或者 1
                // i 不动，count 移动，直到匹配到一个字符
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if(b == null){
                    // 没有匹配到
                    count++;
                }else{
                    // 匹配到
                    flag = false;
                }
            }
            list.add(b);
            // 将i移动到count位置，继续循环
            i += count;
        }
        // 当for循环结束后，list中存储了所有的已经匹配的字符串
        // 将list中的数据放入byte中，并返回
        byte[] b = new byte[list.size()];
        for(int i = 0; i < b.length; i++){
            b[i] = list.get(i);
        }
        return b;


    }






    /**
     * 将一个byte 装换成一个二进制的字符串
     * @param b 传入的byte数组
     * @param flag 标识是否需要补高位，true表示需要补高位， false表示不需要补高位, 如果是最后一个字节无需补高位
     * @return b 对应的二进制的字符串（补码返回值）
     */
    private static String byteToBitString(boolean flag, byte b){
        // 使用一个int类型的变量保存 b
        int temp = b;
        // 如果是正数需要不高位
        if(flag){
            // 按位或运算
            temp |= 256;
        }
        // 返回的是temp二进制对应的补码
        String str = Integer.toBinaryString(temp);
        if(flag){
            return str.substring(str.length() - 8);
        }else {
            return str;
        }

    }




    /**
     * 将所有方法封装为一个方法，方便调用
     * @param bytes 原始的字符串对应的字节数组
     * @return 返回经过赫夫曼编码处理过的字节数组（压缩过的数组）
     */
    private static byte[] huffmanZip(byte[] bytes){
        List<HuffmanNode> nodes = getNodes(bytes);
        // 根据nodes创建的赫夫曼树
        HuffmanNode huffmanTreeRoot = createHuffmanTree(nodes);
        // 生成对应上的哈夫曼编码
        Map<Byte, String> huffmanCodes =  getCodes(huffmanTreeRoot);
        // 根据生成的对应上的哈夫曼编码，压缩得到压缩后的赫夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        // 返回压缩后的赫夫曼编码字节
        return huffmanCodeBytes;

    }



    /**
     * 将字符串对应的byte[] 数组， 通过生成的霍夫曼编码表，返回一个霍夫曼编码 雅安锁喉的byte[]
     * @param bytes 原始的未压缩的字符串 对应的byte[]
     * @param huffmanCodes 生成的霍夫曼编码map
     * @return 返回霍夫曼编码处理后的 byte[]
     */

    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes){
        // 利用huffmanCodes 将 bytes 转换成赫夫曼编码对应的字符串
        StringBuilder stringBuilder1 = new StringBuilder();
        // 遍历bytes数组
        for(byte b: bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        //System.out.println("测试 " + stringBuilder.toString());

        // 将字符串转换为byte[]

        // 统计返回的byte[] huffmanCodeBytes 的长度
        int length;
        if(stringBuilder.length() % 8 == 0){
            length = stringBuilder.length() / 8;
        }else{
            length = stringBuilder.length() / 8 + 1;
        }
        // 创建一个存储压缩后的byte[]数组
        byte[] huffmanCodeBytes = new byte[length];
        // 记录是第几个byte
        int index = 0;
        for(int i = 0; i < stringBuilder.length(); i+=8){
            // 每8位对应一个byte，所以步长+8
            String strByte;
            if(i + 8 > stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            }else{
                strByte = stringBuilder.substring(i , i + 8);
            }
            // 将strByte转换为byte，放入到huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }

        return huffmanCodeBytes;
    }



    /**
     * 1. 将霍夫曼编码标放在Map<Byte,String> 形式
     */
    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    /**
     * 2. 在生成霍夫曼编码时，需要拼接路径，定义一个StringBuilder 存储某个叶子节点的路径
     */
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * 为了调用方便，重载getCodes
     * @param root 根节点
     * @return 霍夫曼编码
     */
    private static Map<Byte,String> getCodes(HuffmanNode root){
        // 处理根节点
        if(root == null){
            return null;
        }
        // 处理root的左子树
        getCodes(root.left, "0", stringBuilder);
        // 处理root的右子树
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }



    /**
     * 将传入的HuffmanNode节点的所有叶子结点的霍夫曼编码得到，并放入到huffmanCodes集合中
     * @param node 叶子结点，从根节点传入
     * @param code 路径 左子结点是 0 右子节点是 1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(HuffmanNode node, String code, StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        // 将code 加入到stringBuilder2
        stringBuilder2.append(code);
        if(code != null){
            // node为空不处理
            // 判断当前node是叶子结点还是非叶子结点
            if(node.data == null){
                // 非叶子结点
                // 递归处理
                // 向左递归
                getCodes(node.left, "0", stringBuilder2);
                // 向左递归
                getCodes(node.right, "1", stringBuilder2);
            } else{
                // 叶子结点
                // 表示找到了某个叶子结点的最后
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }


    /**
     * 前序遍历
     * @param root
     */
    private static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }else{
            System.out.println("霍夫曼树为空树");
        }
    }




    /**
     *
     * @param bytes 接受字节数组
     * @return 返回 List 形式
     */
    private static List<HuffmanNode> getNodes(byte[] bytes){

        // 创建一个ArrayList
        ArrayList<HuffmanNode> nodes = new ArrayList<HuffmanNode>();
        // 存储每个byte出现的次数 --> map[key,value]
        Map<Byte, Integer> counts = new HashMap<>();
        for(byte b: bytes){
            Integer count = counts.get(b);
            if(count == null){
                // Map没有字符数据
                counts.put(b, 1);
            }else{
                counts.put(b, count + 1);
            }
        }
        // 将每个键值对转成HuffmanNode对象，并加入到nodes集合中
        // 遍历Map
        for(Map.Entry<Byte, Integer> entry: counts.entrySet()){
            nodes.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    /**
     * 通过List创建 HuffmanTree 树
     * @param nodes 权值和数据
     * @return HuffmanTree
     */
    private static HuffmanNode createHuffmanTree(List<HuffmanNode> nodes){

        while(nodes.size() > 1){
            // 排序,从小到大
            Collections.sort(nodes);
            // 取出第一颗最小的二叉树
            HuffmanNode leftNode = nodes.get(0);
            // 取出第二颗最小的二叉树
            HuffmanNode rightNode = nodes.get(1);
            // 组合成新的二叉树
            HuffmanNode parent = new HuffmanNode(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            // 将处理过的二叉树移除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 将新的二叉树加入到nodes中
            nodes.add(parent);
        }
        // 返回最后的节点，即哈夫曼树的根节点
        return nodes.get(0);
    }

}


/**
 * 创建Node, 带有权值和数据
 */
class HuffmanNode implements Comparable<HuffmanNode>{
    /**
     * 存放数据（字符）本身，ASC码
     */
    Byte data;
    /**
     * 权值，表示字符出现的次数
     */
    int weight;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }


    @Override
    public int compareTo(HuffmanNode o) {
        // 从小到大排序
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

}

