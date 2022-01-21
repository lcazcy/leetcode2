package day1_17;

import java.util.Arrays;


/**
 * i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 *
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 *
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 */
public class lifeboat {

    /**
     * 要使需要的船数尽可能地少，应当使载两人的船尽可能地多。
     *
     * 设 people\textit{people}people 的长度为 nnn。考虑体重最轻的人：
     *
     *     若他不能与体重最重的人同乘一艘船，那么体重最重的人无法与任何人同乘一艘船，此时应单独分配一艘船给体重最重的人。从 people\textit{people}people 中去掉体重最重的人后，我们缩小了问题的规模，变成求解剩余 n−1n-1n−1 个人所需的最小船数，将其加一即为原问题的答案。
     *     若他能与体重最重的人同乘一艘船，那么他能与其余任何人同乘一艘船，为了尽可能地利用船的承载重量，选择与体重最重的人同乘一艘船是最优的。从 people\textit{people}people 中去掉体重最轻和体重最重的人后，我们缩小了问题的规模，变成求解剩余 n−2n-2n−2 个人所需的最小船数，将其加一即为原问题的答案。
     *
     * 在代码实现时，我们可以先对 people 排序，然后用两个指针分别指向体重最轻和体重最重的人，按照上述规则来移动指针，并统计
     * @param args
     */
    public static void main(String[] args) {
        int[] people = {8, 7, 11, 12, 13, 11};
        int limit = 20;

        int ans = numRescueBoats(people, limit);
        System.out.println("最少数量为" + ans);
    }

    /**
     *
     * @param people  人数
     * @param limit   船的最大承受重量
     * @return  最少船数
     */
    public static int numRescueBoats(int[] people, int limit){
        int ans = 0;  // 最少船的数量
        Arrays.sort(people); // 对people 排序
        int light = 0;    // 指向最轻的人
        int heavy = people.length - 1;  // 指向最重的人

        while(light <= heavy){
            if(people[light] + people[heavy] > limit){
                --heavy;
            }else{
                ++light;
                --heavy;
            }
            ++ans;
        }
        return ans;
    }
}
