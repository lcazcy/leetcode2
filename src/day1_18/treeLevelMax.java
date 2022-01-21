package day1_18;

import common.TreeNode;

import java.util.*;

public class treeLevelMax {
    public static void main(String[] args) {
        treeLevelMax treeLevelMax = new treeLevelMax();
        List<Integer> res = new ArrayList<>();


        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(9);
        TreeNode node = new TreeNode(3,node2,node3);
        TreeNode node1 = new TreeNode(2,null,node4);
        TreeNode root = new TreeNode(1,node,node1);

        res = treeLevelMax.largestValue(root);
        System.out.println("DFS" + res);
        res = treeLevelMax.largestValues(root);
        System.out.println("BFS" + res);
    }


    /**
     * BFS
     * 一行一行的遍历
     * @param root  根节点
     * @return  每层最大值List
     */
    public List<Integer> largestValues(TreeNode root) {
        // LinkedList 实现队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> values = new ArrayList<>();
        if(root != null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            int levelSize = queue.size(); // 每一层的数量
            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();   // 出队
                max = Math.max(max, node.val);   // 记录每层最大数
                if(node.left != null){
                    queue.add(node.left);     // 左节点入队
                }
                if(node.right != null){
                    queue.add(node.right);     // 右节点入队
                }
            }
            values.add(max);
        }

        return values;
    }


    public List<Integer> largestValue(TreeNode root){
        List<Integer> res = new ArrayList<>();
        helper(root, res, 1);
        return res;
    }

    /**
     *
     * @param root 根节点
     * @param res  第i个数表示第i层的最大值
     * @param level 表示的是第几层
     */
    private void helper(TreeNode root, List<Integer> res, int level){
        if(root == null){
            return;
        }
        if(level == res.size() + 1){      //如果走到下一层了直接加入到集合中
            res.add(root.val);              // 即到达了新的一层
        }else{
            //注意：我们的level是从1开始的，也就是说root
            // 是第一层，而集合list的下标是从0开始的，
            // 所以这里level要减1。
            // Math.max(res.get(level - 1), root.val)表示的
            // 是遍历到的第level层的root.val值和集合中的第level
            // 个元素的值哪个大，就要哪个。
            res.set(level - 1, Math.max(res.get(level - 1), root.val));
        }
        helper(root.left, res, level +1);  // 向左遍历， 层数加一
        helper(root.right, res, level + 1); // 向右遍历， 层数加一
    }
}

