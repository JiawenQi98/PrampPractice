/**
 * Created by qijiawen on 8/19/17.
 */
public class LargestSmallerBSTKey {

    static class Node {
        int key;
        Node left;
        Node right;
        Node parent;

        Node(int key) {
            this.key = key;
            left = null;
            right = null;
            parent = null;
        }
    }

    static class BinarySearchTree {

        Node root;

        int findLargestSmallerKey(int num) {
            // your code goes here
            int result = -1;
            Node cur = root;

            while (cur != null) {
                if (cur.key < num) {
                    result = cur.key;
                    cur = cur.right;
                }
                else {
                    cur = cur.left;
                }
            }

            return result;
        }

        /**
         * inserts a new node with the given key in the correct place in the tree
         * @param key
         */
        void insert(int key) {
            // 1) if the tree is empty, create the root
            if (this.root == null) {
                this.root = new Node(key);
                return;
            }

            // 2) otherwise, create a node with the key and traverse down the tree to find where to insert the new node
            Node currentNode = this.root;
            Node newNode = new Node(key);
            while (currentNode != null) {
                if (key < currentNode.key) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        newNode.parent = currentNode;
                        break;
                    }
                    else{
                        currentNode = currentNode.left;
                    }
                }
                else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        newNode.parent = currentNode;
                        break;
                    }
                    else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }
    }

    public static void main (String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(20);
        bst.insert(9);
        bst.insert(25);
        bst.insert(5);
        bst.insert(12);
        bst.insert(11);
        bst.insert(14);

        int result = bst.findLargestSmallerKey(17);
        System.out.println("Largest smaller number of 17 is: " + result);
        result = bst.findLargestSmallerKey(4);
        System.out.println("Largest smaller number of 4 is: " + result);
        result = bst.findLargestSmallerKey(26);
        System.out.println("Largest smaller number of 26 is: " + result);
    }
}
