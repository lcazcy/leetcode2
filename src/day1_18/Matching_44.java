package day1_18;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 *
 * 两个字符串完全匹配才算匹配成功。
 */
public class Matching_44 {
    public static void main(String[] args) {

        Matching_44 matching = new Matching_44();

        System.out.println(matching.isMatch("adceb","*a*b"));
        System.out.println(matching.isMatch("acdcb","a*c?b"));
    }

    /**
     * dp[i][j] 表示 字符串s 的前i个与 字符串p的前 j 个是否匹配
     */
    public boolean isMatch(String s, String p){
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for(int i = 1; i <= n; ++i) {
            if(p.charAt(i - 1) == '*'){
                dp[0][i] = true;
            }else{
                break;
            }
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                // 这个for循环里面的   我真的没理解！！
                if(p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }else if(p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
