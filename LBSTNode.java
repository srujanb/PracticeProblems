public class LBSTNode {

    private int value;
    private LBSTNode left,right;
    Boolean isBST;
    private int maxBST;
    private int maxBSTNode;


    public int getMaxBSTNode() {
        return maxBSTNode;
    }

    public void setMaxBSTNode(int maxBSTNode) {
        this.maxBSTNode = maxBSTNode;
    }


    public int getMaxBST() {
        return maxBST;
    }

    public void setMaxBST(int maxBST) {
        this.maxBST = maxBST;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LBSTNode getLeft() {
        return left;
    }

    public void setLeft(LBSTNode left) {
        this.left = left;
    }

    public LBSTNode getRight() {
        return right;
    }

    public void setRight(LBSTNode right) {
        this.right = right;
    }

//    public Boolean isNodeBST(){
//        if (this.getLeft().isBST && this.getRight().isBST)
//            if (this.getLeft().getValue() < this.value && this.getRight().getValue() > this.value)
//                return true;
//        return false;
//    }



}
