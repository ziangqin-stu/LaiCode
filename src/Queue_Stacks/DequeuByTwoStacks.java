package Queue_Stacks;

import java.util.LinkedList;

public class DequeuByTwoStacks {
    private LinkedList<Integer> head;
    private LinkedList<Integer> tail;
    private int size;

    public DequeuByTwoStacks() {
        tail = new LinkedList<Integer>();
        head = new LinkedList<Integer>();
        size = 0;
    }

    public Integer offerFirst(int element) {
        head.offerFirst(element);
        size++;
        return element;
    }

    public Integer offerLast(int element) {
        tail.offerFirst(element);
        size++;
        return element;
    }

    public Integer pollFirst() {
        if (head.isEmpty()) {
            // pour element(s) of tail into head;
            pour(tail, head);
        }
        if (head.peekFirst() != null) {
            size--;
        }
        return head.pollFirst();
    }

    public Integer pollLast() {
        if (tail.isEmpty()) {
            // pour element(s) of head into tail;
            pour(head, tail);
        }
        if (tail.peekFirst() != null) {
            size--;
        }
        return tail.pollFirst();
    }

    public Integer peekFirst() {
        if (head.isEmpty()) {
            // pour element(s) of tail into head;
            pour(tail, head);
        }
        return head.peekFirst();
    }

    public Integer peekLast() {
        if (tail.isEmpty()) {
            // pour element(s) of head into tail;
            pour(head, tail);
        }
        return tail.peekFirst();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void pour(LinkedList<Integer> s1, LinkedList<Integer> s2) {
        while(!s1.isEmpty()) {
            s2.offerFirst(s1.pollFirst());
        }
    }

    public static void main(String[] args) {
        DequeuByTwoStacks sol = new DequeuByTwoStacks();
        System.out.println(sol.pollLast());
        System.out.println(sol.peekFirst());
        System.out.println(sol.offerLast(217));
        System.out.println(sol.peekFirst());
        System.out.println(sol.offerFirst(188));
        System.out.println(sol.pollLast());
        System.out.println(sol.isEmpty());
        System.out.println(sol.offerLast(77));
        System.out.println(sol.offerFirst(234));
        System.out.println(sol.peekLast());
        System.out.println(sol.pollFirst());
    }
}
