import java.io.PrintWriter;

/* Class AVLTree */
class AVLTree
{
    private AVLNode root;

    /* Constructor */
    public AVLTree()
    {
       //Complete Your Code Here
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        //Complete Your Code Here
    }
    /* Make the tree logically empty */
    public void makeEmpty()
    {
        //Complete Your Code Here
    }
    /* Function to insert data */
    public void insert(Comparable data)
    {
        //Complete Your Code Here
    }
    /* Function to get height of node */
    private int height(AVLNode t )
    {
        //Complete Your Code Here
    }
    /* Function to max of left/right node */
    private int max(int lhs, int rhs)
    {
        //Complete Your Code Here
    }
    /* Function to insert data recursively */
    private AVLNode insert(Comparable x, AVLNode t)
    {
        //Complete Your Code Here
    }
    /* Rotate binary tree node with left child */
    private AVLNode rotateWithLeftChild(AVLNode k2)
    {
        //Complete Your Code Here
    }

    /* Rotate binary tree node with right child */
    private AVLNode rotateWithRightChild(AVLNode k1)
    {
        //Complete Your Code Here
    }
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private AVLNode doubleWithLeftChild(AVLNode k3)
    {
        //Complete Your Code Here
    }
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */
    private AVLNode doubleWithRightChild(AVLNode k1)
    {
        //Complete Your Code Here
    }
    /* Functions to count number of nodes */
    public int countNodes()
    {
        //Complete Your Code Here
    }
    private int countNodes(AVLNode r)
    {
        //Complete Your Code Here
    }
    /* Functions to search for an element */
    public boolean search(Comparable val)
    {
        //Complete Your Code Here
    }
    private boolean search(AVLNode r, Comparable val)
    {
        //Complete Your Code Here
    }
    /* Function for inorder traversal */
    public void inorder(PrintWriter out)
    {
        //Complete Your Code Here
    }
    private void inorder(AVLNode r, PrintWriter out)
    {
        //Complete Your Code Here
    }

    public int[] getPrivateKey(String sIndex) {
        //Complete Your Code Here
    }

    private int[] getPrivateKey(AVLNode r, String sIndex) {
        //Complete Your Code Here
    }
}