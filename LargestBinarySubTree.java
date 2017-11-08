public class LargestBinarySubTree {

    public static void main(String args[]){

//        Creating dummy nodes
        LBSTNode node1 = new LBSTNode();
        LBSTNode node2 = new LBSTNode();
        LBSTNode node3 = new LBSTNode();
        LBSTNode node4 = new LBSTNode();
        LBSTNode node5 = new LBSTNode();
        LBSTNode node6 = new LBSTNode();
        LBSTNode node7 = new LBSTNode();
        LBSTNode node8 = new LBSTNode();
        LBSTNode node9 = new LBSTNode();

//        Adding dummy values
        node1.setValue(1);
        node2.setValue(2);
        node3.setValue(3);
        node4.setValue(4);
        node5.setValue(5);
        node6.setValue(6);
        node7.setValue(7);
        node8.setValue(8);
        node9.setValue(9);

//        Creating dummy tree
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node7.setRight(node8);
        node8.setRight(node9);

//        Let the magic happen.
        LBSTNode answer = getHighestBSTrootNode(node1);

//        print out the results
        System.out.println("node: " + answer.getMaxBSTNode());
        System.out.println("BST value: " + answer.getMaxBST());

    }

    @SuppressWarnings("Duplicates")
    private static LBSTNode getHighestBSTrootNode(LBSTNode node) {

        LBSTNode leftNode = null;
        LBSTNode rightNode = null;
        if (node.getLeft() != null)
            leftNode = getHighestBSTrootNode(node.getLeft());
        if (node.getRight() != null)
            rightNode = getHighestBSTrootNode(node.getRight());

//      for node without any children
        if (leftNode == null && rightNode == null){
            node.isBST = true;
            node.setMaxBST(1);
            node.setMaxBSTNode(node.getValue());
            return node;
        }

//      if has only one child
        if (leftNode == null){
            if (!rightNode.isBST){
                node.isBST = false;
                node.setMaxBSTNode(rightNode.getMaxBSTNode());
                node.setMaxBST(rightNode.getMaxBST());
                return node;
            }else{
                if (node.getValue() < rightNode.getValue()){
                    node.isBST = true;
                    node.setMaxBSTNode(node.getValue());
                    node.setMaxBST(rightNode.getMaxBST() + 1);
                    return node;
                }else{
                    node.isBST = false;
                    node.setMaxBSTNode(rightNode.getMaxBSTNode());
                    node.setMaxBST(rightNode.getMaxBST());
                    return node;
                }
            }
        }else if (rightNode == null){
            if (!leftNode.isBST){
                node.isBST = false;
                node.setMaxBSTNode(leftNode.getMaxBSTNode());
                node.setMaxBST(leftNode.getMaxBST());
                return node;
            }else{
                if (leftNode.getValue() < node.getValue()){
                    node.isBST = true;
                    node.setMaxBSTNode(node.getValue());
                    node.setMaxBST(leftNode.getMaxBST() + 1);
                    return node;
                }else{
                    node.isBST = false;
                    node.setMaxBSTNode(leftNode.getMaxBSTNode());
                    node.setMaxBST(leftNode.getMaxBST());
                    return node;
                }
            }
//      for nodes with two children
        }else{
            if (leftNode.getValue() < node.getValue() && node.getValue() < rightNode.getValue()){
                node.isBST = true;
                node.setMaxBSTNode(node.getValue());
                node.setMaxBST(leftNode.getMaxBST() + rightNode.getMaxBST() + 1);
                return node;
            }else{
                node.isBST = false;
                node.setMaxBSTNode(leftNode.getValue() > rightNode.getValue()?leftNode.getMaxBSTNode():rightNode.getMaxBSTNode());
                node.setMaxBST(leftNode.getMaxBST() > rightNode.getMaxBST()?leftNode.getMaxBST():rightNode.getMaxBST());
                return node;
            }
        }

    }

}
