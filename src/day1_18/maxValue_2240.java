package day1_18;

/**
 * 礼物的最大价值：
 *
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，
 * 并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 */
public class maxValue_2240 {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(maxValue(grid));
        System.out.println(maxValues(grid));
    }

    /**
     * 设 f(i,j)f(i, j)f(i,j) 为从棋盘左上角走至单元格 (i,j)(i ,j)(i,j) 的礼物最大累计价值，
     * 易得到以下递推关系：f(i,j) 等于 f(i,j−1) 和 f(i−1,j)中的较大值
     * 加上当前单元格礼物价值 grid(i,j)
     *
     * f(i,j)=max[f(i,j−1),f(i−1,j)]+grid(i,j)f(i,j)
     * @param grid 价值数组
     * @return 最大价值
     */
    public static int maxValues(int[][] grid){
        int m = grid.length;   // 行
        int n = grid[0].length;  // 列
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j ++){
                if(i == 0 && j == 0){
                    continue;
                }else if(i == 0){
                    grid[i][j] += grid[i][j - 1];
                }else if(j == 0){
                    grid[i][j] += grid[i - 1][j];
                }else{
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }

        return grid[m - 1][n - 1];
    }


    /**
     * 多开辟了空间
     * @param grid  礼物价值数组
     * @return  最大价值
     */
    public static int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        //dp[i][j]表示从grid[0][0]到grid[i - 1][j - 1]时的最大价值
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][column];
    }
}
