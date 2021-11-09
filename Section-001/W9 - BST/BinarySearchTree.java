public class BinarySearchTree {
    private BSTNode root = null;

    public void printInOrder(){
        if(root == null){
            System.out.println("Nothing in the tree... Yet");
        }
        else{
            System.out.printf("Height: %d\n", this.root.getHeight());
            System.out.printf("Balance: %d\n", this.root.getBalance());
            this.root.print(0);
        }
    }

    public void insert(int newValue){
        if(this.root == null){
            BSTNode newNode = new BSTNode();
            newNode.value = newValue;
            newNode.left = null;
            newNode.right = null;
            newNode.parent = null;

            this.root = newNode;
        }
        else{
            this.root.insert(newValue);
        }
    }
    /*
                        10
                   5         15
                2     7    12    20
     */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);
        tree.insert(12);
        tree.insert(20);
        tree.insert(3);
        tree.insert(13);
        tree.printInOrder();

    }
}
