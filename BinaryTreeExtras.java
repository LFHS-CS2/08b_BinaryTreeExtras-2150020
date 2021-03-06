class BinaryTreeExtras
{

    /**
     * Given two binary trees, return true if they are structurally identical 
     * i.e. they are made of nodes with the same values arranged in the same way. 
     */
    static boolean sameTree(TreeNode a, TreeNode b) 
    {
      if(a==null || b==null){
        return (a==null && b==null);
      }
      if(!a.getValue().equals(b.getValue())){
        return false;
      }
      return (sameTree(a.getLeft(),b.getLeft()) && sameTree(a.getRight(),b.getRight()));
    }

    /**
     * This function returns true if root2 is a subtree of root1, 
     * otherwise false 
     */
    static boolean isSubtree(TreeNode root1, TreeNode root2) 
    {
      TreeNode t = find(root2,root1);
      if(t==null){
        return false;
      }
      return sameTree(t,root2);
    }

    static TreeNode find(TreeNode f, TreeNode root) {
    if(root==null){
      return null;
    }
    if(root.getValue().equals(f.getValue())){
      return root;
    }
    TreeNode l = find(f,root.getLeft());
    TreeNode r = find(f,root.getRight());
    if(l==null){
      return r;
    }
    return l;
  }

    /**
     * Change a tree so that the  left and right 
     * pointers are swapped at every node.  
     *  So the tree... 	is changed to...
     *       4 	       4 
     *      / \ 	       / \ 
     *     2   5 	     5   2 
     *    / \ 	        / \ 
     *   1   3 	       3   1 
     */
    static public void mirror(TreeNode root)
    {
      if(root==null){
        return;
      }
      TreeNode temp = root.getLeft();
      root.setLeft(root.getRight());
      root.setRight(temp);
      mirror(root.getLeft());
      mirror(root.getRight());
    }

}