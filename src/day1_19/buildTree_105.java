package day1_19;


import common.TreeNode;
import common.mySort;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据前序遍历和中序遍历序列  创建二叉树
 */
public class buildTree_105 {

    @Test
    public void test01(){
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        TreeNode root = buildTree(preOrder, inOrder);
        mySort.levelOrder(root);
    }

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preOrder, int[] inOrder){
        int n = preOrder.length;
        indexMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++){
            indexMap.put(inOrder[i], i);
        }
        return myBuildTree(preOrder, inOrder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] preOrder, int[] inOrder, int preOrder_left, int preOrder_right, int inOrder_left, int inOrder_right){
        if(preOrder_left > preOrder_right){
            return null;
        }

        // 前序遍历的第一个节点就是根节点
        int preOrder_root = preOrder_left;
        // 在中序遍历中定位根节点
        int inOrder_root = indexMap.get(preOrder[preOrder_root]);

        // 先把根节点创建出来
        TreeNode root = new TreeNode(preOrder[preOrder_root]);
        // 得到左子树中节点的数目
        int sizeLeftSubTree = inOrder_root - inOrder_left;

        //  递归的构造左子树，并连接到根节点
        //  先序遍历中[从 左边界+1  开始到  左边界+sizeLeftSubTree] 个元素
        //  就对应了 中序遍历中 [从 左边界  开始到 根节点定位-1] 的元素
        root.left = myBuildTree(preOrder, inOrder, preOrder_left + 1, preOrder_left + sizeLeftSubTree, inOrder_left,inOrder_root - 1);

        //  递归的构造右子树，并连接到根节点
        //  先序遍历中[从 左边界+1+左子树节点数目  开始到  右边界] 个元素
        //  就对应了 中序遍历中 [从 根节点定位+1  开始到 右边界] 的元素
        root.right = myBuildTree(preOrder, inOrder, preOrder_left + 1 + sizeLeftSubTree, preOrder_right, inOrder_root + 1, inOrder_right);

        return root;
    }
}
