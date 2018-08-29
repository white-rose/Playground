package com.crystal.Practice.Geeks4Geeks;

// Tree node
class Node
{
    int data;
    Node left, right;

    // Constructor
    Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

class Values {
    int max, min;
}

public class VerticalBinaryTree {

    Node root;
    static Values val = new Values();

    //Get Minimum & Maximum
    static void findMinMax(Node node, Values min, Values max, int hd) {

        if (node == null)
            return;

        // Update min and max
        if (hd < min.min)
            min.min = hd;
        else if (hd > max.max)
            max.max = hd;

        // Recur for left and right subtrees
        findMinMax(node.left, min, max, hd - 1);
        findMinMax(node.right, min, max, hd + 1);
    }


    static void printVerticalLine(Node node, int line_no, int hd) {

        //Base case
        if (node == null)
            return;

        if (hd == line_no)
            System.out.print(node.data + "");

        printVerticalLine(node.left, line_no, hd - 1);
        printVerticalLine(node.right, line_no, hd + 1);

    }

    static void verticalOrder(Node node) {

        findMinMax(node, val, val, 0);

        for (int line_no = val.min; line_no <= val.max; line_no++)
        {
            printVerticalLine(node, line_no, 0);
            System.out.println("");
        }

    }

    // Driver program to test above functions
    public static void main(String[] args) {

        // TO DO Auto-generated method stub
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        verticalOrder(root);

    }

}
