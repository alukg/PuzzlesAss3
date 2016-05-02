/* Class AVLNode */
class AVLNode
{
    AVLNode left, right;
    Integer key;
    String riddle;
    int height;

    /* Constructor */
    public AVLNode()
    {
        left = null;
        right = null;
        key = null;
        riddle =null;
        height = 0;
    }
    /* Constructor */
    public AVLNode(Integer n, String riddle)
    {
        left = null;
        right = null;
        key = n;
        this.riddle = riddle;
        height = 0;
    }
}
 