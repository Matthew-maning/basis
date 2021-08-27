package com.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/23
 * Description: com.designpatterns.composite
 * Version: V1.0
 */

public class CompositeTest {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode rootBranch1 = new BranchNode("branch1");
        BranchNode rootBranch2 = new BranchNode("branch2");
        LeafNode rootLeaf1 = new LeafNode("leaf1");
        LeafNode rootBranch1Leaf1 = new LeafNode("leaf1");
        LeafNode rootBranch1Leaf2 = new LeafNode("leaf2");
        BranchNode rootBranch2Branch1 = new BranchNode("branch2_1");
        LeafNode rootBranch2Branch1Leaf1 = new LeafNode("leaf2_1_1");
        LeafNode rootBranch2Branch1Leaf2 = new LeafNode("leaf2_1_2");

        root.add(rootBranch1);
        root.add(rootBranch2);
        root.add(rootLeaf1);
        rootBranch1.add(rootBranch1Leaf1);
        rootBranch1.add(rootBranch1Leaf2);
        rootBranch2.add(rootBranch2Branch1);
        rootBranch2Branch1.add(rootBranch2Branch1Leaf1);
        rootBranch2Branch1.add(rootBranch2Branch1Leaf2);

        tree(root, 0);

    }

    static void tree(Node b, int depth) {
        for(int i=0; i<depth; i++) System.out.print("\t");
        b.printNode();

        if(b instanceof BranchNode) {
            for (Node n : ((BranchNode)b).nodes) {
                tree(n, depth + 1);
            }
        }
    }

}



abstract class Node {
    String name;

    public Node(String name) {
        this.name = name;
    }

    void printNode() {
        System.out.println(name);
    };
}

class BranchNode extends Node {
    List<Node> nodes = new ArrayList<>();

    public BranchNode(String name) {
        super(name);
    }

    public void add(Node node) {
        nodes.add(node);
    }
}

class LeafNode extends Node {
    public LeafNode(String name) {
        super(name);
    }
}
