package day1_18;

import common.TreeNode;

/**
 * 删除二叉搜索树节点
 * 二叉搜索树的中序遍历的序列是递增排序的序列。中序遍历的遍历次序：Left -> Node -> Right。
 *
 */
public class delSearchTreeNode_450 {
    public static void main(String[] args) {
        delSearchTreeNode_450 delSearchTreeNode_450 = new delSearchTreeNode_450();

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(7);
        TreeNode node = new TreeNode(3,node2,node3);
        TreeNode node1 = new TreeNode(6,null,node4);
        TreeNode root = new TreeNode(5,node,node1);

        System.out.println("删除前：");
        inorder(root);

        delSearchTreeNode_450.deleteNode2(root, 3);
//        delSearchTreeNode_450.deleteNode(root, 3);

        System.out.println("删除后：");
        inorder(root);
    }

    //中序遍历
    public static void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
        return;
    }

    // 删除节点    （递归）
    public TreeNode deleteNode(TreeNode root, int key){
        if(root == null){
            return null;
        }
        if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else{
            //要删除的节点为叶子节点，可以直接删除
            if(root.left == null && root.right == null){
                root = null;
            }else if(root.right != null){  //要删除的节点不是叶子节点且拥有右节点
                root.val = successor(root);   // 用右子树最小节点取代待删节点的值
                root.right = deleteNode(root.right, root.val);  // 删除右子树最小节点
            }else{  //要删除的节点不是叶子节点，且没有右节点但是有左节点
                root.val = predecessor(root);   // 用左子树最大节点取代待删节点的值
                root.left = deleteNode(root.left, root.val);  // 删除左子树最大的值节点
            }
        }

        return root;
    }

    /**
     * 寻找后继节点
     * 先取当前节点的右节点，然后一直取该节点的左节点，
     * 直到左节点为空，则最后指向的节点为后继节点
     * @param root  根节点
     * @return  右子树中最小节点的值，用来替代待删除节点的值
     */
    public int successor(TreeNode root){
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }

    /**
     * 寻找前驱节点
     *先取当前节点的左节点，然后取该节点的右节点，
     * 直到右节点为空，则最后指向的节点为前驱节点。
     * @param root 待删除节点
     * @return  左子树最大节点的值，用来替代待删除节点的值
     */
    public int predecessor(TreeNode root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }

    /**
     *  * 另：
     *  * 假如要删除的节点为叶节点，直接删除
     *  * 假如要删除的节点左节点不为空但右节点为空，则直接用左节点替换当前节点
     *  * 假如要删除的节点右节点不为空但左节点为空，则直接用右节点替换当前节点
     *  * 最后要删除的节点左右均不为空，寻找右子树中最左节点，用这个最左节点（就是后继节点）替换当前节点，并且将最左节点从原位置删除
     * @param root  根节点
     * @param key  待删节点的值
     * @return  新二叉搜索树
     */
    public TreeNode deleteNode2(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            if(root.left != null && root.right != null){
                TreeNode node = root;
                TreeNode next = root.right;
                while(next.left != null){
                    node = next;
                    next = next.left;
                }
                if(node != root){
                    node.left = next.right;   // prev.left = next.right;
                }else{
                    node.right = next.right;  //prev.right = next.right;
                }
                root.val = next.val;
            }else if(root.left == null){
                return root.right;
            }else{
                return root.left;
            }
        }
        return root;
    }
}
