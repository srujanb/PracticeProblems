import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalTreeTraversal {

    static Map<Integer,List<Integer>> map = new HashMap();

    public static void main(String args[]){

        VTTNode node1 = new VTTNode();
        VTTNode node2 = new VTTNode();
        VTTNode node3 = new VTTNode();
        VTTNode node4 = new VTTNode();
        VTTNode node5 = new VTTNode();
        VTTNode node6 = new VTTNode();
        VTTNode node7 = new VTTNode();
        VTTNode node8 = new VTTNode();

        node1.setValue(1);
        node2.setValue(2);
        node3.setValue(3);
        node4.setValue(4);
        node5.setValue(5);
        node6.setValue(6);
        node7.setValue(7);
        node8.setValue(8);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node6.setRight(node8);

        traverseNode(node1,0);

        System.out.println("Size of map :" + map.keySet().size());
        for (int i:map.keySet()){
            List<Integer> list =  map.get(i);
            for (Integer val:list){

                System.out.printf("" + val + ", ");

            }
            System.out.println();
        }
    }

    private static void traverseNode(VTTNode currentNode,int hDistance) {

        currentNode.sethDist(hDistance);
        List<Integer> list = map.get(hDistance);
        if (list == null)
            list = new ArrayList<>();
        list.add(currentNode.getValue());
        map.put(hDistance,list);

        if (currentNode.getLeft() != null)
            traverseNode(currentNode.getLeft(),hDistance-1);
        if (currentNode.getRight() != null)
            traverseNode(currentNode.getRight(),hDistance+1);


    }

}
