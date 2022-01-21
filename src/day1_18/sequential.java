package day1_18;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 顺次数:
 *
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 */
public class sequential {
    public static void main(String[] args) {

        sequential sequential = new sequential();
        List<Integer> res = new LinkedList<>();
        res = sequential.sequentialDigits(100,100000);

        System.out.println(res);
    }


    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new LinkedList<>();
        //顺次数第一位(1~9);遍历以i开头的所有顺次数
        for (int i = 1; i <= 9; i++) {
            int num = i;
            //顺次数其他位;其他位都比上一位多1,使用j++
            for (int j = i + 1; j <= 9; j++) { // <= 9 是因为最多为123456789
                //因为是尾部添加，所以之前的数字要扩大十倍
                num = num * 10 + j;
                //如果这个顺次数在范围内，加入结果集
                if (num >= low && num <= high) {
                    res.add(num);
                }
            }
        }

        //调用集合工具包排序方法进行排序
        Collections.sort(res);
        return res;
    }
}
