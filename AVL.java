public class AVL {
    static class Node{
        int key;
        int height;
        Node left;
        Node right;

        public Node(int key){
            this.key = key;
            this.height = 1;
        }
    }
    Node root;
    public int height(Node root){
        if ( root == null){
            return 0;
        }
        return root.height;
    }
    public int max(int a, int b){
        return (a>b) ? a : b;
    }
    public Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) +1;

        return x;
    }
    public Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2
                ;

        x.height = max(height(x.left), height(x.right))+1;
        y.height = max(height(y.left), height(y.right)) +1;
        return y;
    }
    public int getBalance(Node root){
        if (root == null){
            return 0;
        }
        return height(root.left) - height(root.right);
    }
    public Node insert(Node node , int key ){
        if (node == null){
            return (new Node(key));

        }
        if (key<node.key){
            node.left = insert(node.left, key);
        }
        else if (key>node.key){
            node.right = insert(node.right, key);

        }
        else {
            return node;
        }
        node.height = 1+ max(height((node.left)), height(node.right));
        int balance = getBalance(node);
        if(balance > 1 && key < node.left.key){
            return rightRotate(node);
        }
        if (balance < -1 && key > node.right.key){
            return leftRotate(node);

        }
        if (balance> 1 && key > node.left.key){
            node.left = leftRotate(node.left);
            return rightRotate(node);

        }
        if (balance< -1 && key < node.right.key){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    public void printInorder(Node node){
        if (node == null){
            return;
        }
        printInorder(node.left);;
        System.out.println(node.key+"");
        printInorder(node.right);
    }

    public static void main(String[] args) {
    AVL tree = new AVL();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);

        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Inorder Traversal "+" of constructed tree is :");
        tree.printInorder(tree.root);
    }
}
