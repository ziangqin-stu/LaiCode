package Queue_Stacks;

public class MyStack_LinkedList {

    private ListNode head;
    private int size;

    public MyStack_LinkedList() {
        this.head = new ListNode(0);
        this.size = 0;
    }

    public void push(int val) {
        // insert at head
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        this.size++;
    }

    public Integer pop() {
        if (head.next != null) {
            int res = head.next.value;
            head.next.next = head.next;
            this.size--;
            return res;
        } else {
            return null;
        }
    }

    public Integer peek() {
        if (head.next != null) {
            return head.next.value;
        } else {
            return null;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size > 0;
    }
}
