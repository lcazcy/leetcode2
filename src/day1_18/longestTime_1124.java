package day1_18;

/**
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 *
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 *
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 *
 * 请你返回「表现良好时间段」的最大长度。
 */
public class longestTime_1124 {

    public static void main(String[] args) {
        int[] hours = {9,9,6,0,6,9};
        int length = longestWPI(hours);
        System.out.println("最长时间段为"+ length);
    }

    /**
     * 暴力算法
     * 工作时间大于8则属于劳累的一天，否则属于悠闲一天。
     * 对于数组的每个元素，只有两种状态，劳累or悠闲。
     * 要知道劳累的天数多还是优先天数多，
     * 就可以用1表示当天劳累，-1表示当天优先。
     * 对于天数区间[i,j]，累加值为正，说明劳累天数更多。
     * @param hours  工作时间数组
     * @return
     */
    public static int longestWPI(int[] hours){
        int n = hours.length;
        for(int i = 0; i < n; i++){
            hours[i] = hours[i] > 8 ? 1 : -1;
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = i; j < n; j++){
                count += hours[j];
                if(count > 0){
                    res = Math.max(res, j - i + 1);
                }
            }
            if(n - i <= res){
                return res;
            }
        }
        return res;
    }

}
