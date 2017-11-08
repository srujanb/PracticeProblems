public class VTTNode {

    int value;

    VTTNode left,right;

    Integer hDist;

    public void setValue(int val){
        value = val;
    }

    public int getValue(){
        return value;
    }

    public void setLeft(VTTNode node){
        left = node;
    }

    public void setRight(VTTNode node){
        right = node;
    }

    public void sethDist(int dist){
        hDist = dist;
    }

    public VTTNode getLeft(){
        return left;
    }

    public VTTNode getRight(){
        return right;
    }

    public Integer gethDist() {
        return hDist;
    }
}
