package day1_20;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 */

public class maxLengthString_3 {

    @Test
    public void test(){
        int length = maxLengthString("asdfkjla");
        int length2 = maxLengthString2("asdkjfa");
        System.out.println("length\t" + length + "\tlength2\t" + length2);
    }

    /**
     * 利用滑动窗口，HashMap
     * @param s  原字符串
     * @return  最长连续字符串长度
     */
    public int maxLengthString(String s){
        if(s.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0; // 最长连续字符串长度
        int left = 0; // 左边界
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i)) + 1); //  移动左边界，找到上一个s.charAt(i)的位置+1
            }
            map.put(s.charAt(i),i);  // 未出现过，加入到map
            max = Math.max(max, i - left + 1);  // 更新max值
        }
        return max;
    }

    /**
     * 利用HashSet
     */
    public int maxLengthString2(String s){
        if(s.length() == 0){
            return 0;
        }
        int n = s.length();
        int rk = -1; // 右指针
        int max = 0;
        Set<Character> occ = new HashSet<>();

        for(int i = 0; i < n; i++){
            if(i != 0){
                occ.remove(s.charAt(i - 1));
            }
            while(rk + 1 < n && !occ.contains(s.charAt(rk + 1))){
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            max = Math.max(max, rk - i + 1);
        }

        return max;
    }
}
