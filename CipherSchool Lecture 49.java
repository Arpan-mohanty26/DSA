
class node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree
{
    Node root;
    BinaryTree(int data)
    {
        this.root = new Node(data);
    }

    int TreeSum(Node root)
    {
        if(root == null) return 0;
        return root.data + TreeSum(root.left) + TreeSum(root.right);
    }

    int countNodes(Node root)
    {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + leafNodes(root.right);
    }

    int leafNodes(Node root)
    {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return leafNodes(root.left) + leafNodes(root.right);
    }

    int height(Node root)
    {
        if(root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    void printAtLevel(Node root, int level)
    {
        if(root == null) return;
        if(level == 0)
        {
            System.out.println(root.data + " ");
            return;
        }
        printAtLevel(root.left, level - 1);
        printAtLevel(root.right, level - 1);
        System.out.println();
    }

    void preOrder(Node root)
    {
        if(root == null) return;
        System.out.println(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void inOrder(Node root)
    {
        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);
    }

    void postOrder(Node root)
    {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data + " ");
    }

    boolean isIdentical(Node root1, Node root2)
    {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return root1.data == root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    boolean isMirror(Node root1, Node root2)
    {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return root1.data == root2.data && isMirror(root1.left, root2.left) && isMirror(root1.right, root2.right);
    }

    void toMirror(Node root)
    {
        if(root == null) return;
        Node temp = root.left;
        root.left = root.right;
        toMirror(root.left);
    }

}
