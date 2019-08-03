package Queue_Stacks;

import java.util.LinkedList;

public class DequeueByThreeStacks {

    private LinkedList<Integer> head;
    private LinkedList<Integer> tail;
    private LinkedList<Integer> bufferStack;
    private int size;

    public DequeueByThreeStacks() {
        head = new LinkedList<Integer>();
        tail = new LinkedList<Integer>();
        bufferStack = new LinkedList<Integer>();
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
            // pour half of elements in tail into head;
            pour(tail, head, bufferStack);
        }
        return head.pollFirst();
    }

    public Integer pollLast() {
        if (tail.isEmpty()) {
            // pour half of elements in head into tail;
            pour(head, tail, bufferStack);
        }
        return tail.pollFirst();
    }

    public Integer peekFirst() {
        if (head.isEmpty()) {
            // pour half of elements in tail into head;
            pour(tail, head, bufferStack);
        }
        return head.peekFirst();
    }

    public Integer peekLast() {
        if (tail.isEmpty()) {
            // pour half of elements in head into tail;
            pour(head, tail, bufferStack);
        }
        return tail.peekFirst();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void pour(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> buffer) {
        // TODO: pour half of elements in s1 into s2
        for (int counter = s1.size() + 1; s1.size() > counter / 2; ) {
            buffer.offerFirst(s1.pollFirst());
        }
        while (!s1.isEmpty()) {
            s2.offerFirst(s1.pollFirst());
        }
        while (!buffer.isEmpty()) {
            s1.offerFirst(buffer.pollFirst());
        }
    }

    public static void main(String[] args) {
        DequeueByThreeStacks sol = new DequeueByThreeStacks();
        System.out.println(sol.pollLast());
//        System.out.println(sol.peekFirst());
//        System.out.println(sol.offerLast(217));
//        System.out.println(sol.peekFirst());
//        System.out.println(sol.offerFirst(188));
//        System.out.println(sol.pollLast());
//        System.out.println(sol.isEmpty());
//        System.out.println(sol.offerLast(77));
//        System.out.println(sol.offerFirst(234));
//        System.out.println(sol.peekLast());
//        System.out.println(sol.pollFirst());

        System.out.println(sol.offerFirst(239));
        System.out.println(sol.size());
        System.out.println(sol.pollLast());
        System.out.println(sol.pollLast());
    }
}
