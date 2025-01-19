public class BinarySearchTree {
   static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key){
            this.key = key;
            this.left = null;
            this.right = null;
        }
       @Override
       public String toString() {
           return Integer.toString(this.key);
       }
    }
    Node root;
    public BinarySearchTree(int key){

        root = new Node(key);


    }
    public BinarySearchTree(){
        root = null;
    }

    public void postorder(Node root){
        if (root == null){
            return;
        }
        postorder(root.left);;
        postorder(root.right);
        System.out.print(root.key+" ");
    }
    public void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.key+" ");
        inorder(root.right);
    }
    public void preorder(Node root){
        if (root == null){
            return;
        }
        preorder(root.left);
        System.out.print(root.key+" ");
        preorder(root.right);
    }
    public Node Search(Node root, int key){
        if (root == null || root.key == key){
            return root;
        }
        if (root.key > key){
            return Search(root.left, key);
        }
        else {
            return Search(root.right, key);
        }
    }
    public Node insertion(Node root, int key){
        if (root== null){
            root = new Node(key);
            return root;
        }
        else {
            if (root.key > key){
                root.left = insertion(root.left, key);
            }
            else if (root.key<key){
                root.right = insertion(root.right, key);
            }
        }
        return root;
    }
    public Node deleteReo(Node root, int key){
if (root == null){
    return root;
}
if (root.key> key){
    root.left = deleteReo(root.left, key);
}
else if (root.key<key){
    root.right = deleteReo(root.right, key);
}
else {
    if (root.left == null){
        return root.right;
    }
    else if (root.right == null){
        return root.left;
    }
    root.key = minVal(root.right);
    root.right = deleteReo(root.right, root.key);
}
return root;
    }
    public int minVal(Node root){
        int minV  = root.key;
        while (root.left != null){
            minV = root.left.key;
            root = root.left;
        }
        return  minV;
    }
    public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    tree.root = new Node(8);
    Node a = new Node(3);
    tree.root.left = a;
        Node b = new Node(10);
        tree.root.right = b;

        a.left = new Node(1);
        a.right = new Node(6);

        b.left = new Node(9);
        b.right = new Node(14);

        System.out.println("Pree order");
        tree.preorder(tree.root);
        System.out.println("In order");
        tree.inorder(tree.root);
        System.out.println("Post order");
        tree.postorder(tree.root);

        System.out.println("Searching ");
        System.out.print(tree.Search(tree.root, 3));
        tree.insertion(tree.root, 7);

//        if (tree.Search(tree.root, 3) != null){
//
//        }
        System.out.println("");
        System.out.println("Pree order");
        tree.preorder(tree.root);
        System.out.println("In order");
        tree.inorder(tree.root);
        System.out.println("Post order");
        tree.postorder(tree.root);

        tree.deleteReo(tree.root, 6);
    }
}
