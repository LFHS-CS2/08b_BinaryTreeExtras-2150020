import static org.junit.Assert.*;
import org.junit.*;

public class BinaryTreeExtrasTest {

    public static void main(String[] args) {
        BinaryTreeExtrasTest b = new BinaryTreeExtrasTest();
        b.test_all();
    }    


    @Test
    public void test_all() {

        // TREE 1
        /* Construct the following tree
        26
        /   \
        10     3
        /    \     \
        4      6      3
        \
        30  */
        TreeNode root1 = new TreeNode(26);
        TreeNode r1 = new TreeNode(3);
        root1.setRight(r1);
        TreeNode rr1 = new TreeNode(3);
        r1.setRight(rr1);
        TreeNode l1 = new TreeNode(10);
        root1.setLeft(l1);
        TreeNode ll1 = new TreeNode(4);
        l1.setLeft(ll1);
        TreeNode llr1 = new TreeNode(30);
        ll1.setRight(llr1);
        TreeNode lr1 = new TreeNode(6);
        l1.setRight(lr1);

        TreeNode root2 = new TreeNode(26);
        TreeNode r2 = new TreeNode(3);
        root2.setRight(r2);
        TreeNode rr2 = new TreeNode(3);
        r2.setRight(rr2);
        TreeNode l2 = new TreeNode(10);
        root2.setLeft(l2);
        TreeNode ll2 = new TreeNode(4);
        l2.setLeft(ll2);
        TreeNode llr2 = new TreeNode(30);
        ll2.setRight(llr2);
        TreeNode lr2 = new TreeNode(6);
        l2.setRight(lr2);

        // TREE 2
        /* Construct the following tree
        10
        /    \
        4      6
        \
        30  */

        TreeNode l3 = new TreeNode(10);
        TreeNode ll3 = new TreeNode(4);
        l3.setLeft(ll3);
        TreeNode llr3 = new TreeNode(30);
        ll3.setRight(llr3);
        TreeNode lr3 = new TreeNode(6);
        l3.setRight(lr3);

        TreeNode r4 = new TreeNode(10);
        TreeNode rr4 = new TreeNode(4);
        r4.setRight(rr4);
        TreeNode rrl4 = new TreeNode(30);
        rr4.setRight(rrl4);
        TreeNode rl4 = new TreeNode(6);
        r4.setRight(rl4);

        System.out.print("Testing sameTree(1)...");
        boolean result = BinaryTreeExtras.sameTree(root1, root2);
        if (result)
            System.out.println("success");
        else
            failure("failure: Tree 1 should be same as Tree 2");
        System.out.print("Testing sameTree(2)...");
        result = BinaryTreeExtras.sameTree(root1, l3);
        if (!result)
            System.out.println("success");
        else
            failure("failure: Tree 1 should not be same as Tree 2");
        System.out.print("Testing sameTree(3)...");
        result = BinaryTreeExtras.sameTree(null, null);
        if (result)
            System.out.println("success");
        else
            failure("failure:  Both trees null but says not same");

        System.out.print("Testing subTree(1)...");
        result = BinaryTreeExtras.isSubtree(root1, l3);
        if (result)
            System.out.println("success");
        else
            failure("failure: Tree 3 should be a subtree of Tree 1");
        System.out.print("Testing subTree(2)...");
        result = BinaryTreeExtras.isSubtree(l3, root1);
        if (!result)
            System.out.println("success");
        else
            failure("failure: Tree 1 should not a subtree of Tree 3");

        testMirror();
    }

    public void testMirror()
    {
        // TREE 2
        /* Construct the following tree
        10
        /    \
        4      6
        \
        30  */

        TreeNode l3 = new TreeNode(10);
        TreeNode ll3 = new TreeNode(4);
        l3.setLeft(ll3);
        TreeNode llr3 = new TreeNode(30);
        ll3.setRight(llr3);
        TreeNode lr3 = new TreeNode(6);
        l3.setRight(lr3);

        TreeNode r4 = new TreeNode(10);
        TreeNode rr4 = new TreeNode(4);
        r4.setRight(rr4);
        TreeNode rrl4 = new TreeNode(30);
        rr4.setLeft(rrl4);
        TreeNode rl4 = new TreeNode(6);
        r4.setLeft(rl4);

        BinaryTreeExtras.mirror(l3);
        System.out.print("Testing mirror...");
        if (BinaryTreeExtras.sameTree(l3, r4))
            System.out.println("success");
        else
            failure("failure: mirror did not work");
    }
    
    static public void failure(String str) {
        System.out.println(str + "\n");
        fail(str);
    }
}
