import java.util.LinkedList;

public class LinkList {

    public static void linkedList(LinkedList<Integer> one, LinkedList<Integer> two) {
        LinkedList<Integer> three = new LinkedList<Integer>();
        for (int i = 0; i < one.size(); i++) {
            three.add(one.getFirst() + two.getFirst());
            one.removeFirst();
            two.removeFirst();


        }
        System.out.println(three);
    }
}

